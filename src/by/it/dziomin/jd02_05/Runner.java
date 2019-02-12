package by.it.dziomin.jd02_05;


import java.text.DateFormat;
import java.util.*;

public class Runner {

    public static void main(String[] args) {

        Locale locale = Locale.getDefault();
        Date date = new Date();

        Scanner sc = new Scanner(System.in);
        String str = "";

        while (!str.equals("end")) {

            if (args.length > 1) {
                locale = setLocale(args[0], args[1]);
                printProperties(locale, date);
                args = new String[0];
            }

            str = sc.nextLine();
            if (str.equals("en")) {
                locale = setLocale("en", "US");
                printProperties(locale, date);
            }
            if (str.equals("be")) {
                locale = setLocale("be", "BY");
                printProperties(locale, date);
            }
            if (str.equals("ru")) {
                locale = setLocale("ru", "RU");
                printProperties(locale, date);
            }

        }

    }

    private static void printProperties(Locale locale, Date date) {
        ResourceBundle bundleBY = ResourceBundle.getBundle("by.it.dziomin.jd02_05.mes", locale);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(df.format(date.getTime()));


        System.out.println(bundleBY.getString(Keys.WELCOME));
        System.out.println(bundleBY.getString(Keys.QUESTION));
        System.out.println(bundleBY.getString(Keys.NAME));
    }

    private static Locale setLocale(String s1, String s2) {
        Locale loc;
        loc = new Locale(s1, s2);
        return loc;
    }


}
