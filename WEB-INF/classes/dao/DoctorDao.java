package dao;

import java.util.List;

import beans.Doctor;

public interface DoctorDao {
    void add(Doctor doctor) throws DaoException;
    List<Doctor> findAll() throws DaoException;
}
