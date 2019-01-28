package by.it.dziomin.calculator;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        Printer printer = new Printer();
        Parser pars = new Parser();
        Logger.printToFile("ERROR:");
        while (!(input = sc.nextLine()).equalsIgnoreCase("END")) {
            try {
                printer.print(pars.calc(input));
            } catch (CalcException e) {
                printer.print(e.getMsg());
            }
        }
    }
}