package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Cart;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.util.CartStats;

import java.util.List;

/**
 * DAO interface for {@code Cart} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface CartDAO extends DAOTemplate<Cart> {

    public CartStats sumStats(Customer customer);

    List<Cart> findByCustomer(Customer customer);

    Cart matchCustomerProduct(Customer customer, Product product);

}
