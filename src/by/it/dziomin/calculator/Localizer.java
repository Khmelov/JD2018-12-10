package by.it.dziomin.calculator;

import by.it.dziomin.calculator.logs.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localizer implements Localization {

    private final static String sourceMessages = "by.it.dziomin.calculator.messages";
    static boolean changeLanguage = false;
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle bundle = ResourceBundle.getBundle(sourceMessages, locale);

    public static ResourceBundle getBundle() {
        return bundle;
    }

    static void setBundle(Locale locale) {
        Localizer.bundle = ResourceBundle.getBundle(sourceMessages, locale);
    }

    static Locale getLocale() {
        return locale;
    }

    static void setLocale(String str) {
        switch (str) {
            case "en":
                locale = new Locale("en", "US");
                changeLanguage = true;
                break;
            case "be":
                locale = new Locale("be", "BY");
                changeLanguage = true;
                break;
            case "ru":
                locale = new Locale("ru", "RU");
                changeLanguage = true;
                break;
        }
    }

    static void displayNotice() {

        String message = Localizer.getBundle().getString(Localization.MESSAGES_LANGUAGE);
        System.out.println(message);
        Logger logger = Logger.getInstance();
        logger.printToFile(message);

    }
}
