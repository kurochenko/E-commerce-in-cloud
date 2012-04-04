package cz.muni.fi.bapr.test.dao;

import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.dao.DeliveryTypeDAO;
import cz.muni.fi.bapr.entity.DeliveryType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public class DeliveryTypeDAOTest extends AbstractDAOTest<DeliveryType> {

    @Autowired
    private DeliveryTypeDAO dao;

    private DeliveryType e1;
    private DeliveryType e2;


    @Override
    protected DAOTemplate<DeliveryType> getDao() {
        return dao;
    }

    @Override
    protected DeliveryType getEntity1() {
        return e1;
    }

    @Override
    protected DeliveryType getEntity2() {
        return e2;
    }

    @Before
    public void setUp() {

        e1 = new DeliveryType();
        e1.setName("Post");
        e1.setPrice(BigDecimal.ONE);

        e2 = new DeliveryType();
        e2.setName("PPL");
        e2.setPrice(BigDecimal.TEN);

    }

    /* Create */

    @Test
    public void testCreate() {
        dao.create(e1);
        assertNotNull(e1.getId());

        DeliveryType retrieved = dao.find(e1.getId());
        assertEquals("Post", retrieved.getName());
        assertEquals(BigDecimal.ONE, retrieved.getPrice());
        assertEquals(e1, retrieved);
    }

    /* Edit */

    @Test
    public void testEdit() {
        dao.create(e1);

        e1.setName("Pigeon");
        e1.setPrice(BigDecimal.valueOf(5));
        dao.edit(e1);

        DeliveryType retrieved = dao.find(e1.getId());
        assertEquals("Pigeon", retrieved.getName());
        assertEquals(BigDecimal.valueOf(5), retrieved.getPrice());
        assertEquals(e1, retrieved);
    }

    /** Find by name */

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameNull() {
        dao.findByName(null);
    }

    @Test
    public void testFindByName() {
        assertNull(dao.findByName("NOT EXISTENT TYPE"));

        dao.create(e1);
        dao.create(e2);

        assertEquals(e1, dao.findByName("Post"));
        assertEquals(e2, dao.findByName("PPL"));
    }
    
}
