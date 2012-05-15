package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.OrderProductDAO;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.service.impl.OrderProductServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class OrderProductServiceTest extends AbstractMockInit {

    private Order order = new Order();
    private OrderProductServiceImpl orderProductService;
    @Mock private OrderProductDAO orderProductDAO;

    @Before
    public void setUp() {
        orderProductService = new OrderProductServiceImpl();
        orderProductService.setOrderProductDAO(orderProductDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByOrderNull() {
        orderProductService.findByOrder(null);
    }

    @Test
    public void testFindByOrder() {
        orderProductService.findByOrder(order);
        verify(orderProductDAO).findByOrder(order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumStatsNull() {
        orderProductService.sumStats(null);
    }

    @Test
    public void testSumStats() {
        orderProductService.sumStats(order);
        verify(orderProductDAO).sumStats(order);
    }
}
