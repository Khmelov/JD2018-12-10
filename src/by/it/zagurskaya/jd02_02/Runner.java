package by.it.zagurskaya.jd02_02;


import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Market opened");

        Cashier cashier = new Cashier();
        Thread cashierThread = new Thread(cashier);
        cashier.setThread(cashierThread);
        cashierThread.start();

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

        for (Cashier c : Cashier.getQ()) {
            try {
                c.getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market closed");
    }
}
