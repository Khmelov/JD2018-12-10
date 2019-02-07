package by.it.subach.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Runner {
    private static List<Buyer> buyers = new ArrayList<>();
    static int number = 0;


    public static synchronized void main(String[] args) {
        Util.fillPriceList(Util.priceList);
        System.out.println("Раскладываем товар по полкам");
        System.out.println(Util.priceList.toString());
        System.out.println("Market is opened");
//        int number = 0;
        for (int time = 0; time < 121; time++) {
            if (time > 0 && time % 10 == 0) {
                System.out.println("        " + Dispatcher.getCounterBuyer() + " покупателей на " + time + " сек.");
            }
            int count;
            if (time <= 30) {
                count = (time + 10) - Dispatcher.counterBuyer;
                addBuyers(count);
            }
            if (time > 30 && time <= 60) {
                count = 40 - (time - 30) - Dispatcher.counterBuyer;
                addBuyers(count);
            }

            if (time > 60 && time <= 90) {
                count = ((time + 10) - 60) - Dispatcher.counterBuyer;
                addBuyers(count);
            }
            if (time > 90 && time <= 120) {
                count = (40 - (time - 30 - 60)) - Dispatcher.counterBuyer;
                addBuyers(count);
            }

        }


        while (Dispatcher.counterBuyer > 0) {
            Util.sleep(1);
            Thread.yield();

        }

        System.out.println("Market closed");
        System.out.println("Всего покупателей: " + buyers.size());
        System.out.println("Пенсионеров приходило: " + Buyer.pens);
    }

    static void addBuyers(int count) {
        for (int i = 0; i < count; i++) {
            Buyer buyer = new Buyer(++number);
            buyers.add(buyer);
            buyer.start();
            Dispatcher.counterBuyer++;
        }
        Util.sleep(1000 / Dispatcher.K_SPEED);

    }

}
