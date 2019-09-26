package epam.lecture01.bitcounter;

// 3. Используя побитовые операции подсчитать
//    количество занимаемых бит для byte,short, int, long.

public class BitCounter {
    public static void main(String[] args) {
        System.out.println("byte  has " + proceed(byte.class) + " bits");
        System.out.println("short has " + proceed(short.class) + " bits");
        System.out.println("int   has " + proceed(int.class) + " bits");
        System.out.println("long  has " + proceed(long.class) + " bits");
    }

    /**
     * Finds total bits in a given class
     *
     * @param clazz {@link Class} for calculate. Expected byte, short, int or long
     * @return total bits in a given class
     * @throws IllegalArgumentException if class do not equal to one of the expected class
     */
    private static int proceed(Class clazz) {
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
