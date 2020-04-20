package application;

import infoaccess.DBAccessFacade;
import org.springframework.web.bind.annotation.*;
import domain.Product;
import domain.Store;
import domain.User;

import java.util.List;

/**
 * Aceasta clasa se ocupa in special de comunicarea aplicatiei
 * cu platforma Postman, platforma folosit pentru testarea endpoint-urilor.
 */
@RestController
public class Controller {

    public Controller() {
    }

    //Endpoint-uri pentru obiectele de tip Product

    /**
     * Aceasta metoda ne returneaza in Postman o lista cu toate obiectele
     * din baza de date din tabela products folosind adresa :
     * http://localhost:8080/allProducts
     *
     * @return List<Object>  Returneaza o lista cu toate produsele.
     */
    @GetMapping("/allProducts")
    public List<Object> getAllProducts() {
        return DBAccessFacade.getAll("Product");
    }

    /**
     * Aceasta metoda ne insereaza un produs nou in tabela products
     * primit ca si parametru din Postman folosind adresa :
     * http://localhost:8080/insertNewProduct
     *
     * @param prod Obiectul de tip Product primit ca si parametru in format JSON.
     * @return String  Returneaza obiectul ca si String pe post de mesaj
     * de confirmare.
     */
    @RequestMapping(value = "/insertNewProduct", method = RequestMethod.POST)
    public String insertNewProduct(@RequestBody Product prod) {
        DBAccessFacade.insertItem(prod);
        return prod.toString();
    }

