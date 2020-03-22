package infoaccess;

import domain.Product;
import domain.Store;
import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa are rolul de a simplifica utilizarea operatiilor
 * de manipulare a datelor din baza de date de catre un anumit
 * utilizator.
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

        switch (type) {
            case "Product":
                ProductBLL pbll = new ProductBLL();
                objects = pbll.viewALL();
                break;
            case "Store":
                StoreBLL sbll = new StoreBLL();
                objects = sbll.viewALL();
                break;
            case "User":
                UserBLL ubll = new UserBLL();
                objects = ubll.viewALL();
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
        switch (type) {
            case "Product":
                ProductBLL pbll = new ProductBLL();
                pbll.insert((Product) obj);
                break;
            case "Store":
                StoreBLL sbll = new StoreBLL();
                sbll.insert((Store) obj);
                break;
            case "User":
                UserBLL ubll = new UserBLL();
                ubll.insert((User) obj);
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
        switch (type) {
            case "Product":
                ProductBLL pbll = new ProductBLL();
                pbll.delete(id);
                break;
            case "Store":
                StoreBLL sbll = new StoreBLL();
                sbll.delete(id);
                break;
            case "User":
                UserBLL ubll = new UserBLL();
                ubll.delete(id);
                break;
            default:
                System.out.println("Wrong type");
                break;
        }
    }

}
