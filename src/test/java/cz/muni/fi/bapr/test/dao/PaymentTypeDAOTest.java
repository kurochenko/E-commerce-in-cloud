package cz.muni.fi.bapr.test.dao;

import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.dao.PaymentTypeDAO;
import cz.muni.fi.bapr.entity.PaymentType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public class PaymentTypeDAOTest extends AbstractDAOTest<PaymentType> {

    @Autowired
    private PaymentTypeDAO dao;

    private PaymentType e1;
    private PaymentType e2;


    @Override
    protected DAOTemplate<PaymentType> getDao() {
        return dao;
    }

    @Override
    protected PaymentType getEntity1() {
        return e1;
    }

    @Override
    protected PaymentType getEntity2() {
        return e2;
    }

    @Before
    public void setUp() {

        e1 = new PaymentType();
        e1.setName("Cash");

        e2 = new PaymentType();
        e2.setName("Card");

    }

    /* Create */

    @Test
    public void testCreate() {
        dao.create(e1);
        assertNotNull(e1.getId());

        PaymentType retrieved = dao.find(e1.getId());
        assertEquals("Cash", retrieved.getName());
        assertEquals(e1, retrieved);
    }

    /* Edit */

    @Test
    public void testEdit() {
        dao.create(e1);

        e1.setName("Gold");
        dao.edit(e1);

        PaymentType retrieved = dao.find(e1.getId());
        assertEquals("Gold", retrieved.getName());
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

        assertEquals(e1, dao.findByName("Cash"));
        assertEquals(e2, dao.findByName("Card"));
    }
}
