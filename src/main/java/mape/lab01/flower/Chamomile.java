package mape.lab01.flower;

import java.util.Objects;

public class Chamomile extends AbstractFlower {
    private int petals;

    public Chamomile(int petals) {
        super("Chamomile");
        this.petals = petals;
    }

    public int getPetals() {
        return petals;
    }

    public void setPetals(int petals) {
        this.petals = petals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chamomile chamomile = (Chamomile) o;
        return petals == chamomile.petals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), petals);
    }

    @Override
    public String toString() {
        return "Chamomile{ " + super.toString() +
            ", petals=" + petals +
            '}';
    }
}
