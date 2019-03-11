package by.it.titkovskaya.project.java.beans;

import java.sql.Timestamp;

public class Payment {

    private long id;
    private Timestamp date;
    private double amount;
    private String recipient;
    private long accounts_id;

    public Payment() {
    }

    public Payment(long id, Timestamp date, double amount, String recipient, long accounts_id) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.recipient = recipient;
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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public long getAccounts_id() {
        return accounts_id;
    }

    public void setAccounts_id(long accounts_id) {
        this.accounts_id = accounts_id;
    }

    @Override
    public String toString() {
        return "\nPayment{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", recipient='" + recipient + '\'' +
                ", accounts_id=" + accounts_id +
                '}';
    }
}
