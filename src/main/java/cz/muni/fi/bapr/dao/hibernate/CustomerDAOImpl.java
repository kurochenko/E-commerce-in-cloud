package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.CustomerDAO;
import cz.muni.fi.bapr.entity.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class CustomerDAOImpl extends AbstractParamSearchDAOImpl<Customer> implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public CustomerDAOImpl() {
        super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Customer findByEmail(String email) {
        return super.findByParam("email", email);
    }
}
