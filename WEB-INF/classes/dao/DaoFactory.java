package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// class Factory, simple Factory pattern. It is not in Gang of Four.
public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() throws Exception {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            DaoFactory instance = new DaoFactory(
                    "jdbc:mariadb://localhost:3306/clinic20231222", "root",
                    "root");
            return instance;
        } catch (ClassNotFoundException e) {
        }
        throw new Exception();
    }
    public Connection getConnection() throws SQLException {
        Connection connexion =  DriverManager.getConnection(url, username,
                password);
        connexion.setAutoCommit(false);
        return connexion;
    }
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }
    public DoctorDao getDoctorDao() {
        return new DoctorDaoMariaDB(this);
    }
    public SpecialtyDao getSpecialtyDao() {
        return new SpecialtyDaoMariaDB(this);
    }
    public ServiceDao getServiceDao() {
        return new ServiceDaoMariaDB(this);
    }
    public NurseDao getNurseDao() {
        return new NurseDaoMariaDB(this);
    }
    public EmailDao getEmailDao() {
        return new EmailDaoMariaDB(this);
    }
}
