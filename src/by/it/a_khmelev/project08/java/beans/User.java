package by.it.a_khmelev.project08.java.beans;

public class User {

    private long id;
    private String login;
    private String email;
    private String password;
    private long roles_id;

    public User() {
    }

    public User(long id, String login, String email, String password, long roles_id) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.roles_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