    /**
     * Aceasta metoda ne actualizeaza campurile unui produs din tabela
     * products folosind adresa :
     * http://localhost:8080/updateProduct
     *
     * @param prod Obiectul de tip Product care contie campurile modificate.
     * @return String  Returneaza obiectul ca si String pe post de mesaj
     * de confirmare.
     */
    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product prod) {
        DBAccessFacade.updateItem(prod);
        return prod.toString();
    }

    /**
     * Aceasta metoda sterge un produs din tabela products pe baza unui
     * id primit ca si parametru folosind adresa :
     * http://localhost:8080/deleteProduct/id
     *
     * @param id Id-ul dupa care se realizeaza stergerea.
     * @return String  Returneaza un mesaj de confirmare.
     */
    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable int id) {
        DBAccessFacade.deleteItem("Product", id);
        return "Success";
    }

    /**
     * Aceasta metoda returneaza toate produsele din tabela products
     * care au numele name folosind adresa :
     * http://localhost:8080/findByName/name
     *
     * @param name Parametru String dupa care se face cautarea.
     * @return List<Object> Returneaza o lista cu produsele gasite.
     */
    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    public List<Product> findByName(@PathVariable String name) {
        return DBAccessFacade.findByName(name);
    }

    /**
     * Aceasta metoda returneaza toate produsele din tabela products
     * care au numele name.
     * Lista va fi sortata crescator in fuctie de pretul produselor.
     * Pentru returnarea rezultatului se foloseste adresa :
     * http://localhost:8080/sortByPrice/name
     *
     * @param name Parametrul String dupa care se face cautarea.
     * @return List<Product> Returneaza o lista cu produsele gasite.
     */
    @RequestMapping(value = "/sortByPrice/{name}", method = RequestMethod.GET)
    public List<Product> sortByPrice(@PathVariable String name) {
        return DBAccessFacade.sortProducts(name, "Price");
    }

    /**
     * Aceasta metoda returneaza toate produsele din tabela products
     * care au numele name.
     * Lista va fi sortata crescator in fuctie de stocul produselor.
     * Pentru returnarea rezultatului se foloseste adresa :
     * http://localhost:8080/sortByQuantity/name
     *
     * @param name Parametrul String dupa care se face cautarea.
     * @return List<Product> Returneaza o lista cu produsele gasite.
     */
    @RequestMapping(value = "/sortByQuantity/{name}", method = RequestMethod.GET)
    public List<Product> sortByQuantity(@PathVariable String name) {
        return DBAccessFacade.sortProducts(name, "Quantity");
    }

    //Endpoint-uri pentru obiectele de tip Store

    /**
     * Aceasta metoda ne returneaza in Postman o lista cu toate obiectele
     * din baza de date din tabela stores folosind adresa :
     * http://localhost:8080/allStores
     *
     * @return List<Object>  Returneaza o lista cu toate magazinele.
     */
    @GetMapping("/allStores")
    public List<Object> getAllStores() {
        return DBAccessFacade.getAll("Store");
    }

    /**
     * Aceasta metoda ne insereaza un magazin nou in tabela stores
     * primit ca si parametru din Postman folosind adresa :
     * http://localhost:8080/insertNewStore
     *
     * @param sto Obiectul de tip Store primit ca si parametru in format JSON.
     * @return String  Returneaza obiectul ca si String pe post de mesaj
     * de confirmare.
     */
    @RequestMapping(value = "/insertNewStore", method = RequestMethod.POST)
    public String insertNewStore(@RequestBody Store sto) {
        DBAccessFacade.insertItem(sto);
        return sto.toString();
    }

    /**
     * Aceasta metoda ne actualizeaza campurile unui magazin din tabela
     * stores folosind adresa :
     * http://localhost:8080/updateStore
     *
     * @param st Obiectul de tip Store care contie campurile modificate.
     * @return String  Returneaza obiectul ca si String pe post de mesaj
     * de confirmare.
     */
    @RequestMapping(value = "/updateStore", method = RequestMethod.PUT)
    public String updateStore(@RequestBody Store st) {
        DBAccessFacade.updateItem(st);
        return st.toString();
    }

    /**
     * Aceasta metoda sterge un magazin din tabela stores pe baza unui
     * id primit ca si parametru folosind adresa :
     * http://localhost:8080/deleteStore/id
     *
     * @param id Id-ul dupa care se realizeaza stergerea.
     * @return String  Returneaza un mesaj de confirmare.
     */
    @RequestMapping(value = "/deleteStore/{id}", method = RequestMethod.DELETE)
    public String deleteStore(@PathVariable int id) {
        DBAccessFacade.deleteItem("Store", id);
        return "Success";
    }

    //Endpoint-uri pentru obiectele de tip User

    /**
     * Aceasta metoda ne returneaza in Postman o lista cu toate obiectele
     * din baza de date din tabela users folosind adresa :
     * http://localhost:8080/allUsers
     *
     * @return List<Object>  Returneaza o lista cu toti utilizatorii.
     */
    @GetMapping("/allUsers")
    public List<Object> getAllUsers() {
        return DBAccessFacade.getAll("User");
    }

    /**
     * Aceasta metoda ne insereaza un utilizator nou in tabela users
     * primit ca si parametru din Postman folosind adresa :
     * http://localhost:8080/insertNewUser
     *
     * @param usr Obiectul de tip User primit ca si parametru in format JSON.
     * @return String  Returneaza obiectul ca si String pe post de mesaj
     * de confirmare.
     */
    @RequestMapping(value = "/insertNewUser", method = RequestMethod.POST)
    public String insertNewUser(@RequestBody User usr) {
        DBAccessFacade.insertItem(usr);
        return usr.toString();
    }

    /**
     * Aceasta metoda ne actualizeaza campurile unui utilizator din tabela
     * users folosind adresa :
     * http://localhost:8080/updateUser
     *
     * @param usr Obiectul de tip User care contie campurile modificate.
     * @return String  Returneaza obiectul ca si String pe post de mesaj
     * de confirmare.
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User usr) {
        DBAccessFacade.updateItem(usr);
        return usr.toString();
    }

    /**
     * Aceasta metoda sterge un utilizator din tabela users pe baza unui
     * id primit ca si parametru folosind adresa :
     * http://localhost:8080/deleteUser/id
     *
     * @param id Id-ul dupa care se realizeaza stergerea.
     * @return String  Returneaza un mesaj de confirmare.
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {
        DBAccessFacade.deleteItem("User", id);
        return "Success";
    }

}
