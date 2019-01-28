package by.it.subach.jd01_09.CalcV3;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        while (!(expression = scanner.nextLine()).equalsIgnoreCase("end")) {
            Var result = null;
            try {
                result = parcer.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                printer.showError(e);
            }
        }
    }
}
