package mape.lab01.entity.flower;

import mape.lab01.Valuable;

import java.util.Objects;

public abstract class AbstractFlower implements Valuable {
    private int id;

    private final String NAME;

    private int length;

    private int freshnessLevel;

    private int price;

    public AbstractFlower(String name) {
        this.NAME = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return NAME;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public void setFreshnessLevel(int freshnessLevel) {
        this.freshnessLevel = freshnessLevel;
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
        AbstractFlower that = (AbstractFlower) o;
        return length == that.length &&
            freshnessLevel == that.freshnessLevel &&
            price == that.price &&
            Objects.equals(NAME, that.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, length, freshnessLevel, price);
    }

    @Override
    public String toString() {
        return "NAME='" + NAME + '\'' +
            ", length=" + length +
            ", price=" + price +
            ", freshnessLevel=" + freshnessLevel;
    }
}
