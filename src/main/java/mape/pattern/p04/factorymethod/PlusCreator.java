package mape.pattern.p04.factorymethod;

public class PlusCreator extends Creator {
    @Override
    public Shape create() {
        return new Plus();
    }
}
