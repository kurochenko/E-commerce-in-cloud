package cz.muni.fi.bapr.service;

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

    List<Order> findByDeliveryType(DeliveryType deliveryType);

    List<Order> findByPaymentType(PaymentType paymentType);

}
