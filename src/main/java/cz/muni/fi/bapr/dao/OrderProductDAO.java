package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.OrderProduct;
import cz.muni.fi.bapr.entity.Product;

import java.util.List;

/**
 * DAO interface for {@code OrderProduct} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface OrderProductDAO extends DAOTemplate<OrderProduct> {

    List<OrderProduct> findByProduct(Product product);

}
