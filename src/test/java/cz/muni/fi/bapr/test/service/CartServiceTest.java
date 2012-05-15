package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.CartDAO;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.service.impl.CartServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class CartServiceTest extends AbstractMockInit {

    private CartServiceImpl cartService;
    private Customer customer = new Customer();
    private Product product = new Product();
    @Mock private CartDAO cartDAO;


    @Before
    public void setUp() {
        cartService = new CartServiceImpl();
        cartService.setCartDAO(cartDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByCustomerNull() {
        cartService.findByCustomer(null);
    }

    @Test
    public void testFindByCustomer() {
        cartService.findByCustomer(customer);
        verify(cartDAO).findByCustomer(customer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatchCustomerProductNullCustomer() {
        cartService.matchCustomerProduct(null, product);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatchCustomerProductNullProduct() {
        cartService.matchCustomerProduct(customer, null);
    }

    @Test
    public void testMatchCustomerProduct() {
        cartService.matchCustomerProduct(customer, product);
        verify(cartDAO).matchCustomerProduct(customer, product);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumStatsNull() {
        cartService.sumStats(null);
    }

    @Test
    public void testSumStats() {
        cartService.sumStats(customer);
        verify(cartDAO).sumStats(customer);
    }
}
