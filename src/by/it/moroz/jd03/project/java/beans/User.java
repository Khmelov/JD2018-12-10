package by.it.moroz.jd03.project.java.beans;

public class User {
    
    private long id;
    private String login;
    private String password;
    private String email;
    private String address;
    private String name;
    private String surname;
    private int numberphone;
    private long roles_id;

    public User() {
    }

    public User(long id, String login, String password, String email, String address, String name, String surname, int numberphone, long roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.address = address;
        this.name = name;
        this.surname = surname;
        this.numberphone = numberphone;
        this.roles_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public int getNumberphone() { return numberphone; }

    public void setNumberphone(int numberphone) { this.numberphone = numberphone; }

    public long getRoles_id() { return roles_id; }

    public void setRoles_id(long roles_id) { this.roles_id = roles_id; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", numberphone='" + numberphone + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
