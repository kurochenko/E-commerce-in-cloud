package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.DeliveryTypeDAO;
import cz.muni.fi.bapr.entity.DeliveryType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class DeliveryTypeDAOImpl extends AbstractParamSearchDAOImpl<DeliveryType> implements DeliveryTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public DeliveryTypeDAOImpl() {
        super(DeliveryType.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public DeliveryType findByName(String name) {
        return super.findByParam("name", name);
    }
}
