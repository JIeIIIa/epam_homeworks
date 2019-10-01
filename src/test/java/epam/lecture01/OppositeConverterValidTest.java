package epam.lecture01;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OppositeConverterValidTest {

    @Parameters(name = "{index}: opposite({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {0, 0},
            {10, -10}, {42, -42}, {12345, -12345}, {214325686, -214325686},
            {-10, 10}, {-42, 42}, {-12345, 12345}, {-214325686, 214325686}
        });
    }

    @Parameter
    public int input;

    @Parameter(1)
    public int expected;

    @Test
    public void convertValid() {
        int result = OppositeConverter.convert(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void convertV2Valid() {
        int result = OppositeConverter.convertV2(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}