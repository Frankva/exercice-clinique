package dao;

import java.util.List;
import beans.Service;

public interface ServiceDao {
    List<Service> findAll() throws DaoException;
}
