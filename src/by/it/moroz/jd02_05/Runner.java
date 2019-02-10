package by.it.moroz.jd02_05;

import by.it.moroz.jd02_05.strings.Date;
import by.it.moroz.jd02_05.strings.Message;
import by.it.moroz.jd02_05.strings.User;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        String command;
        printInfo(resMan);
        while (!(command = scanner.nextLine()).equalsIgnoreCase("end")) {
            if (command.equalsIgnoreCase("ru")) {
                resMan.setLocale("ru", "RU");
                printInfo(resMan);
            }
            if (command.equalsIgnoreCase("be")) {
                resMan.setLocale("be", "BY");
                printInfo(resMan);
            }
            if (command.equalsIgnoreCase("en")) {
                resMan.setLocale(Locale.getDefault());
                printInfo(resMan);
            }
        }
    }

    private static void printInfo(ResMan resMan) {
        System.out.println(resMan.getMessage(Message.WELCOME));
        System.out.println(resMan.getMessage(Message.QUESTION));
        System.out.println(resMan.getMessage(User.NAME));
        System.out.println(resMan.getDate(Date.DATE));
    }

}