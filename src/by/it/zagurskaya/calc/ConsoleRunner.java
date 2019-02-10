package by.it.zagurskaya.calc;

import java.util.Map;
import java.util.Scanner;


public class ConsoleRunner {

    public static final String PRINTVAR = "printvar";
    public static final String END = "end";

    private static final Logger logger = Logger.getLogger();

    public static void main(String[] args) throws CalcException {
//        public static void main(String[] args) throws CalcException {
//        if (args.length == 0) {
//            Locale currentLocale = Locale.getDefault();
//            args = new String[]{currentLocale.getLanguage(),currentLocale.getCountry() };
//        }
//        args = new String[]{"ru", "RU"};
//        args = new String[]{"", ""};

        ReportBuilder reportBuilder = new ReportBuilder();
        // сдесь было время!!!!
//        Date startDateString = new Date();
//        Date finishDateString = new Date();
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        reportBuilder.setHeader().saveTimeStamp();
        while (!(expression = scanner.nextLine()).equals(END)) {
            logger.log(expression);
            reportBuilder.saveMessage(expression);
            try {
                if (LocalMessages.getSupportedLanguages().contains(expression)) {
                    LocalMessages.setLocale(expression);
                    continue;// переходит исполнение кода на условие while. Начало следующего цикла итерации по циклу
                }

                if (expression.contains(PRINTVAR)) {
                    //набор соотношений
                    Map<String, Var> varMap = VarCreator.getInstance().getVars();
                    // итерирование по набору(коллекции) отношений(соотношение) клю-значение из Map
                    for (Map.Entry<String, Var> varEntry : varMap.entrySet()) {
                        System.out.print(varEntry.getKey() + "=");
                        printer.print(varEntry.getValue().toString());
                    }
                } else {
                    String result = parcer.calc(expression);
////                    Var result = parcer.calc(expression);
                    printer.print(result);
                    reportBuilder.saveMessage(result);
                }
            } catch (CalcException e) {
                logger.log(e.getMessage());
                reportBuilder.saveMessage(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
        reportBuilder.saveTimeStamp().build();
    }
}
