package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.PaymentTypeDAO;
import cz.muni.fi.bapr.entity.PaymentType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class PaymentTypeDAOImpl extends AbstractParamSearchDAOImpl<PaymentType> implements PaymentTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public PaymentTypeDAOImpl() {
        super(PaymentType.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public PaymentType findByName(String name) {
        return super.findByParam("name", name);
    }
}
