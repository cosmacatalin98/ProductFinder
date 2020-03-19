package mypackage;

import businessLayer.ProductBLL;
import data.ConnectionFactory;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test");

        List<Object> products = ProductBLL.ViewAllProducts();

        Iterator iterator = products.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
