package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.OrderDAO;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.PaymentType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Order> findByDeliveryType(DeliveryType deliveryType) {
        return super.findListByParam("deliveryType", deliveryType);
    }

    @Override
    public List<Order> findByPaymentType(PaymentType paymentType) {
        return super.findListByParam("paymentType", paymentType);
    }

    @Override
    public List<Order> findNotAttendedByCustomer(Customer customer) {
        List<Order> result = new ArrayList<Order>();

        try {
            Query query = getEntityManager().createQuery("from Orders o where o.customer = :customer and o.attended = null");
            query.setParameter("customer", customer);
            result = query.getResultList();
        } catch (NoResultException e) {
        }
        return result;
    }

    @Override
    public List<Order> findAttendedByCustomer(Customer customer) {
        List<Order> result = new ArrayList<Order>();

        try {
            Query query = getEntityManager().createQuery("from Orders o where o.customer = :customer and o.attended != null");
            query.setParameter("customer", customer);
            result = query.getResultList();
        } catch (NoResultException e) {
        }
        return result;
    }
}
