package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import beans.Service;
import beans.BeanException;

public class ServiceDaoMariaDB implements ServiceDao {
    private DaoFactory daoFactory;

    ServiceDaoMariaDB(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private String findAllSql() {
        return "SELECT service_id, code, name, building_id, doctor_id " +
            "FROM services; ";
    }

    private Service getService(ResultSet result) throws Exception {
        int id = result.getInt("service_id");
        int code = result.getInt("code");
        String name = result.getString("name");
        int building_id = result.getInt("building_id");
        int doctor_id = result.getInt("doctor_id");

        Service service = new Service();
        service.setId(id);
        service.setCode(code);
        service.setName(name);
        service.setBuilding_id(building_id);
        service.setDoctor_id(doctor_id);

        return service;
    }
    public List<Service> findAll() throws DaoException {
        try {
            List<Service> services = new ArrayList<Service>();
            Connection connexion = daoFactory.getConnection();
            Statement statement = connexion.createStatement();
            ResultSet result = statement.executeQuery(findAllSql());
            while (result.next()) {
                services.add(getService(result));
            } 
            return services;
        } catch (Exception e) {
            System.out.println(e);
            throw new DaoException(
                    "Impossible de communiquer avec la base de données");
        }
    }
}

