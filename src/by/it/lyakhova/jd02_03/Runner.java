package by.it.lyakhova.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Runner {

    public static void main(String[] args) {
        Goods goods = new Goods();
        goods.setGoods();
        System.out.println("Market opened");
        int number = 0;
        int time = 1;
        boolean pensioneer;

        Semaphore semaphoreBuyers = new Semaphore(20);

        ExecutorService cashiers = Executors.newFixedThreadPool(5);
        ExecutorService buyers = Executors.newFixedThreadPool(100);

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Regulator.cashiers.add(cashier);
            cashiers.execute(cashier);

        }

        Regulator regulator = new Regulator();
        regulator.start();


        while (Dispatcher.marketOpened()) {

            int count = Util.setMaxPeople(time);

            for (int i = 0; i < count; i++)
                if (Dispatcher.marketOpened()){
                    try {
                        semaphoreBuyers.acquire();
                        pensioneer = (number % 4 == 0);
                        Buyer buyer = new Buyer(++number, pensioneer);
                        buyers.execute(buyer);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        semaphoreBuyers.release();
                    }
            }

            Util.sleep(1000);
            ++time;
                                             //System.out.println(time + " sec");
        }

        buyers.shutdown();
        cashiers.shutdown();

        while (!buyers.isTerminated()){ Util.sleep(1);}
        while (!cashiers.isTerminated()){ Util.sleep(1);}

        System.out.println("Market closed");
    }
}
