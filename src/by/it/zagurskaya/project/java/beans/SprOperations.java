package by.it.zagurskaya.project.java.beans;

public class SprOperations implements Entity {
    private long id;
    private String name;
    private String specification;

    public SprOperations() {
    }

    public SprOperations(long id, String name, String specification) {
        this.id = id;
        this.name = name;
        this.specification = specification;
    }

    @Override
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "SprOperations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}
