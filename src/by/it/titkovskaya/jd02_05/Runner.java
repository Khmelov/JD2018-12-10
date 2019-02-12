package by.it.titkovskaya.jd02_05;

import by.it.titkovskaya.jd02_05.strings.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;

public class Runner {

    public static void main(String[] args) throws IOException {

        ResMan resMan = ResMan.INSTANCE;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (args.length == 2){
            resMan.setLocale(args[0], args[1]);
        }
        System.out.println(resMan.get(Programme.TO_START));
        String input=reader.readLine();
        if (input.equalsIgnoreCase(Language.EN)) {
            resMan.setLocale(Language.EN, Country.US);
            printMessage(resMan);
            instructionToFinish(resMan);
        } else if (input.equalsIgnoreCase(Language.RU)) {
            resMan.setLocale(Language.RU, Country.RU);
            printMessage(resMan);
            instructionToFinish(resMan);
        } else if (input.equalsIgnoreCase(Language.BE)) {
            resMan.setLocale(Language.BE, Country.BY);
            printMessage(resMan);
            instructionToFinish(resMan);
        } else {
            System.out.println(resMan.get(Programme.INCORRECT_INPUT));
            instructionToFinish(resMan);
        }

        while (!(input = reader.readLine()).equalsIgnoreCase(Programme.END)) {
            if (input.equalsIgnoreCase(Language.EN)) {
                resMan.setLocale(Language.EN, Country.US);
                printMessage(resMan);
            } else if (input.equalsIgnoreCase(Language.RU)) {
                resMan.setLocale(Language.RU, Country.RU);
                printMessage(resMan);
            } else if (input.equalsIgnoreCase(Language.BE)) {
                resMan.setLocale(Language.BE, Country.BY);
                printMessage(resMan);
            } else {
                System.out.println(resMan.get(Programme.INCORRECT_INPUT));
            }
        }
    }

    private static void instructionToFinish(ResMan resMan) {
        System.out.println();
        System.out.println(resMan.get(Programme.TO_FINISH));
    }

    private static void printMessage(ResMan resMan) {
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.NAME));
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,resMan.getLocale());
        System.out.println(dateFormat.format(new Date()));
        System.out.println();
    }
}



/*
Date date = new Date();
 */

/*
String messages = "by.it.titkovskaya.jd02_05.messages";
        Locale locale = new Locale("be","BY");
        ResourceBundle rb = ResourceBundle.getBundle(messages,locale);
        String Test = rb.getString(Message.WELCOME);
        System.out.println(Test);
 */