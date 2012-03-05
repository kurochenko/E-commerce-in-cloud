package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.OrderProduct;
import cz.muni.fi.bapr.util.OrderStats;

import java.util.List;

/**
 * Service interface for {@code OrderProduct} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface OrderProductService extends ServiceTemplate<OrderProduct> {
    List<OrderProduct> findByOrder(Order order);

    OrderStats sumStats(Order order);
}
