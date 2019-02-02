package by.it.skosirskiy.Test;

import java.util.ArrayList;
import java.util.List;

public class Runner {
     static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        //for (int k = 0; k < 1000; k++) {

        System.out.println("Market opened");
        Goods.getPriceList();
        Thread manager = new Thread(new Manager());
        Runner.threads.add(manager);
        manager.start();

        int number = 0;
        while (Dispatcher.marketOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++)
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(++number);
                    threads.add(buyer);
                    buyer.start();
                }
            Util.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(
                Backet.cheсkHashMap);
        System.out.println("Market closed");
        }
}
