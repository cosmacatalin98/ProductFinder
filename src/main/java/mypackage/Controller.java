package mypackage;

import businessLayer.ProductBLL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    public Controller() {
    }

    //Doar de test , returneaza "Hello from Product Finder Application !" in Postman
    @GetMapping("/test") // localhost:8080/test
    public String getHelloWorld() {
        return "Hello from Product Finder Application !";
    }

    //Returneaza in Postman  o lista cu toate obiectele din baza de date din tabela Produse
    @GetMapping("/all") // localhost:8080/all
    public List<Object> getAllProducts() {
        return ProductBLL.ViewAllProducts();
    }

    @RequestMapping(value = "/insertNewProduct", method = RequestMethod.POST)
    public String persistPerson(@RequestBody Person prod) {
        System.out.println(prod.toString());
        return prod.toString();
    }

}
