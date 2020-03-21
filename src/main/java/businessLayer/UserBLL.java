package businessLayer;

import data.ConnectionFactory;
import tableclasses.Store;
import tableclasses.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupa cu operatiile de inserare, actualizare si stergere
 * aplicate pe tablela utiizatori.
 *
 * @author Cosma Catalin
 */
public class UserBLL {

    public static List<Object> ViewAllUsers() {

        List<Object> users = new ArrayList<Object>();

        try {
            Connection dbConnection = ConnectionFactory.getConnection();
            String query = "SELECT * FROM users";

            Statement st = dbConnection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int usId = rs.getInt("UserId");
                String usrn = rs.getString("Username");
                String pass = rs.getString("Password");

                User u = new User(usId, usrn, pass);

                users.add(u);

            }
            ConnectionFactory.close(rs);
            ConnectionFactory.close(st);
            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("View all users failed! ");
            System.err.println(er.getMessage());
        }

        return users;
    }

    public static void AddNewUser(User u) {
        try {
            Connection dbConnection = ConnectionFactory.getConnection();

            String query = " insert into users (UserId, Username, Password)" + " values (?, ?, ?)";
            PreparedStatement st = dbConnection.prepareStatement(query);

            st.setInt(1, u.getUserId());
            st.setString(2, u.getUsername());
            st.setString(3, u.getPassword());

            st.execute();

            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("Adding a new user failed! ");
            System.err.println(er.getMessage());
        }
    }

    public static void DeleteUser(int id) {

        try {
            Connection dbConnection = ConnectionFactory.getConnection();

            String query = " delete from users where UserId = ?";
            PreparedStatement st = dbConnection.prepareStatement(query);
            st.setInt(1, id);
            st.execute();

            ConnectionFactory.close(dbConnection);
        } catch (Exception er) {
            System.err.println("Deleting the user failed!");
            System.err.println(er.getMessage());
        }
    }


}
