package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import beans.Nurse;

public class NurseDaoMariaDB implements NurseDao {
    private DaoFactory daoFactory;

    public NurseDaoMariaDB(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public void add(Nurse nurse) throws Exception {
        Connection connection = null;
        try {
            connection = daoFactory.getConnection();
            addPerson(connection, nurse);
            addNurse(connection, nurse);
            connection.commit();
        } catch (Exception e) {
            System.out.println(e);
            rollback(connection);
            throw new Exception();
        }
    }
    private void addPerson(Connection connection, Nurse nurse) throws Exception
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    addPersonSql());
            preparedStatement.setString(1, nurse.getFirstname());
            preparedStatement.setString(2, nurse.getLastname());
            preparedStatement.setString(3, nurse.getAddress());
            preparedStatement.setString(4, nurse.getPhone());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception();
        }
    }
    private void addNurse(Connection connection, Nurse nurse) throws Exception
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    addNurseSql());
            preparedStatement.setString(1, nurse.getRotation());
            preparedStatement.setInt(2, nurse.getSalary());
            preparedStatement.setInt(3, nurse.getServiceId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception();
        }
    }
    public void rollback(Connection connection) {
        try {
            System.out.println("rollback start");
            connection.rollback();
            connection.close();
            System.out.println("rollback complete");
        } catch (Exception e){
            System.out.println("rollback error");
            System.out.println(e);
        }
    }
    private String addPersonSql() {
        return "INSERT INTO " +
            "people (firstname, lastname, address, phone) " +
            "VALUES (?, ?, ?, ?); ";
    }
    private String addNurseSql() {
        return "INSERT INTO " +
            "nurses (rotation, salary, person_id, service_id) " +
            "VALUES " +
            "(? , ?, (SELECT max(person_id) FROM people), ?); ";
    }
}
