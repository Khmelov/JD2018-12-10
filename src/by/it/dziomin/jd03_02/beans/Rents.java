package by.it.dziomin.jd03_02.beans;

public class Rents {
    private long id;
    private long date;
    private double price;
    private int isOpen;
    private long usersId;
    private long carsId;

    public Rents(long id, long date, double price, int isOpen, long usersId, long carsId) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.usersId = usersId;
        this.carsId = carsId;
    }

    public Rents() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public long getCarsId() {
        return carsId;
    }

    public void setCarsId(long carsId) {
        this.carsId = carsId;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", date=" + date +
                ", price=" + price +
                ", isOpen=" + isOpen +
                ", usersId=" + usersId +
                ", carsId=" + carsId +
                '}';
    }
}
