package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.CategoryDAO;
import cz.muni.fi.bapr.service.impl.CategoryServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class CategoryServiceTest extends AbstractMockInit {

    @Mock private CategoryDAO categoryDAO;
    private CategoryServiceImpl categoryService;

    @Before
    public void setUp() {
        categoryService = new CategoryServiceImpl();
        categoryService.setCategoryDAO(categoryDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameNull() {
        categoryService.findByName(null);
    }

    @Test
    public void testFindByName() {
        categoryService.findByName("some name");
        verify(categoryDAO).findByName("some name");
    }

}
