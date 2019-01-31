package by.it.moroz.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Market opened");
        GoodsInMarket.checkTheGoods(GoodsInMarket.goods);
        int num = 0;
        for (int min = 1; min <= 2; min++) {
            for (int sec = 1; sec <= 60; sec++) {
                if (sec < 30) {
                    if (Util.counterBuyer <= sec + 10) {
                        int count = Util.getRandom(0, 2);
                        for (int j = 0; j < count; j++) {
                            newBuyer(++num);
                        }
                    }
                } else {
                    if (Util.counterBuyer <= 40 + (30 - sec)) {
                        int count = Util.getRandom(0, 2);
                        for (int j = 0; j < count; j++) {
                            newBuyer(++num);
                        }
                    }
                }
                Util.sleep(1000);
            }
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }

    private static void newBuyer(int num) {
        Buyer buyer = new Buyer(num);
        if (num % 4 == 0)
            buyer.setPensioner(true);
        else buyer.setPensioner(false);
        buyers.add(buyer);
        Util.counterBuyer++;
        buyer.start();
    }
}
