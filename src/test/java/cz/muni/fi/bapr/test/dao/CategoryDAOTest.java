package cz.muni.fi.bapr.test.dao;

import cz.muni.fi.bapr.dao.CategoryDAO;
import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.entity.Category;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public class CategoryDAOTest extends AbstractDAOTest<Category> {

    @Autowired
    private CategoryDAO dao;

    private Category e1;
    private Category e2;


    @Override
    protected DAOTemplate<Category> getDao() {
        return dao;
    }

    @Override
    protected Category getEntity1() {
        return e1;
    }

    @Override
    protected Category getEntity2() {
        return e2;
    }

    @Before
    public void setUp() {

        e1 = new Category();
        e1.setName("Electronics");

        e2 = new Category();
        e2.setName("Drugs");

    }

    /* Create */

    @Test
    public void testCreate() {
        dao.create(e1);
        assertNotNull(e1.getId());

        Category retrieved = dao.find(e1.getId());
        assertEquals("Electronics", retrieved.getName());
        assertEquals(e1, retrieved);
    }

    /* Edit */

    @Test
    public void testEdit() {
        dao.create(e1);

        e1.setName("Cars");
        dao.edit(e1);

        Category retrieved = dao.find(e1.getId());
        assertEquals("Cars", retrieved.getName());
        assertEquals(e1, retrieved);
    }

    /** Find by name */

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameNull() {
        dao.findByName(null);
    }

    @Test
    public void testFindByName() {
        assertNull(dao.findByName("NOT EXISTENT CATEGORY"));

        dao.create(e1);
        dao.create(e2);

        assertEquals(e1, dao.findByName("Electronics"));
        assertEquals(e2, dao.findByName("Drugs"));
    }
    
}
