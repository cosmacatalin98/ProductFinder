package data;

import businessLayer.ProductBLL;
import businessLayer.StoreBLL;
import businessLayer.UserBLL;
import tableclasses.Product;
import tableclasses.Store;
import tableclasses.User;

import java.util.ArrayList;
import java.util.List;

public class DBAccessFacade {

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
