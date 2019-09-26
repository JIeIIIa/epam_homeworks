package epam.lecture01.bitchanger;

public class BitChangerService {
    private PositionValidator positionValidator;

    public BitChangerService(PositionValidator positionValidator) {
        this.positionValidator = positionValidator;
    }

    /**
     * Change a bit in the specified position in a given number
     *
     * @param number  a given number
     * @param pos     a position in which should to change the bit
     * @param enabled if true then 1 will be set in the specified position
     * @return a number with the changed bit
     * @throws IllegalArgumentException if a position the less than 1 or the greater than 32
     */
    int change(int number, int pos, boolean enabled) {
        positionValidator.validate(pos);
        int bit = enabled ? 1 : 0;
        int mask = 1 << pos - 1;
        return (number & ~mask) |
            ((bit << pos - 1) & mask);
    }
}
