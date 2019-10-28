package mape.lab01.entity.bouquet;

import mape.lab01.Valuable;

import java.util.Objects;

public class Accessory implements Valuable {
    private int id;
    private String name;
    private int price;

    public Accessory() {
    }

    public Accessory(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessory accessory = (Accessory) o;
        return price == accessory.price &&
            Objects.equals(name, accessory.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Accessory{" +
            "name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}
