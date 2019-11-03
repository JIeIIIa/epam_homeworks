package mape.pattern.p04.factorymethod;

public class LineCreator extends Creator {
    @Override
    public Shape create() {
        return new Line();
    }
}
