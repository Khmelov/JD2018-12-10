package by.it.dziomin.jd03_03.beans;

public class Role extends BaseEntity{
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
