package by.it.titkovskaya.jd03.jd03_02.beans;

import java.sql.Timestamp;

public class Replenishment {

    private long id;
    private Timestamp date;
    private double amount;
    private long accounts_id;

    public Replenishment() {
    }

    public Replenishment(long id, Timestamp date, double amount, long accounts_id) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.accounts_id = accounts_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getAccounts_id() {
        return accounts_id;
    }

    public void setAccounts_id(long accounts_id) {
        this.accounts_id = accounts_id;
    }

    @Override
    public String toString() {
        return "Replenishment{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", accounts_id=" + accounts_id +
                '}';
    }
}
