package mape.pattern.p05.strategy.character;

import mape.pattern.p05.strategy.move.MoveStrategy;

public abstract class Temper {
    private final MoveStrategy defaultMoveStrategy;
    private final String name;

    protected Temper(MoveStrategy defaultMoveStrategy, String name) {
        this.defaultMoveStrategy = defaultMoveStrategy;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {
        defaultMoveStrategy.move(name);
    }

    public void magicMove(MoveStrategy moveStrategy) {
        moveStrategy.move(name);
    }
}
