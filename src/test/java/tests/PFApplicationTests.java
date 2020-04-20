package tests;

import domain.Product;
import domain.User;
import infoaccess.DBAOContext;
import infoaccess.DBAccessOperations;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Aceasta clasa se ocupa cu testarea operatiilor de
 * prelucrare a datelor.
 * Clasa utilizeaza libraria Mockito pentru a face
 * posibila testarea fara a avea nevoie de dependinte externe.
 */
public class PFApplicationTests {

    @Mock
    DBAccessOperations dbAccessOperations;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private DBAOContext dbaoc;

    @Before
    public void init() {
        dbaoc = new DBAOContext(dbAccessOperations);
    }

    @Test
    public void testExecuteGetAll() {
        dbaoc.executeGetAll();
        verify(dbAccessOperations).viewALL();
    }

    @Test
    public void executeGetAll() {
        List<Object> expectedResult = new ArrayList<Object>();
        Product p1 = new Product(1, 5, "Mango", 35, "Buc", 12);
        Product p2 = new Product(2, 5, "Avocado", 70, "Buc", 8);
        Product p3 = new Product(3, 5, "Banane", 125, "Kg", 3);
        when(dbAccessOperations.viewALL()).thenReturn(expectedResult);

        List<Object> currentResult = new ArrayList<Object>();
        currentResult = dbaoc.executeGetAll();

        assertEquals(expectedResult, currentResult);
    }

    @Test(expected = Exception.class)
    public void executeInsertItem() {
        doThrow(Exception.class).when(dbAccessOperations).insert(new Object());
        Product p1 = new Product(0, 11, "Mango", 0, "Bucasd", -1);
        dbaoc.executeInsertItem(p1);
    }

    @Test(expected = Exception.class)
    public void executeDeleteItem() {
        doThrow(Exception.class).when(dbAccessOperations).delete(anyInt());
        int id = -5;
        dbaoc.executeDeleteItem(id);
    }

    @Test(expected = Exception.class)
    public void executeUpdateItem() {
        doThrow(Exception.class).when(dbAccessOperations).update(new Object());
        Product p1 = new Product(1, 5, "Mango", -100, "Buc", 12);
        dbaoc.executeUpdateItem(p1);
    }

    @Test
    public void testUserObserverAssert() {
        Product observable = new Product(1, 1, "testname", 200, "t", 1);
        User observer = new User(1, "testname", "testpass");
        observer.setFavourite(observable);

        observable.addPropertyChangeListener(observer);
        observable.setQuantity(100);

        assertEquals(observer.getFavourite(), observable);
    }


}
