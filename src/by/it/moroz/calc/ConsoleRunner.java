package by.it.moroz.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        String input;
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

        Var.loadVarFromFile();

        while (!(input = scanner.nextLine()).equalsIgnoreCase("end")) {
            String result;
            if (input.equalsIgnoreCase("printvar")) {
                System.out.println("Список переменных:");
                Var.printVar();
            } else if (input.equalsIgnoreCase("sortvar")) {
                System.out.println("Отсортированный список переменных:");
                Var.sortVar();
            } else try {
                result = parser.calc(input);
                printer.print(result);

            } catch (CalcException calcException) {
                printer.showError(calcException);
            }
        }
        Var.saveVarToFile();
    }
}
