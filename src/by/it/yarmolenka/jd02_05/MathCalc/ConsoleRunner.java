package by.it.yarmolenka.jd02_05.MathCalc;

import by.it.yarmolenka.jd02_05.MathCalc.Strings.Exit;
import by.it.yarmolenka.jd02_05.MathCalc.Strings.Language;
import by.it.yarmolenka.jd02_05.MathCalc.Strings.Message;
import by.it.yarmolenka.jd02_05.MathCalc.Variables.Var;
import by.it.yarmolenka.jd02_05.strings.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        String expression;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        ResMan resMan = ResMan.INSTANCE;
        Var.loadVarsFromFile();
        while (true) {
            expression = reader.readLine();
            if (expression.equalsIgnoreCase(Exit.END)) break;
            if (expression.equalsIgnoreCase(Language.RU)) {
                resMan.setLocale(Language.RU, Country.RU);
                System.out.println(resMan.get(Message.LANGUAGE));
                continue;
            }
            if (expression.equalsIgnoreCase(Language.BE)) {
                resMan.setLocale(Language.BE, Country.BY);
                System.out.println(resMan.get(Message.LANGUAGE));
                continue;
            }
            if (expression.equalsIgnoreCase(Language.EN)) {
                resMan.setLocale(Language.EN, Country.US);
                System.out.println(resMan.get(Message.LANGUAGE));
                continue;
            }
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
