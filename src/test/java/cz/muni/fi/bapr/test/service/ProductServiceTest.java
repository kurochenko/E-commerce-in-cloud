package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.ProductDAO;
import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Vat;
import cz.muni.fi.bapr.service.impl.ProductServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class ProductServiceTest extends AbstractMockInit {

    private ProductServiceImpl productService;

    @Mock private ProductDAO productDAO;

    private Category category = new Category();
    private Vat vat = new Vat();

    @Before
    public void setUp() {
        productService = new ProductServiceImpl();
        productService.setProductDAO(productDAO);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFindByCategoryNull() {
        productService.findByCategory(null);
    }

    @Test
    public void testFindByCategory() {
        productService.findByCategory(category);
        verify(productDAO).findByCategory(category);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByVatNull() {
        productService.findByVat(null);
    }

    @Test
    public void testFindByVat() {
        productService.findByVat(vat);
        verify(productDAO).findByVat(vat);
    }
}
