package epam.lecture01;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BinaryConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void convertValid() {
        int result = BinaryConverter.convert("11001");

        Assertions.assertThat(result).isEqualTo(25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertNull() {
        BinaryConverter.convert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertEmptyString() {
        BinaryConverter.convertWithBitwise("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertIllegalString() {
        BinaryConverter.convert("12343");
    }


    @Test
    public void convertWithBitwiseValid() {
        int result = BinaryConverter.convertWithBitwise("11001");

        Assertions.assertThat(result).isEqualTo(25);
    }

    @Test
    public void convertWithBitwiseNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(CoreMatchers.containsString("NOT be null or empty"));

        BinaryConverter.convertWithBitwise(null);
    }

    @Test
    public void convertWithBitwiseEmptyString() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(CoreMatchers.containsString("NOT be null or empty"));

        BinaryConverter.convertWithBitwise("");
    }

    @Test
    public void convertWithBitwiseIllegalString() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(CoreMatchers.containsString("Argument should contain"));

        BinaryConverter.convertWithBitwise("12343");
    }
}