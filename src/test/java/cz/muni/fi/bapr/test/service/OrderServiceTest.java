package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.CartDAO;
import cz.muni.fi.bapr.dao.OrderDAO;
import cz.muni.fi.bapr.dao.OrderProductDAO;
import cz.muni.fi.bapr.entity.*;
import cz.muni.fi.bapr.service.impl.OrderServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class OrderServiceTest extends AbstractMockInit {

    @Mock private OrderDAO orderDAO;
    @Mock private CartDAO cartDAO;
    @Mock private OrderProductDAO orderProductDAO;

    private OrderServiceImpl orderService;

    private Order order = new Order();
    private Customer customer = new Customer();
    private DeliveryType deliveryType = new DeliveryType();
    private PaymentType paymentType = new PaymentType();


    @Before
    public void setUp() {
        orderService = new OrderServiceImpl();
        orderService.setCartDAO(cartDAO);
        orderService.setOrderDAO(orderDAO);
        orderService.setOrderProductDAO(orderProductDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAndMoveProductsNull() {
        orderService.createAndMoveProducts(null);
    }

    @Test
    public void testCreateAndMoveProducts() {
        final Cart cart1 = new Cart();
        cart1.setId(1L);
        final Cart cart2 = new Cart();
        cart2.setId(2L);
        List<Cart> toReturn = new ArrayList<Cart>() {{
            add(cart1);
            add(cart2);
        }};

        order.setCustomer(customer);


        when(cartDAO.findByCustomer(customer)).thenReturn(toReturn);

        orderService.createAndMoveProducts(order);

        verify(orderDAO).create(order);
        verify(cartDAO).remove(cart1);
        verify(cartDAO).remove(cart2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByDeliveryTypeNull() {
        orderService.findByDeliveryType(null);
    }

    @Test
    public void testFindByDeliveryType() {
        orderService.findByDeliveryType(deliveryType);
        verify(orderDAO).findByDeliveryType(deliveryType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByPaymentTypeNull() {
        orderService.findByPaymentType(null);
    }

    @Test
    public void testFindByPaymentType() {
        orderService.findByPaymentType(paymentType);
        verify(orderDAO).findByPaymentType(paymentType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindNotAttendedByCustomerNull() {
        orderService.findNotAttendedByCustomer(null);
    }

    @Test
    public void testFindNotAttendedByCustomer() {
        orderService.findNotAttendedByCustomer(customer);
        verify(orderDAO).findNotAttendedByCustomer(customer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAttendedByCustomerNull() {
        orderService.findAttendedByCustomer(null);
    }

    @Test
    public void testFindAttendedByCustomer() {
        orderService.findAttendedByCustomer(customer);
        verify(orderDAO).findAttendedByCustomer(customer);
    }

    @Test
    public void testFindAttended() {
        orderService.findAttended();
        verify(orderDAO).findAttended();
    }

    @Test
    public void testFindNotAttended() {
        orderService.findNotAttended();
        verify(orderDAO).findNotAttended();
    }

}
