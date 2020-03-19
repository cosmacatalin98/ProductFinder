package mypackage;

import businessLayer.ProductBLL;
import org.springframework.web.bind.annotation.*;

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
        return ProductBLL.ViewAllProducts();
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
        ProductBLL.AddNewProduct(prod);
        return prod.toString();
    }

}
