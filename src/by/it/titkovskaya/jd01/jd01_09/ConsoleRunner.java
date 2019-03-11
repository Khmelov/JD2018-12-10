package by.it.titkovskaya.jd01.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals("END")) {
            Var result = parser.calc(expression);
            printer.print(result);
        }
    }
}