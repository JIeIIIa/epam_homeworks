package epam.lecture01.bitcounter;

public class BitCounterService {
    /**
     * Finds total bits in a given class
     *
     * @param clazz {@link Class} for calculate. Expected byte, short, int or long
     * @return total bits in a given class
     * @throws IllegalArgumentException if class do not equal to one of the expected class
     */
    int proceed(Class clazz) {
        int count = 1;
        long number = 1;
        do {
            count++;
            if (clazz.equals(byte.class)) {
                number = (byte) (number << 1);
            } else if (clazz.equals(short.class)) {
                number = (short) (number << 1);
            } else if (clazz.equals(int.class)) {
                number = (int) (number << 1);
            } else if (clazz.equals(long.class)) {
                number = (number << 1);
            } else {
                throw new IllegalArgumentException("Class should be byte, short, int or long");
            }
        } while (number >= 0);

        return count;
    }
}
