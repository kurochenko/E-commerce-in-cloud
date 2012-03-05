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

    List<Order> findByDeliveryType(DeliveryType deliveryType);

    List<Order> findByPaymentType(PaymentType paymentType);

    List<Order> findNotAttendedByCustomer(Customer customer);

    List<Order> findAttendedByCustomer(Customer customer);

}
