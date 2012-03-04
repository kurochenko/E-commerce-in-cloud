package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.OrderDAO;
import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.PaymentType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
