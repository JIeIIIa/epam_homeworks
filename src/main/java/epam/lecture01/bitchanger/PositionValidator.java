package epam.lecture01.bitchanger;

public class PositionValidator {

    /**
     * Validates a bit position in number.
     *
     * @param pos a position in which should to change the bit
     * @throws IllegalArgumentException if a position the less than 1 or the greater than 32
     */
    public void validate(int pos) {
        if (pos < 1 || pos > 32) {
            throw new IllegalArgumentException("Position should be in range [1, 32]");
        }
    }
}
