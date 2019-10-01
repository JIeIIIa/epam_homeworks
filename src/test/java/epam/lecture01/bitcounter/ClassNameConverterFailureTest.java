package epam.lecture01.bitcounter;

import org.junit.Test;

public class ClassNameConverterFailureTest {

    @Test(expected = IllegalArgumentException.class)
    public void convertNotSupportedClassName() {
        ClassNameConverter instance = new ClassNameConverter();
        instance.convert("unknown");
    }
}
