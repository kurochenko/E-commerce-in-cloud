package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.CartDAO;
import cz.muni.fi.bapr.dao.OrderDAO;
import cz.muni.fi.bapr.dao.OrderProductDAO;
import cz.muni.fi.bapr.entity.*;
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

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private OrderProductDAO orderProductDAO;


    @Override
    public OrderDAO getDao() {
        return orderDAO;
    }

    @Override
    public void createAndMoveProducts(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order is null");
        }

        orderDAO.create(order);

        for (Cart cart : cartDAO.findByCustomer(order.getCustomer())) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setAmount(cart.getAmount());
            orderProduct.setProduct(cart.getProduct());
            orderProduct.setOrder(order);
            orderProductDAO.create(orderProduct);
            cartDAO.remove(cart);
        }
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

    @Override
    public List<Order> findNotAttendedByCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null");
        }

        return orderDAO.findNotAttendedByCustomer(customer);
    }

    @Override
    public List<Order> findAttendedByCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null");
        }

        return orderDAO.findAttendedByCustomer(customer);
    }

    @Override
    public List<Order> findNotAttended() {
        return orderDAO.findNotAttended();
    }

    @Override
    public List<Order> findAttended() {
        return orderDAO.findAttended();
    }
}
