package by.it.titkovskaya.jd02_05;

import by.it.titkovskaya.jd02_05.strings.Message;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    public static void main(String[] args) {
        String messages = "by.it.titkovskaya.jd02_05.messages";
        Locale locale = new Locale("be","BY");
        ResourceBundle rb = ResourceBundle.getBundle(messages,locale);
        String test = rb.getString(Message.WELCOME);
        System.out.println(test);
    }
}
