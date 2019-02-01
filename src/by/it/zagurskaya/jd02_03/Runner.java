package by.it.zagurskaya.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Runner {

//    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Market opened");

        final boolean[] BUYER_PLACES = new boolean[20];
        final Semaphore SEMAPHORE = new Semaphore(20, true);

//        ExecutorService cashiers = Executors.newCachedThreadPool();
        ExecutorService cashiers = Executors.newFixedThreadPool(5);
        ExecutorService buyers = Executors.newFixedThreadPool(100);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier();
            cashiers.execute(cashier);
            Util.sleep(1000);
        }
//
//        Cashier cashier = new Cashier(); //запустить через executor
//        Thread cashierThread = new Thread(cashier);
//        cashier.setThread(cashierThread);
//        cashierThread.start();

        int number = 0;
        System.out.println("Dispatcher.marketOpened()" + Dispatcher.marketOpened());
        while (Dispatcher.marketOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++)
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(++number);
//                    threads.add(buyer);
////                    buyer.start();
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

        buyers.shutdown();
        cashiers.shutdown();


//        for (Thread thread : threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        for (Cashier c : Cashier.getQ()) {
//            try {
//                c.getThread().join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println("Market closed");
        }
}
