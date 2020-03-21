package tableclasses;

public class User {
    private int UserId;
    private String Username;
    private String Password;

    public User(int userid, String username, String password) {
        UserId = userid;
        Username = username;
        Password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
