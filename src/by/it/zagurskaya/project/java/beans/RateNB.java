package by.it.zagurskaya.project.java.beans;

import java.sql.Date;

public class RateNB implements Entity {
    private long id;
    private long currencyId;
    private Date date;
    private double sum;

    public RateNB() {
    }

    public RateNB(long id, long currencyId, Date date, double sum) {
        this.id = id;
        this.currencyId = currencyId;
        this.date = date;
        this.sum = sum;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "RateNB{" +
                "id=" + id +
                ", currencyId=" + currencyId +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }
}
