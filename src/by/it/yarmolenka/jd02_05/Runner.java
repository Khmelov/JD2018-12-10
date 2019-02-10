package by.it.yarmolenka.jd02_05;

import by.it.yarmolenka.MathCalc.GetPath;
import by.it.yarmolenka.jd02_05.strings.*;

import java.io.*;
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
        createCommandsFile();
    }

    private static void createCommandsFile() {
        String path = GetPath.getPath(Runner.class);
        File f = new File(path);
        File[] files = f.listFiles();
        if (files != null)
            try (PrintWriter writer = new PrintWriter(new FileWriter(path + "commands.txt"))) {
                for (File file : files) {
                    if (file.getName().contains(".txt")) {
                        String name = file.getName().replace(".txt", ".properties");
                        writer.printf("native2ascii -encoding utf-8 %s %s\n", file.getName(), name);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private static void output(ResMan resMan, DateFormat df, Date date) {
        System.out.println(df.format(date));
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.NAME));
    }
}
