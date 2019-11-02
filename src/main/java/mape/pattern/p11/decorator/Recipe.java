package mape.pattern.p11.decorator;

import java.time.LocalDate;

public interface Recipe {

    String getRecipe();

    LocalDate getValidTo();
}
