package mape.pattern.p04.factorymethod;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Game {
    private final static int CREATE_MEGA_SHAPE_PROBABILITY = 7;
    private final MegaShapeCreator megaShapeCreator = new MegaShapeCreator();

    public void play(int count) {
        final List<Creator> creators = getCreators();
        final List<Shape> shapes = generate(count, creators);
        for (Shape shape : shapes) {
            mutate(shape).print();
            System.out.println();
        }
    }

    private List<Creator> getCreators() {
        return asList(
                new BoxCreator(),
                new LineCreator(),
                new PlusCreator());
    }

    private List<Shape> generate(int count, final List<Creator> creators) {
        return ThreadLocalRandom.current()
                .ints(count, 0, creators.size())
                .boxed()
                .map(creators::get)
                .map(Creator::create)
                .collect(Collectors.toList());
    }

    private Shape mutate(Shape shape) {
        final int p = ThreadLocalRandom.current().nextInt(100);
        if (p <= CREATE_MEGA_SHAPE_PROBABILITY) {
            return megaShapeCreator.create();
        } else {
            return shape;
        }
    }
}
