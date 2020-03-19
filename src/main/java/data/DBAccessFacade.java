package data;

import businessLayer.ProductBLL;
import mypackage.Product;

import java.util.ArrayList;
import java.util.List;

public class DBAccessFacade {

    public static List<Object> GetAll(String type) {

        List<Object> objects = new ArrayList<Object>();

        switch (type) {
            case "Product":
                objects = ProductBLL.ViewAllProducts();
                break;
            default:
                System.out.println("Wrong type");
        }

        return objects;
    }

    public static void InsertItem(Object obj) {
        Class cls = obj.getClass();
        String type = cls.getSimpleName();
        switch (type) {
            case "Product":
                ProductBLL.AddNewProduct((Product) obj);
                break;
            default:
                System.out.println("Wrong type");
                break;
        }
    }

    public static void DeleteItem(String type, int id) {
        switch (type) {
            case "Product":
                ProductBLL.DeleteProduct(id);
                break;
            default:
                System.out.println("Wrong type");
                break;
        }
    }

}
