package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.OrderDAO;
import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.PaymentType;
import cz.muni.fi.bapr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@code OrderService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderDAO> implements OrderService {

    @Autowired
    private OrderDAO orderDAO;


    @Override
    public OrderDAO getDao() {
        return orderDAO;
    }

    @Override
    public List<Order> findByDeliveryType(DeliveryType deliveryType) {
        if (deliveryType == null) {
            throw new IllegalArgumentException("Delivery type is null");
        }

        return orderDAO.findByDeliveryType(deliveryType);
    }

    @Override
    public List<Order> findByPaymentType(PaymentType paymentType) {
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment type is null");
        }

        return orderDAO.findByPaymentType(paymentType);
    }
}
