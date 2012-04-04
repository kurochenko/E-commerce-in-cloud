package cz.muni.fi.bapr.test.dao;

import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.dao.ProductDAO;
import cz.muni.fi.bapr.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public class ProductDAOTest extends AbstractDAOTest<Product> {

    @Autowired
    private ProductDAO dao;

    private Product e1;
    private Product e2;


    @Override
    protected DAOTemplate<Product> getDao() {
        return dao;
    }

    @Override
    protected Product getEntity1() {
        return e1;
    }

    @Override
    protected Product getEntity2() {
        return e2;
    }

    @Before
    public void setUp() {

        e1 = new Product();
        e1.setName("Car");
        e1.setPrice(BigDecimal.valueOf(123.456));
        e1.setDescription("brief description");
        e1.setAmount(5);
        e1.setCreated(new Date(1333449110)) ;

        e2 = new Product();
        e2.setName("Chair");
        e2.setPrice(BigDecimal.valueOf(5.999));
        e2.setDescription("wooden chair");
        e2.setAmount(1);
        e2.setCreated(new Date(1333449120)) ;


    }

    /* Create */

    @Test
    public void testCreate() {
        dao.create(e1);
        assertNotNull(e1.getId());

        Product retrieved = dao.find(e1.getId());
        assertEquals("Car", retrieved.getName());
        assertEquals(BigDecimal.valueOf(123.456), retrieved.getPrice());
        assertEquals("brief description", retrieved.getDescription());
        assertEquals(Integer.valueOf(5), retrieved.getAmount());
        assertEquals(new Date(1333449110), retrieved.getCreated());
        assertEquals(e1, retrieved);
    }

    /* Edit */

    @Test
    public void testEdit() {
        dao.create(e2);

        e2.setName("Car");
        e2.setPrice(BigDecimal.valueOf(123.456));
        e2.setDescription("brief description");
        e2.setAmount(5);
        e2.setCreated(new Date(1333449110)) ;
        dao.edit(e2);

        Product retrieved = dao.find(e2.getId());
        assertEquals("Car", retrieved.getName());
        assertEquals(BigDecimal.valueOf(123.456), retrieved.getPrice());
        assertEquals("brief description", retrieved.getDescription());
        assertEquals(Integer.valueOf(5), retrieved.getAmount());
        assertEquals(new Date(1333449110), retrieved.getCreated());
        assertEquals(e2, retrieved);
    }
}
