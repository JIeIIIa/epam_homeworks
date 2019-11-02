package mape.pattern.p05.strategy.move;

public class MagicFlyStrategy implements MoveStrategy {
    @Override
    public void move(String name) {
        System.out.println(name + " is flying with magic...");
    }
}
