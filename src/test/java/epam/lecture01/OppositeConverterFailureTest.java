package epam.lecture01;

import org.junit.Test;

public class OppositeConverterFailureTest {
    @Test(expected = IllegalArgumentException.class)
    public void convertMinInteger() {
        OppositeConverter.convert(-2_147_483_648);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertV2MinInteger() {
        OppositeConverter.convertV2(-2_147_483_648);
    }
}