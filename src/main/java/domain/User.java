package domain;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class User implements PropertyChangeListener {
    private int UserId;
    private String Username;
    private String Password;
    private Product favourite;

    public User(int userid, String username, String password) {
        UserId = userid;
        Username = username;
        Password = password;
        favourite = new Product();
    }

    public User() {

    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Product getFavourite() {
        return favourite;
    }

    public void setFavourite(Product favourite) {
        this.favourite = favourite;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.setFavourite((Product) evt.getNewValue());
    }
}
