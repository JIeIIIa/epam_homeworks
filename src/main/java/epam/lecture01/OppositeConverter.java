package epam.lecture01;

import java.util.Scanner;

//2. За счет побитовых операций, изменить знак переменой с минуса на плюс.

public class OppositeConverter {
    public static void main(String[] args) {
        System.out.print("Input a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println("An opposite number (by version 1): " + convert(number));
        System.out.println("An opposite number (by version 2): " + convertV2(number));
    }

    /**
     * Returns an opposite number to a given number
     *
     * @param number a given number in range [-2_147_483_647, 2_147_483_647]
     * @return an opposite number to a given number
     * @throws IllegalArgumentException if a number is not contained in the specified range
     */
    static int convert(int number) {
        validate(number);
        return add(~number, 1);
    }

    /**
     * Returns an opposite number to a given number
     *
     * @param number a given number
     * @return an opposite number to a given number
     */
    static int convertV2(int number) {
        validate(number);
        return add(0xFFFFFFFF ^ number, 1);
    }

    /**
     * Validates number.
     *
     * @param number a number in range [-2_147_483_647, 2_147_483_647]
     * @throws IllegalArgumentException if a number is not contained in the specified range
     */
    private static void validate(int number) {
        if (Integer.MIN_VALUE == number) {
            throw new IllegalArgumentException("Argument should be in range [-2_147_483_647, 2_147_483_647]");
        }
    }

    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of two numbers
     */
    private static int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }
}
