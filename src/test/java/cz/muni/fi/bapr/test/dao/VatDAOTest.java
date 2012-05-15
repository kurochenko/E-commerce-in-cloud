package cz.muni.fi.bapr.test.dao;

import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.dao.VatDAO;
import cz.muni.fi.bapr.entity.Vat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public class VatDAOTest extends AbstractDAOTest<Vat> {

    @Autowired
    private VatDAO dao;

    private Vat e1;
    private Vat e2;


    @Override
    protected DAOTemplate<Vat> getDao() {
        return dao;
    }

    @Override
    protected Vat getEntity1() {
        return e1;
    }

    @Override
    protected Vat getEntity2() {
        return e2;
    }

    @Before
    public void setUp() {

        e1 = new Vat();
        e1.setVat(BigDecimal.valueOf(15));

        e2 = new Vat();
        e2.setVat(BigDecimal.valueOf(20));

    }

    /* Create */

    @Test
    public void testCreate() {
        dao.create(e1);
        assertNotNull(e1.getId());

        Vat retrieved = dao.find(e1.getId());
        assertEquals(BigDecimal.valueOf(15), retrieved.getVat());
        assertEquals(e1, retrieved);
    }

    /* Edit */

    @Test
    public void testEdit() {
        dao.create(e1);

        e1.setVat(BigDecimal.TEN);
        dao.edit(e1);

        Vat retrieved = dao.find(e1.getId());
        assertEquals(BigDecimal.TEN, retrieved.getVat());
        assertEquals(e1, retrieved);
    }

    /** Find by vat */

    @Test(expected = IllegalArgumentException.class)
    public void testFindByVatNull() {
        dao.findByVat(null);
    }

    @Test
    public void testFindByVat() {
        assertNull(dao.findByVat(BigDecimal.TEN));

        dao.create(e1);
        dao.create(e2);

        assertEquals(e1, dao.findByVat(BigDecimal.valueOf(15)));
        assertEquals(e2, dao.findByVat(BigDecimal.valueOf(20)));
    }
}
