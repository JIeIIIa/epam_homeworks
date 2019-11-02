package mape.pattern.p05.strategy.character;

import mape.pattern.p05.strategy.move.FlyOrWalkStrategy;

public class VampireTemper extends Temper {
    public static final CharacterType TYPE = CharacterType.VAMPIRE;

    public VampireTemper(String name) {
        super(new FlyOrWalkStrategy(), name);
    }
}
