package mypackage;

import data.DBAccessFacade;
import org.springframework.web.bind.annotation.*;
import tableclasses.Product;
import tableclasses.Store;

import java.util.List;

@RestController
public class Controller {

    public Controller() {
    }

    /**
     * Aceasta metoda este folosita pentru a testa
     * conexiunea la Postman folosind adresa
     * localhost:8080/test
     *
     * @return String Returneaza un mesaj de test
     */
    @GetMapping("/test")
    public String GetHelloWorld() {
        return "Hello from Product Finder Application !";
    }

    /**
     * Aceasta metoda ne returneaza in Postman  o lista cu toate obiectele
     * din baza de date din tabela Produse folosind adresa
     * http://localhost:8080/allProducts
     *
     * @return List<Object> Returneaza o lista cu toate produsele.
     */
    @GetMapping("/allProducts")
    public List<Object> GetAllProducts() {
        return DBAccessFacade.GetAll("Product");
    }

    /**
     * Aceasta metoda ne insereaza un produs nou primit ca si
     * parametru din Postman folosind adresa
     * http://localhost:8080/insertNewProduct
     *
     * @param prod Produsul primit ca si parametru in format json
     * @return String Returneaza obiectul ca si String pe post de mesaj
     * de confirmare.
     */
    @RequestMapping(value = "/insertNewProduct", method = RequestMethod.POST)
    public String InsertNewProduct(@RequestBody Product prod) {
        DBAccessFacade.InsertItem(prod);
        return prod.toString();
    }

    /**
     * Aceasta metoda sterge un produs pe baza unui
     * id primit ca si parametru.
     *
     * @param id Id-ul dupa care se realizeaza stergerea.
     * @return String Returneaza un mesaj de confirmare.
     */
    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public String DeleteProduct(@PathVariable int id) {
        DBAccessFacade.DeleteItem("Product", id);
        return "Success";
    }


    /**
     * Aceasta metoda ne returneaza in Postman o lista cu toate obiectele
     * din baza de date din tabela Stores folosind adresa
     * http://localhost:8080/allStores
     *
     * @return List<Object> Returneaza o lista cu toate magazinele.
     */
    @GetMapping("/allStores")
    public List<Object> GetAllStores() {
        return DBAccessFacade.GetAll("Store");
    }

    /**
     * Aceasta metoda ne insereaza un magazin nou primit ca si
     * parametru din Postman folosind adresa
     * http://localhost:8080/insertNewStore
     *
     * @param sto Magazinul primit ca si parametru in format json
     * @return String Returneaza obiectul ca si String pe post de mesaj
     * de confirmare.
     */
    @RequestMapping(value = "/insertNewStore", method = RequestMethod.POST)
    public String InsertNewStore(@RequestBody Store sto) {
        DBAccessFacade.InsertItem(sto);
        return sto.toString();
    }

    /**
     * Aceasta metoda sterge un magazin pe baza unui
     * id primit ca si parametru.
     *
     * @param id Id-ul dupa care se realizeaza stergerea.
     * @return String Returneaza un mesaj de confirmare.
     */
    @RequestMapping(value = "/deleteStore/{id}", method = RequestMethod.DELETE)
    public String DeleteStore(@PathVariable int id) {
        DBAccessFacade.DeleteItem("Store", id);
        return "Success";
    }

    /**
     * Aceasta metoda ne returneaza in Postman o lista cu toate obiectele
     * din baza de date din tabela Users folosind adresa
     * http://localhost:8080/allUsers
     *
     * @return List<Object> Returneaza o lista cu toti utilizatorii.
     */
    @GetMapping("/allUsers")
    public List<Object> GetAllUsers() {
        return DBAccessFacade.GetAll("User");
    }

}
