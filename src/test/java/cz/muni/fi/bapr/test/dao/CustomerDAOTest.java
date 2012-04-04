package cz.muni.fi.bapr.test.dao;

import cz.muni.fi.bapr.dao.CustomerDAO;
import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public class CustomerDAOTest extends AbstractDAOTest<Customer> {

    @Autowired
    private CustomerDAO dao;

    private Customer e1;
    private Customer e2;

    @Override
    protected DAOTemplate<Customer> getDao() {
        return dao;
    }

    @Override
    protected Customer getEntity1() {
        return e1;
    }

    @Override
    protected Customer getEntity2() {
        return e2;
    }


    @Before
    public void setUp() {

        e1 = new Customer();
        e1.setEmail("first@customer.tld");
        e1.setPassword("p@ssword");
        e1.setCreated(new Date(1333449110));
        e1.setName("First name");
        e1.setCity("Brno");
        e1.setStreet("First street");
        e1.setZipCode("60200");

        e2 = new Customer();
        e2.setEmail("second@customer.tld");
        e2.setPassword("secure");
        e2.setCreated(new Date(1333449120));
        e2.setName("Second name");
        e2.setCity("Prague");
        e2.setStreet("Second street");
        e2.setZipCode("14900");

    }

    /* Create */

    @Test
    public void testCreate() {
        dao.create(e1);
        assertNotNull(e1.getId());

        Customer retrieved = dao.find(e1.getId());
        assertEquals("first@customer.tld", retrieved.getEmail());
        assertEquals("p@ssword", retrieved.getPassword());
        assertEquals(new Date(1333449110), retrieved.getCreated());
        assertEquals("First name", retrieved.getName());
        assertEquals("Brno", retrieved.getCity());
        assertEquals("First street", retrieved.getStreet());
        assertEquals("60200", retrieved.getZipCode());
        assertEquals(e1, retrieved);
    }

    /* Edit */

    @Test
    public void testEdit() {
        dao.create(e2);

        e2.setEmail("first@customer.tld");
        e2.setPassword("p@ssword");
        e2.setCreated(new Date(1333449110));
        e2.setName("First name");
        e2.setCity("Brno");
        e2.setStreet("First street");
        e2.setZipCode("60200");
        dao.edit(e2);

        Customer retrieved = dao.find(e2.getId());
        assertEquals("first@customer.tld", retrieved.getEmail());
        assertEquals("p@ssword", retrieved.getPassword());
        assertEquals(new Date(1333449110), retrieved.getCreated());
        assertEquals("First name", retrieved.getName());
        assertEquals("Brno", retrieved.getCity());
        assertEquals("First street", retrieved.getStreet());
        assertEquals("60200", retrieved.getZipCode());
        assertEquals(e2, retrieved);
    }

    /** Find by vat */

    @Test(expected = IllegalArgumentException.class)
    public void testFindByEmailNull() {
        dao.findByEmail(null);
    }

    @Test
    public void testFindByEmail() {
        assertNull(dao.findByEmail("not@existent.tld"));

        dao.create(e1);
        dao.create(e2);

        assertEquals(e1, dao.findByEmail("first@customer.tld"));
        assertEquals(e2, dao.findByEmail("second@customer.tld"));
    }
}
