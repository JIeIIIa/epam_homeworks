package mape.pattern.p11.decorator;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        Recipe recipe = new SimpleRecipe("My recipe", LocalDate.of(2019, 11, 22));
        System.out.println(recipe);

        System.out.println("Extend recipe:");
        recipe = new ExtendedRecipe(recipe, LocalDate.of(2019, 12, 1));
        System.out.println(recipe);
    }
}
