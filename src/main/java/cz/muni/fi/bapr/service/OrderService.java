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

    /**
     * Gets all orders with given delivery type
     * @param deliveryType
     * @return
     */
    List<Order> findByDeliveryType(DeliveryType deliveryType);

    /**
     * Gets all orders by given payment type
     * @param paymentType
     * @return
     */
    List<Order> findByPaymentType(PaymentType paymentType);

    /**
     * Gets all not-attended orders which belongs to given customer
     * @param customer
     * @return
     */
    List<Order> findNotAttendedByCustomer(Customer customer);

    /**
     * Gets all attended orders which belongs to given customer
     * @param customer
     * @return
     */
    List<Order> findAttendedByCustomer(Customer customer);

    /**
     * Gets all not-attended orders
     * @return
     */
    List<Order> findNotAttended();

    /**
     * Gets all attended orders
     * @return
     */
    List<Order> findAttended();
}
