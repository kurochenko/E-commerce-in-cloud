package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.Cart;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.util.CartStats;

import java.util.List;

/**
 * Service interface for {@code Cart} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface CartService extends ServiceTemplate<Cart> {

    List<Cart> findByCustomer(Customer customer);

    Cart matchCustomerProduct(Customer customer, Product product);

    CartStats sumStats(Customer customer);

}
