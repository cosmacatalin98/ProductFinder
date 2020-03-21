package infoaccess;

import connection.ConnectionFactory;
import domain.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa se ocupa cu operatiile de
 * manipulare a datelor din tabela stores.
 */
public class StoreBLL {

    public static List<Object> ViewAllStores() {

        List<Object> stores = new ArrayList<Object>();

        try {
            Connection dbConnection = ConnectionFactory.getConnection();
            String query = "SELECT * FROM Stores";

            Statement st = dbConnection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int stId = rs.getInt("StoreId");
                String stName = rs.getString("Name");
                String addr = rs.getString("Address");

                Store s = new Store(stId, stName, addr);

                stores.add(s);

            }
            ConnectionFactory.close(rs);
            ConnectionFactory.close(st);
            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("View all stores failed! ");
            System.err.println(er.getMessage());
        }

        return stores;
    }

    public static void AddNewStore(Store s) {
        try {
            Connection dbConnection = ConnectionFactory.getConnection();

            String query = " insert into stores (StoreId, Name, Address)" + " values (?, ?, ?)";
            PreparedStatement st = dbConnection.prepareStatement(query);

            st.setInt(1, s.getStoreId());
            st.setString(2, s.getName());
            st.setString(3, s.getAddress());

            st.execute();

            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("Adding a new store failed! ");
            System.err.println(er.getMessage());
        }
    }

    public static void DeleteStore(int id) {

        try {
            Connection dbConnection = ConnectionFactory.getConnection();

            String query = " delete from stores where StoreId = ?";
            PreparedStatement st = dbConnection.prepareStatement(query);
            st.setInt(1, id);
            st.execute();

            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("Deleting the store failed!");
            System.err.println(er.getMessage());
        }
    }


}
