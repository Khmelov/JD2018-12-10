package by.it.naron.jd03_02.beans;

import java.util.Objects;

public class Goods_flower {
    private long id;
    private String name;
    private String colour;
    private long size;
    private double price;

    public Goods_flower() {
    }

    public Goods_flower(long id, String name, String colour, long size, double price) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.size = size;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods_flower that = (Goods_flower) o;
        return id == that.id &&
                size == that.size &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, colour, size, price);
    }

    @Override
    public String toString() {
        return "Gds{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
