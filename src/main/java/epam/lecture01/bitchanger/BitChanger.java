package epam.lecture01.bitchanger;

// 5. Используя побитовые операции изменить в переменной
//    типа int бит с номером pos на единицу, на 0

import java.util.Scanner;

public class BitChanger {

    private static final String YES = "y";

    public static void main(String[] args) {
        int number = 0b011010;
        System.out.println("Before = " + number + "   After = " + change(number, 1, true));
        System.out.println("Before = " + number + "   After = " + change(number, 2, false));
        System.out.println("Before = " + number + "   After = " + change(number, 32, true));

        Scanner scanner = new Scanner(System.in);
        System.out.print("number  : ");
        number = scanner.nextInt();
        System.out.print("position: ");
        int pos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Is the bit set? [Y/y] : ");
        boolean enabled = YES.equals(scanner.nextLine().trim().toLowerCase());
        System.out.println("Result: " + change(number, pos, enabled));
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
    private static int change(int number, int pos, boolean enabled) {
        if (pos < 1 || pos > 32) {
            throw new IllegalArgumentException("Position should be in range [1, 32]");
        }
        int bit = enabled ? 1 : 0;
        int mask = 1 << pos - 1;
        return (number & ~mask) |
            ((bit << pos - 1) & mask);
    }
}
