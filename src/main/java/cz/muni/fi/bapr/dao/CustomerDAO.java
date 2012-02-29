package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Customer;

/**
 * DAO interface for {@code Customer} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface CustomerDAO extends DAOTemplate<Customer> {

    /**
     * Searches for {@code Customer} with given unique email
     *
     * @param email customer unique email
     * @return {@code Customer} or {@code null} when no customer was found with specified email
     */
    Customer findByEmail(String email);

}
