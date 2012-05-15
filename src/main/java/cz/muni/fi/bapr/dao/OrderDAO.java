package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.PaymentType;

import java.util.List;

/**
 * DAO interface for {@code Order} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface OrderDAO extends DAOTemplate<Order> {

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
