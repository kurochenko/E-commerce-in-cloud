package cz.muni.fi.bapr.test;

import org.junit.Before;
import org.junit.Ignore;
import org.mockito.MockitoAnnotations;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Ignore
public class AbstractMockInit {
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
