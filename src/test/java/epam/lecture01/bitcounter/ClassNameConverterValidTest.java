package epam.lecture01.bitcounter;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ClassNameConverterValidTest {

    private ClassNameConverter instance = new ClassNameConverter();

    @Parameters(name = "{index}: convert(\"{0}\") = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"byte", byte.class}, {"BYTE", byte.class}, {"bYtE", byte.class}, {"Byte", byte.class},
            {"short", short.class}, {"SHORT", short.class}, {"sHoRt", short.class}, {"Short", short.class},
            {"int", int.class}, {"INT", int.class}, {"iNt", int.class}, {"Int", int.class},
            {"long", long.class}, {"LONG", long.class}, {"lOnG", long.class}, {"Long", long.class},
        });
    }
    
    @Parameter
    public String className;

    @Parameter(1)
    public Class expected;

    @Before
    public void setUp() {
        instance = new ClassNameConverter();
    }

    @Test
    public void convertValid() {
        Class result = instance.convert(className);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}