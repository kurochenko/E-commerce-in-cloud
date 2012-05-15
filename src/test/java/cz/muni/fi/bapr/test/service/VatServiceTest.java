package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.VatDAO;
import cz.muni.fi.bapr.service.impl.VatServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class VatServiceTest extends AbstractMockInit {

    @Mock
    private VatDAO vatDAO;
    private VatServiceImpl vatService;

    @Before
    public void setUp() {
        vatService = new VatServiceImpl();
        vatService.setVatDAO(vatDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByVatNull() {
        vatService.findByVat(null);
    }

    @Test
    public void testFindByVat() {
        vatService.findByVat(BigDecimal.TEN);
        verify(vatDAO).findByVat(BigDecimal.TEN);
    }

}
