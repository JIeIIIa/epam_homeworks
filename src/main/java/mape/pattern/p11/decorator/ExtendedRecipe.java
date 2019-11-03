package mape.pattern.p11.decorator;

import java.time.LocalDate;

public class ExtendedRecipe implements Recipe {
    private final Recipe originalRecipe;
    private final LocalDate extendedValidTo;

    public ExtendedRecipe(String recipe, LocalDate validTo) {
        this.originalRecipe = new SimpleRecipe(recipe, validTo);
        this.extendedValidTo = validTo;
    }

    public ExtendedRecipe(Recipe originalRecipe, LocalDate extendedValidTo) {
        this.originalRecipe = originalRecipe;
        validateNewDate(extendedValidTo, originalRecipe.getValidTo());
        this.extendedValidTo = extendedValidTo;
    }

    private void validateNewDate(LocalDate current, LocalDate previous) {
        if (current.isBefore(previous)) {
            throw new IllegalArgumentException("New validTo date should be after previous");
        }
    }

    @Override
    public String getRecipe() {
        return originalRecipe.getRecipe();
    }

    @Override
    public LocalDate getValidTo() {
        return extendedValidTo;
    }

    @Override
    public String toString() {
        String result = "ExtendedRecipe{" +
                "recipe=" + originalRecipe.getRecipe() +
                ", extendedValidTo=" + extendedValidTo;
        if (!originalRecipe.getValidTo().equals(extendedValidTo)) {
            result += " (previousValidTo=" + originalRecipe.getValidTo() + ")";
        }
        result += "}";

        return result;
    }
}
