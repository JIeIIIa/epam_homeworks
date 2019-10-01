package epam.lecture01.bitcounter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BitCounterServiceTest {
    @InjectMocks
    private BitCounterService instance;

    @Mock
    private ClassNameConverter classNameConverter;

    @Test
    public void byteValidTest() {
        validTestCase("byte", byte.class, 8);
    }

    @Test
    public void shortValidTest() {
        validTestCase("short", short.class, 16);
    }

    @Test
    public void intValidTest() {
        validTestCase("int", int.class, 32);
    }

    @Test
    public void longValidTest() {
        validTestCase("long", long.class, 64);
    }

    @Test(expected = IllegalArgumentException.class)
    public void unsupportedClassName() {
        when(classNameConverter.convert(anyString())).thenReturn(Object.class);
        instance.proceed("byte");
    }

    private void validTestCase(String className, Class clazz, int expected) {
        when(classNameConverter.convert(eq(className))).thenReturn(clazz);

        int result = instance.proceed(className);

        assertThat(result).isEqualTo(expected);
        verify(classNameConverter, times(1)).convert(eq(className));
        verifyNoMoreInteractions(classNameConverter);
    }
}