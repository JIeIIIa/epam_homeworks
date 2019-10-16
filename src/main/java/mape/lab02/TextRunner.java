package mape.lab02;

import mape.lab02.service.TextService;
import mape.lab02.text.Char;
import mape.lab02.text.Text;
import java.util.Scanner;

public class TextRunner {
    private static String TEXT = "Java is a general-purpose programming language that is class-based, \n" +
        "object-oriented (although not a pure object-oriented language, as it contains primitive types), \n" +
        "and designed to have as few implementation dependencies as possible. \n" +
        "It is intended to let application developers write once, run anywhere (WORA), \n" +
        "meaning that compiled Java code can run on all platforms that support Java without the need \n" +
        "for recompilation. Java applications are typically compiled to bytecode that can run on any Java \n" +
        "virtual machine (JVM) regardless of the underlying computer architecture. The syntax of Java is similar \n" +
        "to C and C++, but it has fewer low-level facilities than either of them. As of 2019, Java was one \n" +
        "of the most popular programming languages in use according to GitHub, particularly for client-server \n" +
        "web applications, with a reported 9 million developers.\n";

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(TEXT);
        System.out.println();

        System.out.print("Enter char to sort words>>");
        char enteredChar = scanner.nextLine().charAt(0);
        Char ch = new Char(enteredChar);

        TextService textService = new TextService();
        Text parsedText = textService.parse(TEXT);
        textService.sortByCharCount(parsedText, ch)
            .forEach(System.out::println);
    }
}
