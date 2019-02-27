package by.it.zagurskaya.project.java.beans;

import java.sql.Timestamp;

public class RateCB implements Entity{
    private long id;
    private long coming;
    private long spending;
    private Timestamp timestamp;
    private double sum;
    private boolean isBack;

    public RateCB() {
    }

    public RateCB(long id, long coming, long spending, Timestamp timestamp, double sum, boolean isBack) {
        this.id = id;
        this.coming = coming;
        this.spending = spending;
        this.timestamp = timestamp;
        this.sum = sum;
        this.isBack = isBack;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getComing() {
        return coming;
    }

    public void setComing(long coming) {
        this.coming = coming;
    }

    public long getSpending() {
        return spending;
    }

    public void setSpending(long spending) {
        this.spending = spending;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public boolean getIsBack() {
        return isBack;
    }

    public void setIsBack(boolean back) {
        isBack = back;
    }

    @Override
    public String toString() {
        return "RateCB{" +
                "id=" + id +
                ", coming=" + coming +
                ", spending=" + spending +
                ", timestamp=" + timestamp +
                ", sum=" + sum +
                ", isBack=" + isBack +
                '}';
    }
}


