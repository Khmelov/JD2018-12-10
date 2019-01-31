package by.it.moroz.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Market opened");
        GoodsInMarket.checkTheGoods(GoodsInMarket.goods);
        int num = 0;
        for (int i = 1; i <=2 ; i++) {
            Thread cashier = new Thread(new Cashier(i));
            threads.add(cashier);
            cashier.start();
        }
        for (int time = 1; Util.marketOpened(); time++) {
            int count = Util.getRandom(0, 2);
            if (time < 30) {
                if(time<15){
                    for (int j = 0; j < 2; j++) {
                        newBuyer(++num);
                    }
                } else if (Util.getCounterBuyerInMarket()<=time+10) {
                    for (int j = 0; j < count; j++) {
                        newBuyer(++num);
                    }
                }
            } else if (time < 60) {
                if (Util.getCounterBuyerInMarket() <= 40 + (30 - time)) {
                    for (int j = 0; j < count; j++) {
                        newBuyer(++num);
                    }
                }
            } else if (time < 90) {
                if(time<75){
                    for (int j = 0; j < 2; j++) {
                        newBuyer(++num);
                    }
                } else if (Util.getCounterBuyerInMarket() <= time - 50) {
                    for (int j = 0; j < count; j++) {
                        newBuyer(++num);
                    }
                }
            } else {
                if (Util.getCounterBuyerInMarket() <=40+(90-time)){
                    for (int j = 0; j < count; j++) {
                        newBuyer(++num);
                    }
                }
            }
            System.out.println(time + " " + Util.getCounterBuyerInMarket());
            Util.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
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
        threads.add(buyer);
        Util.newBuyer();
        buyer.start();
    }
}
