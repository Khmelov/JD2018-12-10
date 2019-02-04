package by.it.zagurskaya.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static ExecutorService CASHIERS = Executors.newFixedThreadPool(50);

    public static void main(String[] args) {
        System.out.println("Market opened");

        ExecutorService buyers = Executors.newFixedThreadPool(100);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier();
            CASHIERS.execute(cashier);
            Util.sleep(1000);
        }

        int number = 0;
        System.out.println("Dispatcher.marketOpened()" + Dispatcher.marketOpened());
        while (Dispatcher.marketOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(++number);
                    buyers.execute(buyer);
                }
            }
            Util.sleep(1000);
        }

        buyers.shutdown();
        while (!buyers.isTerminated())
            Util.sleep(100);

        CASHIERS.shutdown();
        while (!CASHIERS.isTerminated())
            Thread.yield();

        System.out.println("Market closed");
    }
}
