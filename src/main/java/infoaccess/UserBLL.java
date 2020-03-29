package infoaccess;

import connection.ConnectionFactory;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa se ocupa cu operatiile de
 * manipulare a datelor din tabela users.
 */
public class UserBLL implements DBAccessOperations {
    public UserBLL() {
    }

    @Override
    public List<Object> viewALL() {
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

    @Override
    public void insert(Object obj) {
        try {
            Connection dbConnection = ConnectionFactory.getConnection();
            User u = (User) obj;

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

    @Override
    public void delete(int id) {
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

    @Override
    public void update(Object obj) {

    }

    @Override
    public boolean findByID(int id) {
        return false;
    }

    @Override
    public boolean findByName(String name) {
        return false;
    }

}
