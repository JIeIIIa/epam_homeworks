package mape.pattern.p05.strategy.move;

public class FlyOrWalkStrategy implements MoveStrategy {
    @Override
    public void move(String name) {
        System.out.println(name + " is flying or walking...");
    }
}
