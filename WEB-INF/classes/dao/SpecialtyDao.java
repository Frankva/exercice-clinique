package dao;

import java.util.List;

import beans.Specialty;

public interface SpecialtyDao {
    // void add(Specialty specialty) throws DaoException;
    List<Specialty> findAll() throws DaoException;
}
