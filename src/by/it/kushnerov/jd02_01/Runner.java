package by.it.kushnerov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {
        Goods.setGoods();
            System.out.println("Market opened");
            int number = 0;
            for (int time = 1; time <= 120; time++) {
                int count = Util.getRandom(2);
                for (int i = 0; i < count; i++) {
                    Buyer buyer = new Buyer(++number);
                    buyers.add(buyer);
                    Dispatcher.counterBuyer++;
                    buyer.start();
                }
                Util.sleep(1000);
            }
            while (Dispatcher.counterBuyer > 0)
                Util.sleep(1);
            System.out.println("Market closed");
    }
}
