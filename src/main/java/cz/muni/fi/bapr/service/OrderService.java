package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.PaymentType;

import java.util.List;

/**
 * Service interface for {@code Order} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface OrderService extends ServiceTemplate<Order> {

    /**
     * Creates order and moves products from cart to order in one transaction
     *
     * @param order
     */
    void createAndMoveProducts(Order order);

    List<Order> findByDeliveryType(DeliveryType deliveryType);

    List<Order> findByPaymentType(PaymentType paymentType);

    List<Order> findNotAttendedByCustomer(Customer customer);

    List<Order> findAttendedByCustomer(Customer customer);

    List<Order> findNotAttended();

    List<Order> findAttended();

}
