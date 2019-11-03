package mape.pattern.p05.strategy.character;

import mape.pattern.p05.strategy.move.WalkStrategy;

public class OrkTemper extends Temper {
    public static final CharacterType TYPE = CharacterType.ORK;

    public OrkTemper(String name) {
        super(new WalkStrategy(), name);
    }
}
