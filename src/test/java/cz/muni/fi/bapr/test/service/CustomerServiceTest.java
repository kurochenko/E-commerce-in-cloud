package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.CustomerDAO;
import cz.muni.fi.bapr.service.impl.CustomerServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class CustomerServiceTest extends AbstractMockInit {

    @Mock private CustomerDAO customerDAO;
    private CustomerServiceImpl customerService;

    @Before
    public void setUp() {
        customerService = new CustomerServiceImpl();
        customerService.setCustomerDAO(customerDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByEmailNull() {
        customerService.findByEmail(null);
    }

    @Test
    public void testFindByName() {
        customerService.findByEmail("some@email.tld");
        verify(customerDAO).findByEmail("some@email.tld");
    }

}
