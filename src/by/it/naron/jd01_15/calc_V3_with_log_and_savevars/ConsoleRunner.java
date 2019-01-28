package by.it.naron.jd01_15.calc_V3_with_log_and_savevars;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        Var.loadVarFromFile();
        while (!(expression = scanner.nextLine()).equalsIgnoreCase("END")) {
            Var result;
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