package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.Cart;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.util.OrderStats;

import java.util.List;

/**
 * DAO interface for {@code Cart} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface CartDAO extends DAOTemplate<Cart> {

    /**
     * Retrieves statistics information about customers shopping cart
     * @param customer
     * @return
     */
    OrderStats sumStats(Customer customer);

    /**
     * Retrieves all products from customers shopping cart
     * @param customer
     * @return
     */
    List<Cart> findByCustomer(Customer customer);

    /**
     * Checks if customer has product in cart
     * @param customer
     * @param product
     * @return cart which contains given product or {@code null} when product is not in customers cart
     */
    Cart matchCustomerProduct(Customer customer, Product product);
}
