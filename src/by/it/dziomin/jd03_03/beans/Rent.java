package by.it.dziomin.jd03_03.beans;

import java.util.Date;

public class Rent extends BaseEntity{
    private Date date;
    private Double price;
    private Boolean isOpen;
    private Long userId;
    private Long carId;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + getId() +
                ", date=" + date +
                ", price=" + price +
                ", isOpen=" + isOpen +
                ", userId=" + userId +
                ", carId=" + carId +
                '}';
    }
}
