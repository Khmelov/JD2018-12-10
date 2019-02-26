package by.it.subach.jd03_02.beans;

public class Product {

    private int id;
    private String name;
    private double price;
    private String description;
    private int category_id;

    public Product() {
    }

    public Product(int id, String name, double price, String description, int category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
