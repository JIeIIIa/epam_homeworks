package mape.pattern.p04.factorymethod;

public class BoxCreator extends Creator {
    @Override
    public Shape create() {
        return new Box();
    }
}
