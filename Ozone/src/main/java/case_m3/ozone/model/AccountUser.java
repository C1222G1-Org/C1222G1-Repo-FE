package case_m3.ozone.model;

public class AccountUser {
    private int id;
    private String username;
    private String password;
    private boolean isUser;
    private boolean isAdmin;

    public AccountUser() {
    }

    public AccountUser(int id, String username, String password, boolean isUser, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isUser = isUser;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
