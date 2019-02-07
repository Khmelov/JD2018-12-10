package by.it.subach.jd02_02;

import by.it.naron.jd01_08.taskTaksopark.Main;

import java.util.ArrayList;
import java.util.List;

class Runner {
    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Market is opened");

        int number = 0;
        for (int i = 1; i <=5; i++) {
            Cashier cashier = new Cashier(i);
            cashier.start();
        }

//        MainCashier boss = new MainCashier();
//        boss.start();
//        Util.sleep(1000);

        while (Dispatcher.marketOpen()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++) {
                if (Dispatcher.marketOpen()) {
                    Buyer buyer = new Buyer(++number);
                    threads.add(buyer);
                    buyer.start();
                }
            }

            Util.sleep(1000 / Dispatcher.K_SPEED);
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

}
