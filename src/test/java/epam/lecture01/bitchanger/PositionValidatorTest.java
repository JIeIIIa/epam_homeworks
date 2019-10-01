package epam.lecture01.bitchanger;

import org.junit.Before;
import org.junit.Test;

public class PositionValidatorTest {

    private PositionValidator validator;

    @Before
    public void setUp() {
        validator = new PositionValidator();
    }

    @Test
    public void validPosition() {
        validator.validate(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroPosition() {
        validator.validate(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativePosition() {
        validator.validate(-42);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLargePosition() {
        validator.validate(42);
    }
}