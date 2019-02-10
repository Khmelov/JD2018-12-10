package by.it.subach.calc_V4;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        Var.loadVarFromFile();
        while (!(expression = scanner.nextLine()).equalsIgnoreCase("end")) {
            String result;
            try {
                result = parcer.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                printer.showError(e);
            }
        }
        Var.saveVarToFile();
    }
}
