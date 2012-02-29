package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Customer;

/**
 * Service interface for {@code Customer} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface CustomerService extends ServiceTemplate<Customer> {

    /**
     * Searches for {@code Customer} with given unique email
     *
     * @param email customer unique email
     * @return {@code Customer} or {@code null} when no customer was found with specified email
     */
    Customer findByEmail(String email);
}
