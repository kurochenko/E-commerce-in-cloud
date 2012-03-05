package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.OrderProduct;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.util.OrderStats;

import java.util.List;

/**
 * DAO interface for {@code OrderProduct} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface OrderProductDAO extends DAOTemplate<OrderProduct> {

    List<OrderProduct> findByProduct(Product product);

    List<OrderProduct> findByOrder(Order order);

    OrderStats sumStats(Order order);

}
