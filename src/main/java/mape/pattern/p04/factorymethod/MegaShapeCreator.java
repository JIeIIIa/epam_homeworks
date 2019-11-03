package mape.pattern.p04.factorymethod;

public class MegaShapeCreator extends Creator {
    @Override
    public Shape create() {
        return new MegaShape();
    }
}
