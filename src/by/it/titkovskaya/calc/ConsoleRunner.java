package by.it.titkovskaya.calc;

import by.it.titkovskaya.calc.internationalization.strings.Country;
import by.it.titkovskaya.calc.internationalization.strings.Language;
import by.it.titkovskaya.calc.internationalization.strings.Programme;
import by.it.titkovskaya.calc.internationalization.strings.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        ResMan resMan = ResMan.INSTANCE;
        if (args.length == 2){
            resMan.setLocale(args[0], args[1]);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser parser = new Parser();
        Printer printer = new Printer();
        choosingLanguage(resMan, reader);
        String expression;
        Var.loadVarFromFile();
        while (!(expression = reader.readLine()).equalsIgnoreCase(Service.END)) {
            String result;
            if (expression.equalsIgnoreCase(Service.PRINTVAR)) {
                Var.showVar();
            } else if (expression.equalsIgnoreCase(Service.SORTVAR)) {
                Var.showSortVar();
            } else if (expression.equalsIgnoreCase(Language.EN)) {
                resMan.setLocale(Language.EN, Country.US);
            } else if (expression.equalsIgnoreCase(Language.RU)) {
                resMan.setLocale(Language.RU, Country.RU);
            } else if (expression.equalsIgnoreCase(Language.BE)) {
                resMan.setLocale(Language.BE, Country.BY);
            }else try {
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

    private static void choosingLanguage(ResMan resMan, BufferedReader reader) throws IOException {
        System.out.println(resMan.get(Service.TO_START));
        String expression= reader.readLine();
        if (expression.equalsIgnoreCase(Language.EN)) {
            resMan.setLocale(Language.EN, Country.US);
            welcomeMessages(resMan);
        } else if (expression.equalsIgnoreCase(Language.RU)) {
            resMan.setLocale(Language.RU, Country.RU);
            welcomeMessages(resMan);
        } else if (expression.equalsIgnoreCase(Language.BE)) {
            resMan.setLocale(Language.BE, Country.BY);
            welcomeMessages(resMan);
        } else {
            System.out.println(resMan.get(Programme.INCORRECT_INPUT));
            choosingLanguage(resMan, reader);
        }
    }

    private static void welcomeMessages(ResMan resMan) {
        System.out.println(resMan.get(Service.START_CALCULATION));
        System.out.println(resMan.get(Service.TO_PRINTVAR));
        System.out.println(resMan.get(Service.TO_SORTVAR));
        System.out.println(resMan.get(Service.CHANGE_LANGUAGE));
        System.out.println(resMan.get(Service.TO_FINISH));
        System.out.println();
    }
}