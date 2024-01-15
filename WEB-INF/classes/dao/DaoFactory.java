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

    public static DaoFactory getInstance() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                    "jdbc:mariadb://localhost:3306/javaee", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connexion =  DriverManager.getConnection(url, username,
                password);
        connexion.setAutoCommit(false);
        return connexion;
    }

    // Récupération du Dao
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }
}
