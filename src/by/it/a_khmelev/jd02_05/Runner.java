package by.it.a_khmelev.jd02_05;

import by.it.a_khmelev.jd02_05.strings.Message;
import by.it.a_khmelev.jd02_05.strings.User;


public class Runner {

    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        if (args.length == 2) {
            resMan.setLocale(args[0], args[1]);
        }
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.NAME));
    }

}
