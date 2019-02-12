package by.it.skosirskiy.calculator;

import java.util.Scanner;

public class ConsoleRunner {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;

        Parcer parser= new Parcer();
        Printer printer = new Printer();
        Var.loadVarFromFile();
        Log.getCountLineLog();
        while (!(line = scan.nextLine()).equals("end")){

            try {
                Var result = parser.calc(line);
                printer.print(result);
                Log.saveLogOperations(line,result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                printer.showError(e);
            }


        }
        Var.saveVarToFile();
    }

}
