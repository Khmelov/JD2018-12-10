package by.it.naron.project.java.beans;

import java.sql.Timestamp;
import java.util.Objects;

public class Orders {
    private long id;
    private long  amount;
    private long time_delivery;
    private Timestamp date_orders;
    private double total_price;
    private long users_id;
    private long ad_id;

    public Orders() {
    }

    public Orders(long id, long amount, long time_delivery,
                  Timestamp date_orders, double total_price,
                  long users_id, long ad_id) {
        this.id = id;
        this.amount = amount;
        this.time_delivery = time_delivery;
        this.date_orders = date_orders;
        this.total_price = total_price;
        this.users_id = users_id;
        this.ad_id = ad_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTime_delivery() {
        return time_delivery;
    }

    public void setTime_delivery(long time_delivery) {
        this.time_delivery = time_delivery;
    }

    public Timestamp getDate_orders() {
        return date_orders;
    }

    public void setDate_orders(Timestamp date_orders) {
        this.date_orders = date_orders;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public long getAd_id() {
        return ad_id;
    }

    public void setAd_id(long ad_id) {
        this.ad_id = ad_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                amount == orders.amount &&
                time_delivery == orders.time_delivery &&
                Double.compare(orders.total_price, total_price) == 0 &&
                users_id == orders.users_id &&
                ad_id == orders.ad_id &&
                Objects.equals(date_orders, orders.date_orders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, amount, time_delivery, date_orders, total_price,
                users_id, ad_id);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", amount=" + amount +
                ", time_delivery=" + time_delivery +
                ", date_orders=" + date_orders +
                ", total_price=" + total_price +
                ", users_id=" + users_id +
                ", ad_id=" + ad_id +
                '}';
    }
}
