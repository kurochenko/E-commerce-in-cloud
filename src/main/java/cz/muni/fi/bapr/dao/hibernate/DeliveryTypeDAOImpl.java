package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.DeliveryTypeDAO;
import cz.muni.fi.bapr.entity.DeliveryType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class DeliveryTypeDAOImpl extends AbstractDAO<DeliveryType> implements DeliveryTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public DeliveryType findByName(String name) {
        return super.findByParam("name", name);
    }
}
