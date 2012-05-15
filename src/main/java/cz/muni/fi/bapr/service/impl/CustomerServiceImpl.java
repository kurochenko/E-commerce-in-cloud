package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.CustomerDAO;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code CustomerService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class CustomerServiceImpl extends AbstractServiceImpl<Customer, CustomerDAO> implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public CustomerDAO getDao() {
        return customerDAO;
    }

    @Override
    public void create(Customer entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Customer is null");
        }
        if (entity.getId() != null) {
            throw new IllegalArgumentException("Customer ID is already set");
        }
        if ((customerDAO.findByEmail(entity.getEmail())) != null) {
            throw new IllegalArgumentException("Customer with email '" + entity.getEmail() + "' already exists");
        }

        customerDAO.create(entity);
    }

    @Override
    public void edit(Customer entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Customer is null");
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("Customer ID is null");
        }

        Customer customer = customerDAO.findByEmail(entity.getEmail());

        if ((customer != null) && !customer.getId().equals(entity.getId())) {
            throw new IllegalArgumentException("Customer with email '" + entity.getEmail() + "' already exists");
        }

        customerDAO.edit(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email is null");
        }

        return customerDAO.findByEmail(email);
    }
}
