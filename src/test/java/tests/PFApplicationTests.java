package tests;

import infoaccess.DBAccessFacade;
import infoaccess.DBAccessOperations;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

public class PFApplicationTests {

    @Mock
    DBAccessOperations dbAccessOperations;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private DBAccessFacade dbAccessFacade;

    @Before
    public void init() {
        dbAccessFacade = new DBAccessFacade(dbAccessOperations);
    }

    @Test
    public void testFindBy() {
        int id = 10;
        dbAccessFacade.findBy(id);
        verify(dbAccessOperations).findByID(id);
    }

    @Test
    public void testFindByAssert() {
        int id = 10;
        boolean expectedResult = false;
        when(dbAccessOperations.findByID(id)).thenReturn(expectedResult);
        boolean currentResult = dbAccessFacade.findBy(id);
        assertEquals(expectedResult, currentResult);
    }

}
