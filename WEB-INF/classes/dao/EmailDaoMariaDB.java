package dao;

import java.sql.*;
import beans.Email;
import beans.Person;

public class EmailDaoMariaDB implements EmailDao {
    private DaoFactory daoFactory;

    public EmailDaoMariaDB(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public void add(Email email, Person person) throws Exception {
        System.out.println("emaildaomariadb start");
        Connection connection = null;
        try {
            connection = daoFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    addEmailSql());
            preparedStatement.setString(1, email.getName());
            preparedStatement.setString(2, person.getFirstname());
            preparedStatement.setString(3, person.getLastname());
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("emaildaomariadb end");
        } catch (Exception e) {
            System.out.println("emaildaomariadb error");
            System.out.println(e);
            rollback(connection);
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
    private String addEmailSql() {
        return "INSERT INTO emails "
            + "(name, person_id) "
            + "VALUES "
            + "(?, ( "
                + "SELECT MIN(person_id) "
                + "FROM people "
                + "WHERE firstname = ? "
                    + "AND lastname = ?"
            + "));";
    }
}
