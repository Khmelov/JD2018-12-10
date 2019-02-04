package by.it.titkovskaya.Calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        String expression;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser parser = new Parser();
        Printer printer = new Printer();

        Var.loadVarFromFile();
        while (!(expression = reader.readLine()).equalsIgnoreCase("END")) {
            String result;
            if (expression.equalsIgnoreCase("printvar")) {
                Var.showVar();
            } else if (expression.equalsIgnoreCase("sortvar")) {
                Var.showSortVar();
            } else try {
                result = parser.calc(expression);
                printer.print(result);
                if (Parser.printToLog)
                    printer.showCalculationInfo(expression, result);
            } catch (CalcException e) {
                printer.showError(e);
            }
        }
        Var.saveVarToFile();
    }
}