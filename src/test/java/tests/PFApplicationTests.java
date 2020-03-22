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
    public void testFindAllById() {
        int id = 10;
        dbAccessFacade.findAllById(id);
        verify(dbAccessOperations).findByID(id);
    }

    @Test
    public void testFindALLByIdAssert() {
        int id = 10;
        boolean expectedResult = false;
        when(dbAccessOperations.findByID(id)).thenReturn(expectedResult);
        boolean currentResult = dbAccessFacade.findAllById(id);
        assertEquals(expectedResult, currentResult);
    }

    @Test
    public void testFindAllByName() {
        String name = "Mango";
        dbAccessFacade.findAllByName(name);
        verify(dbAccessOperations).findByName(name);
    }

    @Test
    public void testFindALLByNameAssert() {
        String name = "Mango";
        boolean expectedResult = true;
        when(dbAccessOperations.findByName(name)).thenReturn(expectedResult);
        boolean currentResult = dbAccessFacade.findAllByName(name);
        assertEquals(expectedResult, currentResult);
    }


}
