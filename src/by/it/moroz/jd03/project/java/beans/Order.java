package by.it.moroz.jd03.project.java.beans;

public class Order {
    
    private long id;
    private String name;
    private int count;
    private double price;
    private double check;
    private long users_id;

    public Order() {
    }

    public Order(long id, String name, int count, double price, double check, long users_id) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.check = check;
        this.users_id = users_id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public double getCheck() { return check; }

    public void setCheck(double check) { this.check = check; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", check=" + check +
                ", users_id=" + users_id +
                '}';
    }
}
