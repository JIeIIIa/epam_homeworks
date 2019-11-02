package mape.pattern.p05.strategy.character;

import mape.pattern.p05.strategy.move.FlyStrategy;

public class HarpyTemper extends Temper {
    public static final CharacterType TYPE = CharacterType.HARPY;

    public HarpyTemper(String name) {
        super(new FlyStrategy(), name);
    }
}
