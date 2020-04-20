package infoaccess;

import connection.ConnectionFactory;
import domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa se ocupa cu operatiile de
 * manipulare a datelor din tabela products si
 * implementeaza interfata DBAccessOperations.
 */
public class ProductBLL implements DBAccessOperations {

    public ProductBLL() {
    }

    @Override
    public List<Object> viewALL() {
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

    @Override
    public void insert(Object obj) {
        try {
            Connection dbConnection = ConnectionFactory.getConnection();
            Product pr = (Product) obj;
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

    @Override
    public void delete(int id) {
        try {
            Connection dbConnection = ConnectionFactory.getConnection();

            String query = " delete from products where ProductId = ?";
            PreparedStatement st = dbConnection.prepareStatement(query);
            st.setInt(1, id);
            st.execute();

            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("Deleting the product failed!");
            System.err.println(er.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        try {
            Connection dbConnection = ConnectionFactory.getConnection();
            Product pr = (Product) obj;
            String query = "update products set StoreId = ?,ProductName = ?,Quantity = ?,Um = ? ,Price = ?  where ProductId = ?";
            PreparedStatement st = dbConnection.prepareStatement(query);
            st.setInt(1, pr.getStoreId());
            st.setString(2, pr.getProductName());
            st.setInt(3, pr.getQuantity());
            st.setString(4, pr.getUm());
            st.setInt(5, pr.getPrice());
            st.setInt(6, pr.getProductId());
            st.execute();

            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("Updating the product failed!");
            System.err.println(er.getMessage());
        }
    }

}
