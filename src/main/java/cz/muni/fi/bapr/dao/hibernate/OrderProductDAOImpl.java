package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.OrderProductDAO;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.OrderProduct;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.util.OrderStats;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class OrderProductDAOImpl extends AbstractDAO<OrderProduct> implements OrderProductDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<OrderProduct> findByProduct(Product product) {
        return super.findListByParam("product", product);
    }

    @Override
    public List<OrderProduct> findByOrder(Order order) {
        return super.findListByParam("order", order);
    }

    @Override
    public OrderStats sumStats(Order order) {
        OrderStats result = null;

        try {
            Query query = getEntityManager().createQuery("select sum(c.amount), sum(c.amount * c.product.price), sum(c.amount * (c.product.price + (c.product.price * (c.product.vat.vat / 100)))) from OrderProduct c where c.order = :order");
            query.setParameter("order", order);
            Object[] queryResult = (Object[]) query.getSingleResult();
            result = new OrderStats();
            if (queryResult[0] != null && queryResult[1] != null && queryResult[2] != null) {
                result.setAmount(BigDecimal.valueOf((Long) queryResult[0]));
                result.setPrice((BigDecimal) queryResult[1]);
                result.setPriceVat((BigDecimal) queryResult[2]);
            }
        } catch (NoResultException e) {
        }
        return result;
    }
}
