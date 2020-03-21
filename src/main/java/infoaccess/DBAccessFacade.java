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
                objects = ProductBLL.ViewAllProducts();
                break;
            case "Store":
                objects = StoreBLL.ViewAllStores();
                break;
            case "User":
                objects = UserBLL.ViewAllUsers();
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
                ProductBLL.AddNewProduct((Product) obj);
                break;
            case "Store":
                StoreBLL.AddNewStore((Store) obj);
                break;
            case "User":
                UserBLL.AddNewUser((User) obj);
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
                ProductBLL.DeleteProduct(id);
                break;
            case "Store":
                StoreBLL.DeleteStore(id);
                break;
            case "User":
                UserBLL.DeleteUser(id);
                break;
            default:
                System.out.println("Wrong type");
                break;
        }
    }

}
