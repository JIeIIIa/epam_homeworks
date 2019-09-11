package epam.lecture01;


import java.util.Scanner;

// 4. Используя побитовые операции реализовать алгоритм Евклида нахождения НОД.
public class Euclid {
    public static void main(String[] args) {
        demo();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        System.out.printf("gdc(%d, %d) = %d", a, b, gcd(a, b));
    }

    private static void demo() {
        System.out.println("Examples (Greatest Common Divisor):");
        System.out.println("gcd(60, 24) = " + gcd(60, 24));
        System.out.println("gcd(24, 60) = " + gcd(24, 60));
    }

    /**
     * Finds a greatest common divisor. Implementation of the Euclid's algorithm.
     *
     * @param u the first number
     * @param v the second number
     * @return a greatest common divisor for two numbers
     */
    private static int gcd(int u, int v) {
        int shift;

        if (u == 0) return v;
        if (v == 0) return u;

        for (shift = 0; ((u | v) & 1) == 0; ++shift) {
            u >>= 1;
            v >>= 1;
        }

        while ((u & 1) == 0) {
            u >>= 1;
        }

        do {
            while ((v & 1) == 0) {
                v >>= 1;
            }

            if (u > v) {
                int t = v;
                v = u;
                u = t;
            }

            v = subtract(v, u);
        } while (v != 0);

        return u << shift;
    }

    /**
     * Subtracts the second number from the first number.
     *
     * @param a the first number
     * @param b the second number
     * @return subtraction of two numbers
     */
    private static int subtract(int a, int b) {
        if (b == 0) {
            return a;
        }

        return subtract(a ^ b, (~a & b) << 1);
    }
}
