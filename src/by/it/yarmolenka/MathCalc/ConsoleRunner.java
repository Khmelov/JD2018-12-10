package by.it.yarmolenka.MathCalc;

import by.it.yarmolenka.MathCalc.Variables.Var;

import java.io.*;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        String expression;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Var.loadVarsFromFile();
        while (!(expression = reader.readLine()).equalsIgnoreCase("end")) {
            try {
                expression = expression.trim();
                Var result = parcer.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                printer.showError(e);
            }
        }
        Var.saveVarsToFile();
    }
}
