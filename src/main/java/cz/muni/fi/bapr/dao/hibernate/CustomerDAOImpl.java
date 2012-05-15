package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.CustomerDAO;
import cz.muni.fi.bapr.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class CustomerDAOImpl extends AbstractDAO<Customer> implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Customer findByEmail(String email) {
        return super.findByParam("email", email);
    }
}
