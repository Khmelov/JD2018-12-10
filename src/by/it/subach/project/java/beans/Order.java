package by.it.subach.project.java.beans;

public class Order {

    private long id;
    private long user_id;
    private long product_id;

    public Order() {
    }

    public Order(long id, long user_id, long product_id) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                '}';
    }
}
