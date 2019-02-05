package by.it.skosirskiy.jd02_05_1;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        System.out.println(manager.getString("str1"));
        manager.changeResource(new Locale("BE", "BY"));
        System.out.println(manager.getString("str1"));
    }

}
