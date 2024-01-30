package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import beans.Doctor;
import beans.BeanException;

public class DoctorDaoMariaDB implements DoctorDao {
    private DaoFactory daoFactory;

    public DoctorDaoMariaDB(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private String addSql1() {
        return "INSERT INTO " +
            "people (firstname, lastname, address, phone) " +
            "VALUES (?, ?, ?, ?); ";
    }

    private String addSql2() {
        return "INSERT INTO " +
            "doctors (specialty_id, person_id) " +
            "VALUES " +
            "(? , (SELECT max(person_id) FROM people)); ";
    }

    @Override
    public void add(Doctor doctor) throws DaoException {
            Connection connection = null;
        try {
            connection = daoFactory.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(
                    addSql1());
            System.out.println(doctor.getFirstname());
            preparedStatement1.setString(1, doctor.getFirstname());
            preparedStatement1.setString(2, doctor.getLastname());
            preparedStatement1.setString(3, doctor.getAddress());
            preparedStatement1.setString(4, doctor.getPhone());
            System.out.println(preparedStatement1);

            PreparedStatement preparedStatement2 = connection.prepareStatement(
                    addSql2());
            preparedStatement2.setInt(1, doctor.getSpecialtyId());
            System.out.println(preparedStatement2);

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                System.out.println(e);
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException(
                    "impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DaoException(
                        "impossible de communiquer avec la base de données");
            }
        }
    }

    private String findAllSql() {
        return "ROLLBACK; " +
            "SELECT firstname, lastname, address, phone, specialty_id " +
            "FROM doctors NATURAL JOIN people; ";
    }

    @Override
    public List<Doctor> findAll() throws DaoException {
        List<Doctor> doctors = new ArrayList<Doctor>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            resultat = statement.executeQuery(findAllSql());
            while (resultat.next()) {
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                String address = resultat.getString("address");
                String phone = resultat.getString("phone");
                int specialtyId = resultat.getInt("specialty_id");

                Doctor doctor = new Doctor();
                doctor.setFirstname(firstname);
                doctor.setLastname(lastname);
                doctor.setAddress(address);
                doctor.setPhone(phone);
                doctor.setSpecialtyId(specialtyId);

                doctors.add(doctor);
            }
        } catch (SQLException e) {
            throw new DaoException(
                    "Impossible de communiquer avec la base de données");
        } catch (BeanException e) {
            throw new DaoException("Les données de la base sont invalides");
        }
        return doctors;
    }
}
