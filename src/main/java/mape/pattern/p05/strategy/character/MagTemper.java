package mape.pattern.p05.strategy.character;

import mape.pattern.p05.strategy.move.WalkStrategy;

public class MagTemper extends Temper {
    public static final CharacterType TYPE = CharacterType.MAG;

    public MagTemper(String name) {
        super(new WalkStrategy(), name);
    }
}
