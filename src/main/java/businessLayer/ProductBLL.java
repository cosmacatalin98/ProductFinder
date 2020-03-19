package businessLayer;

import data.ConnectionFactory;
import mypackage.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupa cu operatiile de inserare, actualizare si stergere
 * aplicate pe tablela produse.
 *
 * @author Cosma Catalin
 */
public class ProductBLL {

    public static List<Object> ViewAllProducts() {

        List<Object> products = new ArrayList<Object>();

        try {
            Connection dbConnection = ConnectionFactory.getConnection();
            String query = "SELECT * FROM Products";

            Statement st = dbConnection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int prId = rs.getInt("ProductId");
                int stId = rs.getInt("StoreId");
                String prName = rs.getString("ProductName");
                int qua = rs.getInt("Quantity");
                String ume = rs.getString("Um");
                int pri = rs.getInt("Price");

                Product p = new Product(prId, stId, prName, qua, ume, pri);

                products.add(p);

            }
            ConnectionFactory.close(rs);
            ConnectionFactory.close(st);
            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("View all products failed! ");
            System.err.println(er.getMessage());
        }

        return products;
    }

    public static void AddNewProduct(Product pr) {
        try {
            Connection dbConnection = ConnectionFactory.getConnection();

            String query = " insert into products (ProductId, StoreId, ProductName, Quantity, Um, Price)" + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = dbConnection.prepareStatement(query);

            st.setInt(1, pr.getProductId());
            st.setInt(2, pr.getStoreId());
            st.setString(3, pr.getProductName());
            st.setInt(4, pr.getQuantity());
            st.setString(5, pr.getUm());
            st.setInt(6, pr.getPrice());

            st.execute();

            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("Adding a new product failed! ");
            System.err.println(er.getMessage());
        }
    }


}
