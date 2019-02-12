package by.it.lyakhova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        Goods goods = new Goods();
        goods.setGoods();
        System.out.println("Market opened");
        int number = 0;
        int time = 1;
        boolean pensioneer;

        /*for (int i = 1; i <= 5; i++) {
            Thread cashier = new Thread(new Cashier(i));
            threads.add(cashier);
            cashier.start();

        }*/

        Regulator regulator = new Regulator();
        threads.add(regulator);
        regulator.start();


        while (Dispatcher.marketOpened()) {

                                            //System.out.println(time + " second");
            int count = Util.setMaxPeople(time);
                                            //System.out.println(count + "count");
            for (int i = 0; i < count; i++)
                if (Dispatcher.marketOpened()){
                    pensioneer =  (number % 4 == 0);
                    Buyer buyer = new Buyer(++number, pensioneer);
                    threads.add(buyer);
                    buyer.start();
            }
                                             //System.out.println(Dispatcher.getCounterBuyerInShop() + " in shop SAXParser");
            Util.sleep(1000);
            ++time;
                                             //System.out.println(time + " sec");
        }

        /*for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        while (Dispatcher.getCounterBuyerInShop() > 0){ Util.sleep(1);}

        System.out.println("Market closed");
    }
}
