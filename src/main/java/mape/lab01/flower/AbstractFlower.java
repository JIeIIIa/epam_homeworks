package mape.lab01.flower;

import java.util.Objects;

public abstract class AbstractFlower {
    private final String NAME;

    private int length;

    private int freshnessLevel;

    public AbstractFlower(String name) {
        this.NAME = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFlower that = (AbstractFlower) o;
        return length == that.length &&
            freshnessLevel == that.freshnessLevel &&
            Objects.equals(NAME, that.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, length, freshnessLevel);
    }

    @Override
    public String toString() {
        return "NAME='" + NAME + '\'' +
            ", length=" + length +
            ", freshnessLevel=" + freshnessLevel;
    }
}
