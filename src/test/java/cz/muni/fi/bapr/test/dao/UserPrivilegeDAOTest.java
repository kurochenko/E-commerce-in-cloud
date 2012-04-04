package cz.muni.fi.bapr.test.dao;

import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.dao.UserPrivilegeDAO;
import cz.muni.fi.bapr.entity.UserPrivilege;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public class UserPrivilegeDAOTest extends AbstractDAOTest<UserPrivilege> {

    @Autowired
    private UserPrivilegeDAO dao;

    private UserPrivilege e1;
    private UserPrivilege e2;


    @Override
    protected DAOTemplate<UserPrivilege> getDao() {
        return dao;
    }

    @Override
    protected UserPrivilege getEntity1() {
        return e1;
    }

    @Override
    protected UserPrivilege getEntity2() {
        return e2;
    }

    @Before
    public void setUp() {

        e1 = new UserPrivilege();
        e1.setName("ADMIN");

        e2 = new UserPrivilege();
        e2.setName("ANONYMOUS");

    }

    /* Create */

    @Test
    public void testCreate() {
        dao.create(e1);
        assertNotNull(e1.getId());

        UserPrivilege retrieved = dao.find(e1.getId());
        assertEquals("ADMIN", retrieved.getName());
        assertEquals(e1, retrieved);
    }

    /* Edit */

    @Test
    public void testEdit() {
        dao.create(e1);

        e1.setName("USER");
        dao.edit(e1);

        UserPrivilege retrieved = dao.find(e1.getId());
        assertEquals("USER", retrieved.getName());
        assertEquals(e1, retrieved);
    }

    /** Find by name */

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameNull() {
        dao.findByName(null);
    }

    @Test
    public void testFindByName() {
        assertNull(dao.findByName("NOT EXISTENT NAME"));

        dao.create(e1);
        dao.create(e2);

        assertEquals(e1, dao.findByName("ADMIN"));
        assertEquals(e2, dao.findByName("ANONYMOUS"));
    }
}
