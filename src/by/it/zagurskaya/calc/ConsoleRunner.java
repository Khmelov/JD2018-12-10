package by.it.zagurskaya.calc;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class ConsoleRunner {

    public static final String PRINTVAR = "printvar";
    public static final String END = "end";

    public static void main(String[] args) throws CalcException {
//        public static void main(String[] args) throws CalcException {
//        if (args.length == 0) {
//            Locale currentLocale = Locale.getDefault();
//            args = new String[]{currentLocale.getLanguage(),currentLocale.getCountry() };
//        }
//        args = new String[]{"ru", "RU"};
//        args = new String[]{"", ""};
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals(END)) {
            try {
                if (LocalMessages.getSupportedLanguages().contains(expression)) {
                    LocalMessages.setLocale(expression);
                    continue;// переходит исполнение кода на условие while. Начало следующего цикла итерации по циклу
                }

                if (expression.contains(PRINTVAR)) {
                    //набор соотношений
                    Map<String, Var> varMap = Var.getVars();
                    // итерирование по набору(коллекции) отношений(соотношение) клю-значение из Map
                    for (Map.Entry<String, Var> varEntry : varMap.entrySet()) {
                        System.out.print(varEntry.getKey() + "=");
                        printer.print(varEntry.getValue().toString());
                    }
                } else {
                    String result = parcer.calc(expression);
////                    Var result = parcer.calc(expression);
                    printer.print(result);
                }
            } catch ( CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
