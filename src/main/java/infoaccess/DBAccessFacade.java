package infoaccess;

import domain.Product;
import domain.Store;
import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa are rolul de a simplifica utilizarea operatiilor de manipulare
 * a datelor din baza de date prin implementarea DP-ului Facade.
 */
public class DBAccessFacade {

    /**
     * Aceasta metoda returneaza toate elementele dintr-o tabela
     * din baza de date in functie  de  parametrul type.
     *
     * @param type Tipul de date dorit.
     * @return List<Object> Lista de entitati din tabela.
     */
    public static List<Object> getAll(String type) {

        List<Object> objects = new ArrayList<Object>();
        DBAOContext dbaoc;

        switch (type) {
            case "Product":
                dbaoc = new DBAOContext(new ProductBLL());
                objects = dbaoc.executeGetAll();
                break;
            case "Store":
                dbaoc = new DBAOContext(new StoreBLL());
                objects = dbaoc.executeGetAll();
                break;
            case "User":
                dbaoc = new DBAOContext(new UserBLL());
                objects = dbaoc.executeGetAll();
                break;
            default:
                System.out.println("Wrong type");
        }

        return objects;
    }

    /**
     * Aceasta metoda insereaza un obiect in baza de date
     * in functie de tipul acestuia.
     *
     * @param obj Obiectul care trebuie inserat.
     */
    public static void insertItem(Object obj) {
        Class cls = obj.getClass();
        String type = cls.getSimpleName();
        DBAOContext dbaoc;
        switch (type) {
            case "Product":
                dbaoc = new DBAOContext(new ProductBLL());
                dbaoc.executeInsertItem((Product) obj);
                break;
            case "Store":
                dbaoc = new DBAOContext(new StoreBLL());
                dbaoc.executeInsertItem((Store) obj);
                break;
            case "User":
                dbaoc = new DBAOContext(new UserBLL());
                dbaoc.executeInsertItem((User) obj);
                break;
            default:
                System.out.println("Wrong type");
                break;
        }
    }

    /**
     * Aceasta metoda sterge un obiect pe baza
     * unui id primit ca si parametru.
     * Stergerea se realizeaza din tabela de tipul type.
     *
     * @param type Tipul tabelei din care se face stergerea.
     * @param id   ID-ul obiectului care trebuie sters.
     */
    public static void deleteItem(String type, int id) {
        DBAOContext dbaoc;
        switch (type) {
            case "Product":
                dbaoc = new DBAOContext(new ProductBLL());
                dbaoc.executeDeleteItem(id);
                break;
            case "Store":
                dbaoc = new DBAOContext(new StoreBLL());
                dbaoc.executeDeleteItem(id);
                break;
            case "User":
                dbaoc = new DBAOContext(new UserBLL());
                dbaoc.executeDeleteItem(id);
                break;
            default:
                System.out.println("Wrong type");
                break;
        }
    }

    /**
     * Aceasat metoda actualizeaza un obiect din baza
     * de date in functie de tipul acestuia.
     *
     * @param obj Obiectul modificat.
     */
    public static void updateItem(Object obj) {
        Class cls = obj.getClass();
        String type = cls.getSimpleName();
        DBAOContext dbaoc;
        switch (type) {
            case "Product":
                dbaoc = new DBAOContext(new ProductBLL());
                dbaoc.executeUpdateItem((Product) obj);
                break;
            case "Store":
                dbaoc = new DBAOContext(new StoreBLL());
                dbaoc.executeUpdateItem((Store) obj);
                break;
            case "User":
                dbaoc = new DBAOContext(new UserBLL());
                dbaoc.executeUpdateItem((User) obj);
                break;
            default:
                System.out.println("Wrong type");
                break;
        }
    }

    /**
     * Aceasta metoda returneaza toate produsele din tabela products
     * care au numele name.
     *
     * @param name Parametru String dupa care se face cautarea.
     * @return List<Product> Returneaza o lista cu produsele gasite.
     */
    public static List<Product> findByName(String name) {
        ProductBLL pbll = new ProductBLL();
        return pbll.findByName(name);
    }

    /**
     * Aceasta metoda ne returneaza o lista  de obiecte de tip
     * Product sortate dupa un anumit criteriu.
     * Lista va contine toate prododusele cu numele name.
     *
     * @param name      Numele produsului cautat.
     * @param criterion Criteriul dupa care se face sortarea.
     * @return
     */
    public static List<Product> sortProducts(String name, String criterion) {
        ProductBLL pbll = new ProductBLL();
        if (criterion.equals("Price")) {
            return pbll.sortByPrice(name);
        } else {
            return pbll.sortByQuantity(name);
        }
    }


}
