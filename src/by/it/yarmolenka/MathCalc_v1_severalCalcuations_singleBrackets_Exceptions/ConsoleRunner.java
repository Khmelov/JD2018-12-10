package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions;

import by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Variables.Var;

import java.io.*;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        String expression;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Var.loadVarsFromFile();
        while (!(expression = reader.readLine()).equals("end")) {
            try {
                Var result = parcer.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                printer.showError(e);
            }
        }
        Var.saveVarsToFile();
    }
}
