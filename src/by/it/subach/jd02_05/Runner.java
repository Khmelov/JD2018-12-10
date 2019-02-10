package by.it.subach.jd02_05;


import by.it.subach.jd02_05.strings.Message;
import by.it.subach.jd02_05.strings.User;

import java.util.Scanner;


public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String country = "EN";
        ResMan resMan = ResMan.INSTANCE;

        while (true) {
            String input = scanner.nextLine();
            try {
                if (input.equalsIgnoreCase("end")) break;
                else if (input.equalsIgnoreCase("ru")) country = "RU";
                else if (input.equalsIgnoreCase("en")) country = "US";
                else if (input.equalsIgnoreCase("be")) country = "BY";
                else throw new Exception();
                resMan.setLocale(input, country);
                System.out.println(resMan.get(Message.WELCOME));
                System.out.println(resMan.get(Message.QUESTION));
                System.out.println(resMan.get(User.NAME));
                System.out.println(resMan.getDate(input));

            }catch (Exception e){
                System.out.println("Что-то непонятное...");
            }


        }

    }

}
