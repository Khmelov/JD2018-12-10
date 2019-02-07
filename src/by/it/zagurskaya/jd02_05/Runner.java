package by.it.zagurskaya.jd02_05;

import by.it.zagurskaya.jd02_05.strings.Message;
import by.it.zagurskaya.jd02_05.strings.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Runner {
    public static final String END = "end";

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"", ""};
        }
//        args = new String[]{"ru", "RU"};
//        args = new String[]{"", ""};

        printToScreenWitchLocal(args);
        String expression;
        Scanner scanner = new Scanner(System.in);
        while (!(expression = scanner.nextLine()).equals(END)) {
            printToScreenWitchLocal(expressionToLocalString(expression));
        }
    }

    public static void printToScreenWitchLocal(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        if (args.length == 2) {
            resMan.setLocale(args[0], args[1]);
        }
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.NAME));
        SimpleDateFormat dff = new SimpleDateFormat("dd MMMMM yyyy", new Locale(args[0]));
        System.out.println(dff.format(new Date()));
        System.out.println("you will choose a locale! ru -Russian Local, be - Belarusian Local, en - English Local, end - close programm.");
    }

    public static String[] expressionToLocalString(String expression) {
        String[] args = new String[]{"", ""};
        switch (expression) {
            case "ru":
                args = new String[]{"ru", "RU"}; break;
            case "be":
                args = new String[]{"be", "BY"}; break;
            case "en":
                args = new String[]{"", ""}; break;
            default:
                args = new String[]{"", ""}; break;
        }
        return args;
    }


}
