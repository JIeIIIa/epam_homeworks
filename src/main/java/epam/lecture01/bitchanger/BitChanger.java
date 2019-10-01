package epam.lecture01.bitchanger;

// 5. Используя побитовые операции изменить в переменной
//    типа int бит с номером pos на единицу, на 0

import java.util.Scanner;

public class BitChanger {

    private static final String YES = "y";

    public static void main(String[] args) {
        PositionValidator positionValidator = new PositionValidator();
        BitChangerService bitChangerService = new BitChangerService(positionValidator);
        int number = 0b011010;
        System.out.println("Before = " + number + "   After = " + bitChangerService.change(number, 1, true));
        System.out.println("Before = " + number + "   After = " + bitChangerService.change(number, 2, false));
        System.out.println("Before = " + number + "   After = " + bitChangerService.change(number, 32, true));

        Scanner scanner = new Scanner(System.in);
        System.out.print("number  : ");
        number = scanner.nextInt();
        System.out.print("position: ");
        int pos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Is the bit set? [Y/y] : ");
        boolean enabled = YES.equals(scanner.nextLine().trim().toLowerCase());
        System.out.println("Result: " + bitChangerService.change(number, pos, enabled));
    }
}
