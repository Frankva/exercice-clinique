package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import beans.Specialty;
import beans.BeanException;

public class SpecialtyDaoMariaDB implements SpecialtyDao {
    private DaoFactory daoFactory;

    SpecialtyDaoMariaDB(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    private String findAllSql() {
        return "SELECT specialty_id, name " +
            "FROM specialties; ";
    }

    @Override
    public List<Specialty> findAll() throws DaoException {
        List<Specialty> specialties = new ArrayList<Specialty>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery(findAllSql());
            while (resultat.next()) {
                int id = resultat.getInt("specialty_id");
                String name = resultat.getString("name");

                Specialty specialty = new Specialty();
                specialty.setId(id);
                specialty.setName(name);

                specialties.add(specialty);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new DaoException(
                    "Impossible de communiquer avec la base de données");
        } catch (BeanException e) {
            throw new DaoException("Les données de la base sont invalides");
        }
        return specialties;
    }
}
