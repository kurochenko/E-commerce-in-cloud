package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.CartDAO;
import cz.muni.fi.bapr.entity.Cart;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.service.CartService;
import cz.muni.fi.bapr.util.OrderStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@code CartService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
public class CartServiceImpl extends AbstractServiceImpl<Cart, CartDAO> implements CartService {

    @Autowired
    private CartDAO cartDAO;


    @Override
    public CartDAO getDao() {
        return cartDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cart> findByCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null");
        }
        return cartDAO.findByCustomer(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public Cart matchCustomerProduct(Customer customer, Product product) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product is null");
        }

        return cartDAO.matchCustomerProduct(customer, product);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderStats sumStats(Customer customer) {
        return cartDAO.sumStats(customer);
    }
}
