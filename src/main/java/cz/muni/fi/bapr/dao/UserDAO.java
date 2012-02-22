package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.User;

import java.util.List;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public interface UserDAO {

    void create(User exchangeRate);

    void edit(User exchangeRate);

    void remove(User exchangeRate);

    User find(Object id);

    List<User> findAll();

    long count();


}
