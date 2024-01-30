package dao;

import beans.Email;
import beans.Person;

public interface EmailDao {
    void add(Email email, Person person) throws Exception;
}
