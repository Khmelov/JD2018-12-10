package by.it.zagurskaya.project.java.beans;

public class Currency implements Entity {
    private long id;
    private String iso;
    private String name;

    public Currency () {
    }

    public Currency(long id, String iso, String name) {
        this.id = id;
        this.iso = iso;
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", iso='" + iso + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
