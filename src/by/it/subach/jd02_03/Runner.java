package by.it.subach.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        //for (int k = 0; k < 1000; k++) {
        System.out.println("Market opened");
        int number = 0;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            executor.execute(cashier);
        }

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
        executor.shutdown();

        while (!executor.isTerminated())        Util.sleep(1);
        System.out.println("Market closed");

        // }
    }
}
