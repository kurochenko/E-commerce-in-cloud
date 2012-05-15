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
    /**
     * Searches for link object {@code OrderProduct} by order
     * @param order
     * @return
     */
    List<OrderProduct> findByOrder(Order order);

    /**
     * Counts stats for given order
     * @param order
     * @return
     */
    OrderStats sumStats(Order order);
}
