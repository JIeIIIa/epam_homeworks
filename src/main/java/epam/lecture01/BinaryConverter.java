package epam.lecture01;

//1. Ввести с консоли число в бинарном формате.
//   Перевести его в int и вывести на экран (“10” -> 2).
//   (не используя утильные готовые методы).

import java.util.Scanner;

public class BinaryConverter {
    public static void main(String[] args) {
        System.out.print("Input a binary number: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("Result as a decimal number: " + convert(line));
        System.out.println("Result as a decimal number (with bitwise operation): " + convertWithBitwise(line));
    }

    /**
     * Converts string that contains a binary number to int
     *
     * @param line string representation of a binary number
     * @return int representation of a string with a binary number
     */
    static int convert(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Argument should NOT be null or empty");
        }
        int pow = 1;
        int result = 0;

        for (int i = line.length() - 1; i >= 0; i--) {
            char letter = line.charAt(i);
            if (letter != '0' && letter != '1') {
                throw new IllegalArgumentException("Argument should contain '0' or '1'");
            }
            result += letter == '1' ? pow : 0;
            pow *= 2;
        }
        return result;
    }

    /**
     * Converts string that contains a binary number to int
     *
     * @param line string representation of a binary number
     * @return int representation of a string with a binary number
     * @throws IllegalArgumentException if a line is null, empty or contains a character that is not '0' or '1'
     */
    static int convertWithBitwise(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Argument should NOT be null or empty");
        }
        int result = 0;

        for (int i = 0; i < line.length(); i++) {

            char letter = line.charAt(line.length() - 1 - i);
            if (letter != '0' && letter != '1') {
                throw new IllegalArgumentException("Argument should contain '0' or '1'");
            }
            result = add(result, letter == '1' ? 1 << i : 0);
        }
        return result;
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
