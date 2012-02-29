package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.OrderProductDAO;
import cz.muni.fi.bapr.entity.OrderProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class OrderProductDAOImpl extends AbstractDAOImpl<OrderProduct> implements OrderProductDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public OrderProductDAOImpl() {
        super(OrderProduct.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
