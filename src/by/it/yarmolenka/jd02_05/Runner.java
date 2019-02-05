package by.it.yarmolenka.jd02_05;

import by.it.yarmolenka.jd02_05.strings.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class Runner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ResMan resMan = ResMan.INSTANCE;
        DateFormat df;
        System.out.println(Systems.ENTERANCE);
        while (true) {
            String language = reader.readLine();
            if (language.equals(Language.RU)) {
                resMan.setLocale(Language.RU, Country.RU);
                df = DateFormat.getDateInstance(
                        DateFormat.LONG, new Locale(Language.RU, Country.RU));
                break;
            }
            if (language.equals(Language.EN)) {
                resMan.setLocale(Language.EN, Country.US);
                df = DateFormat.getDateInstance(
                        DateFormat.LONG, Locale.US);
                break;
            }
            if (language.equals(Language.BE)) {
                resMan.setLocale(Language.BE, Country.BY);
                df = DateFormat.getDateInstance(
                        DateFormat.LONG, new Locale(Language.BE, Country.BY));
                break;
            }
            System.err.println(Systems.INCORRECT_INPUT);
        }
        Date date = new Date(System.currentTimeMillis());
        output(resMan, df, date);
    }

    private static void output(ResMan resMan, DateFormat df, Date date) {
        System.out.println(df.format(date));
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.NAME));
    }
}
