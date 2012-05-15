package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.PaymentTypeDAO;
import cz.muni.fi.bapr.service.impl.PaymentTypeServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class PaymentTypeServiceTest extends AbstractMockInit {

    @Mock private PaymentTypeDAO paymentTypeDAO;
    private PaymentTypeServiceImpl paymentTypeService;

    @Before
    public void setUp() {
        paymentTypeService = new PaymentTypeServiceImpl();
        paymentTypeService.setPaymentTypeDAO(paymentTypeDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameNull() {
        paymentTypeService.findByName(null);
    }

    @Test
    public void testFindByName() {
        paymentTypeService.findByName("some name");
        verify(paymentTypeDAO).findByName("some name");
    }

}
