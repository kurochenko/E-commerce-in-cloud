package cz.muni.fi.bapr.test.service;

import cz.muni.fi.bapr.dao.UserPrivilegeDAO;
import cz.muni.fi.bapr.service.impl.UserPrivilegeServiceImpl;
import cz.muni.fi.bapr.test.AbstractMockInit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class UserPrivilegeServiceTest extends AbstractMockInit {
    @Mock
    private UserPrivilegeDAO userPrivilegeDAO;
    private UserPrivilegeServiceImpl userPrivilegeService;

    @Before
    public void setUp() {
        userPrivilegeService = new UserPrivilegeServiceImpl();
        userPrivilegeService.setUserPrivilegeDAO(userPrivilegeDAO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameNull() {
        userPrivilegeService.findByName(null);
    }

    @Test
    public void testFindByName() {
        userPrivilegeService.findByName("some name");
        verify(userPrivilegeDAO).findByName("some name");
    }
}
