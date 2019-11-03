package mape.pattern.p11.decorator;

import java.time.LocalDate;

public class SimpleRecipe implements Recipe {
    private final String recipe;
    private final LocalDate validTo;

    public SimpleRecipe(String recipe, LocalDate validTo) {
        this.recipe = recipe;
        this.validTo = validTo;
    }

    public String getRecipe() {
        return recipe;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    @Override
    public String toString() {
        return "SimpleRecipe{" +
                "recipe='" + recipe + '\'' +
                ", validTo=" + validTo +
                '}';
    }
}
