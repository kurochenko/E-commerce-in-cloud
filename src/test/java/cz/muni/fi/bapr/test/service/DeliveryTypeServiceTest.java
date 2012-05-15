package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.DeliveryTypeDAO;
import cz.muni.fi.bapr.service.impl.DeliveryTypeServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class DeliveryTypeServiceTest extends AbstractMockInit {

    @Mock private DeliveryTypeDAO deliveryTypeDAO;
    private DeliveryTypeServiceImpl deliveryTypeService;

    @Before
    public void setUp() {
        deliveryTypeService = new DeliveryTypeServiceImpl();
        deliveryTypeService.setDeliveryTypeDAO(deliveryTypeDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameNull() {
        deliveryTypeService.findByName(null);
    }

    @Test
    public void testFindByName() {
        deliveryTypeService.findByName("some name");
        verify(deliveryTypeDAO).findByName("some name");
    }

}
