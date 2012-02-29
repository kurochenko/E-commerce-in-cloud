package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.OrderDAO;
import cz.muni.fi.bapr.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class OrderDAOImpl extends AbstractDAOImpl<Order> implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public OrderDAOImpl() {
        super(Order.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
