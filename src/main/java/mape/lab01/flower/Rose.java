package mape.lab01.flower;

import java.util.Objects;

public class Rose extends AbstractFlower {
    private int thorns;

    public Rose(int thorns) {
        super("Rose");
        this.thorns = thorns;
    }

    public int getThorns() {
        return thorns;
    }

    public void setThorns(int thorns) {
        this.thorns = thorns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rose rose = (Rose) o;
        return thorns == rose.thorns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), thorns);
    }

    @Override
    public String toString() {
        return "Rose{" +
            super.toString() +
            ", thorns=" + thorns +
            '}';
    }
}
