package by.it.subach.Calc_V6_fabric_and_logging;

import by.it.subach.Calc_V6_fabric_and_logging.localization.TranslateManager;
import by.it.subach.Calc_V6_fabric_and_logging.reportBuilder.LongReportBuilder;
import by.it.subach.Calc_V6_fabric_and_logging.reportBuilder.ReportBuilder;
import by.it.subach.Calc_V6_fabric_and_logging.reportBuilder.ShortReportBuilder;

import java.util.Scanner;

public class ConsoleRunner {

    static ReportBuilder report;

    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        TranslateManager tm = TranslateManager.INSTANCE;
        Var.loadVarFromFile();
        for(; ;) {
            System.out.println("Выберите формат отчета (short/long)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("short")) {
                report = new ShortReportBuilder();
                System.out.println("Short log style");
                break;
            }
            else if (input.equalsIgnoreCase("long")) {
                report = new LongReportBuilder();
                System.out.println("Long log style");
                break;
            }
            else
                System.out.println("Input error. Try again");
        }
            report.printHeader();
            report.printStartUseTime();
        while (!(expression = scanner.nextLine()).equalsIgnoreCase("end")) {
            if (expression.equalsIgnoreCase("ru")) {
                tm.setLocale("ru", "RU");
                System.out.println("Сообщения об ошибках на русском языке");
            } else if (expression.equalsIgnoreCase("be")) {
                tm.setLocale("be", "BY");
                System.out.println("Паведамленнi аб памылках на беларускай мове");
            } else if (expression.equalsIgnoreCase("en")) {
                tm.setLocale("en", "US");
                System.out.println("Error messages an english");
            }
            else {
                String result;
                try {
                    result = parcer.calc(expression);
                    printer.print(result);
                    report.printOperations(expression, result);

                } catch (CalcException e) {
                    report.printExceptions(e);
                    printer.showError(e);
                }
            }
        }
        report.printEndUseTime();
        Var.saveVarToFile();
    }
}
