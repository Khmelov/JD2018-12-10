package by.it.skosirskiy.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {


    public static void main(String[] args) {
        //for (int k = 0; k < 1000; k++) {
        System.out.println("Market opened");
        Goods.getPriceList();
        int number = 0;

        ExecutorService cashiers = Executors.newFixedThreadPool(2);
        ExecutorService buyers = Executors.newFixedThreadPool(100);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.execute(cashier);
        }

        while (Dispatcher.marketOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++)
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(++number);
                    buyers.execute(buyer);
                }
            Util.sleep(1000);
        }
        buyers.shutdown();
        cashiers.shutdown();
        while (!buyers.isTerminated())
            Util.sleep(1);
        while (!cashiers.isTerminated())
            Thread.yield();
        System.out.println("Market closed");
    }
}
