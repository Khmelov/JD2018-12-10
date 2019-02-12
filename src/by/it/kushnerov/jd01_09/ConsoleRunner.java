package by.it.kushnerov.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals("END")) {
            Var result = parcer.calc(expression);
//            try{
//                result = parcer.calc(expression);
//                printer.print(result);
//            } catch (CalcExeption e){
//                System.err.println(e);
//            }
        }
    }
}