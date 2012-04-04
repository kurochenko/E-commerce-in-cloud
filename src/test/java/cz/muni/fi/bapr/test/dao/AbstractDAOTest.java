package cz.muni.fi.bapr.test.dao;

import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.entity.IdentifiedEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring/application-config.xml",
        "classpath:/spring/persistence-config.xml",
        "classpath:/spring/mvc-config.xml",
        "classpath:/spring/security-config.xml"
})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public abstract class AbstractDAOTest<T extends IdentifiedEntity> {


    protected abstract DAOTemplate<T> getDao();
    protected abstract T getEntity1();
    protected abstract T getEntity2();

    /* Create */

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNull() {
        getDao().create(null);
    }

    /* Create */

    @Test(expected = IllegalArgumentException.class)
    public void testEditNull() {
        getDao().edit(null);
    }

    /* Remove */
    
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        getDao().remove(null);
    }

    @Test
    public void testRemove() {
        getDao().create(getEntity1());
        getDao().create(getEntity2());

        getDao().remove(getEntity1());

        assertNull(getDao().find(getEntity1().getId()));
        assertEquals(getEntity2(), getDao().find(getEntity2().getId()));
    }

    /* Find */

    @Test(expected = IllegalArgumentException.class)
    public void testFindNull() {
        getDao().find(null);
    }

    @Test
    public void testFind() {
        assertNull(getDao().find(Long.MAX_VALUE));

        getDao().create(getEntity1());
        assertEquals(getEntity1(), getDao().find(getEntity1().getId()));
    }

    /* Find range */

    @Test(expected = IllegalArgumentException.class)
    public void findRangeBadFrom() {
        getDao().findRange(-1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findRangeBadRange() {
        getDao().findRange(0, 0);
    }

    @Test
    public void findRange() {
        getDao().create(getEntity1());
        getDao().create(getEntity2());

        List<T> list = getDao().findRange(0,2);
        assertEquals(2, list.size());
        assertTrue(list.contains(getEntity1()));
        assertTrue(list.contains(getEntity2()));

        list = getDao().findRange(0,1);
        assertEquals(1, list.size());
        assertTrue(list.contains(getEntity1()));

        list = getDao().findRange(1,1);
        assertEquals(1, list.size());
        assertTrue(list.contains(getEntity2()));

        list = getDao().findRange(2,1);
        assertTrue(list.isEmpty());
    }

    /* Find all */

    @Test
    public void findAll() {
        assertTrue(getDao().findAll().isEmpty());

        getDao().create(getEntity1());
        getDao().create(getEntity2());

        List<T> list = getDao().findAll();
        assertEquals(2, list.size());
        assertTrue(list.contains(getEntity1()));
        assertTrue(list.contains(getEntity2()));
    }

    /* Count */

    @Test
    public void count() {
        assertEquals(0, getDao().count());

        getDao().create(getEntity1());
        assertEquals(1, getDao().count());

        getDao().remove(getEntity1());
        assertEquals(0, getDao().count());
    }
}
