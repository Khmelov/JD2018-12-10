package by.it.zagurskaya.project.java.beans;

import java.sql.Timestamp;

public class Duties implements Entity {
    private long id;
    private long userId;
    private Timestamp timestamp;
    private int number;
    private boolean isClose;

    public Duties() {
    }

    public Duties(long id, long userId, Timestamp timestamp, int number, boolean isClose) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.number = number;
        this.isClose = isClose;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getIsClose() {
        return isClose;
    }

    public void setIsClose(boolean close) {
        isClose = close;
    }

    @Override
    public String toString() {
        return "Duties{" +
                "id=" + id +
                ", userId=" + userId +
                ", timestamp=" + timestamp +
                ", number=" + number +
                ", isClose=" + isClose +
                '}';
    }
}
