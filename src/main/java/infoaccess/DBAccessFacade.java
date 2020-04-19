package infoaccess;

import domain.Product;
import domain.Store;
import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa are rolul de a simplifica utilizarea operatiilor
 * de manipulare a datelor din baza de date de catre un anumit
 * utilizator prin implementarea DP-ului Facade.
 */
public class DBAccessFacade {

    private DBAccessOperations dbao;

    public DBAccessFacade(DBAccessOperations dbao) {
        this.dbao = dbao;
    }

    /**
     * Aceasta metoda nu a fost implementata  inca dar se stie cum ar
     * trebui sa se comporte.
     *
     * @param id
     * @return
     */
    public boolean findAllById(int id) {
        return dbao.findByID(id);
    }

    /**
     * Aceasta metoda nu a fost implementata  inca dar se stie cum ar
     * trebui sa se comporte.
     *
     * @param name
     * @return
     */
    public boolean findAllByName(String name) {
        return dbao.findByName(name);
    }

    /**
     * Aceasta metoda returneaza toate elementele dintr-o tabela
     * din baza de date in functie  de  parametrul type.
     *
     * @param type Tipul de date dorit.
     * @return List<Object> Lista de entitati din tabela.
     */
    public static List<Object> GetAll(String type) {

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
    public static void InsertItem(Object obj) {
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
     * unui id primit ca parametru.Stergerea se
     * realizeaza din tabela de tipul type.
     *
     * @param type Tipul tabelei din care se face stergerea.
     * @param id   ID-ul obiectului care trebuie sters.
     */
    public static void DeleteItem(String type, int id) {
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
    public static void UpdateItem(Object obj) {
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

}
