package by.it.moroz.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//мой класс с датой(создавался, чтобы посмотреть, как она выводится)
//в самой программе не участвует
public class MyDate {

    public static void main(String[] args) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
        Date d = new Date();
        System.out.println(df.format(d));
        df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("be", "BY"));
        System.out.println(df.format(d));
        df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru", "RU"));
        System.out.println(df.format(d));
    }
}
