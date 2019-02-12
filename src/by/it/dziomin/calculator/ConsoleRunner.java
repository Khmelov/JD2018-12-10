package by.it.dziomin.calculator;


import by.it.dziomin.calculator.vars.Var;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        Printer printer = new Printer();
        Parser pars = new Parser();
        Var var;

//        ReportDispatcher reportDispatcher = new ReportDispatcher();
//        reportDispatcher.preDispatch();


        while (!(input = sc.nextLine()).equalsIgnoreCase("END")) {
//            reportDispatcher.setFullReportOperations(input);
            try {
                var = pars.calc(input);
                if (var != null) {
                    printer.print(var);
//                    reportDispatcher.setFullReportOperations(var.toString());
                }
            } catch (CalcException e) {
//                reportDispatcher.setFullReportOperations(e.getMsg());
                printer.print(e.getMsg());
            }
        }

//        if (reportDispatcher.isBuildReport()) {
//            reportDispatcher.setDateEnd(DateFormat.getDateInstance());
//            reportDispatcher.buildReport();

    }

}


