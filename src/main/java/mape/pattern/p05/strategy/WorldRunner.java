package mape.pattern.p05.strategy;

import mape.pattern.p05.strategy.character.*;
import mape.pattern.p05.strategy.move.MagicFlyStrategy;

import java.util.List;

import static java.util.Arrays.asList;

public class WorldRunner {
    public static void main(String[] args) {
        List<Temper> tempers = asList(
                new MagTemper("Gandalf"),
                new VampireTemper("Dracula"),
                new OrkTemper("Ork"),
                new HarpyTemper("Harpy"));

        System.out.println("Move all tempers with default strategy");
        for (Temper temper : tempers) {
            temper.move();
        }

        System.out.println("\nMove all tempers with magic");
        final MagicFlyStrategy magicFlyStrategy = new MagicFlyStrategy();

        for (Temper temper : tempers) {
            temper.magicMove(magicFlyStrategy);
        }
    }
}