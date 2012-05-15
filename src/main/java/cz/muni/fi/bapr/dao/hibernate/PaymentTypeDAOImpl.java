package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.PaymentTypeDAO;
import cz.muni.fi.bapr.entity.PaymentType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class PaymentTypeDAOImpl extends AbstractDAO<PaymentType> implements PaymentTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public PaymentType findByName(String name) {
        return super.findByParam("name", name);
    }
}
