package epam.lecture01.bitchanger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class BitChangerServiceTest {

    private BitChangerService instance;

    private PositionValidator validator;

    @Before
    public void setUp() {
        validator = Mockito.mock(PositionValidator.class);
        instance = new BitChangerService(validator);
    }

    @Test
    public void changeSuccess() {
        doNothing().when(validator).validate(eq(3));
        int given = 0b01101011;
        int expected = 0b01101111;

        int result = instance.change(given, 3, true);

        assertThat(result).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalPositionToChange() {
        doThrow(IllegalArgumentException.class).when(validator).validate(any(int.class));

        instance.change(42, 42, true);
    }
}