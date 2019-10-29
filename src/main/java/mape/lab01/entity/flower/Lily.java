package mape.lab01.entity.flower;

import java.util.Objects;

public class Lily extends AbstractFlower{
    private final int size;

    public Lily(int size) {
        super("Lily");
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lily lily = (Lily) o;
        return size == lily.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    @Override
    public String toString() {
        return "Lily{ " + super.toString() +
            ", size=" + size +
            '}';
    }
}
