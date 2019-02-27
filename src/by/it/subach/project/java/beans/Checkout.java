package by.it.subach.project.java.beans;

public class Checkout {

    private long id;
    private int checkoutStatus;
    private long order_id;

    public Checkout() {
    }

    public Checkout(long id, int checkoutStatus, long order_id) {
        this.id = id;
        this.checkoutStatus = checkoutStatus;
        this.order_id = order_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCheckoutStatus() {
        return checkoutStatus;
    }

    public void setCheckoutStatus(int checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "id=" + id +
                ", checkoutStatus=" + checkoutStatus +
                ", order_id=" + order_id +
                '}';
    }
}
