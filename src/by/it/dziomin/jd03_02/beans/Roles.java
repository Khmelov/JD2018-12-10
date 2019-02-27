package by.it.dziomin.jd03_02.beans;

public class Roles {
    private long id;
    private String name;

    public Roles(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Roles() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
