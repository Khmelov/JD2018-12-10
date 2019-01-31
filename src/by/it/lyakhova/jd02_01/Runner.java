package by.it.lyakhova.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {
        Goods goods = new Goods();
        goods.setGoods();
        System.out.println("Market opened");
        int number = 0;
        boolean pensioneer;

        for (int time = 1; time <= 120; time++) {
            System.out.println(time + " second");
            int count = Util.setMaxPeople(time);
            System.out.println(count + "count");
            for (int i = 0; i < count; i++) {
                pensioneer =  (number % 4 == 0);
                Buyer buyer = new Buyer(++number, pensioneer);
                buyers.add(buyer);
                Dispatcher.counterBuyer++;
                buyer.start();
            }

            System.out.println(Dispatcher.counterBuyer);
            Util.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //while (Dispatcher.counterBuyer > 0){ Util.sleep(1);}

        System.out.println("Market closed");
    }
}
