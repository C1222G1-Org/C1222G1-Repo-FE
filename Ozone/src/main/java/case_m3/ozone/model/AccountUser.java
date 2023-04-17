package case_m3.ozone.model;

public class AccountUser {
    private int id;
    private String username;
    private String password;
    private String email;
    private boolean isUser;
    private boolean isAdmin;

    public AccountUser() {
    }

    public AccountUser(int id, String username, String password, String email, boolean isUser, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isUser = isUser;
        this.isAdmin = isAdmin;
    }

    public AccountUser(int id, String username) {
        this.id = id;
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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