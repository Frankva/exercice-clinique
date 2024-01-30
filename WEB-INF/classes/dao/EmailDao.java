package dao;

import java.util.List;
import beans.Email;
import beans.Person;

public interface EmailDao {
    void add(Email email, Person person) throws Exception;
    List<Email> findAll() throws Exception;
}
