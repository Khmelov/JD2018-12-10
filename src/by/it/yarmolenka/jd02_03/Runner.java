package by.it.yarmolenka.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    private static Deque<Integer> numberOfBuyers = new LinkedList<>();    //для статистики
    private static Deque<Integer> enteredBuyers = new LinkedList<>();     //для статистики
    private static Deque<Integer> queueSize = new LinkedList<>();         //для статистики
    private static Deque<Integer> cashiersCount = new LinkedList<>();     //для статистики


    public static void main(String[] args) {
        try {
            Dispatcher.semaphoreConsole.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Market is open");
        Dispatcher.semaphoreConsole.release();
        ExecutorService cashiers = Executors.newFixedThreadPool(5);
        ExecutorService buyers = Executors.newFixedThreadPool(100);
        cashiers.execute(new Cashier(Dispatcher.cashiersNumber.getAndIncrement()));

        for (int i = 0; i < 300; i++) {
            if (Dispatcher.planComplete()) break;
            workingMarket(cashiers, buyers, i);
            Utils.sleep(1000);
        }

        buyers.shutdown();
        cashiers.shutdown();
        while (!buyers.isTerminated()) Utils.sleep(1);
        while (!cashiers.isTerminated()) Thread.yield();
        try {
            Dispatcher.semaphoreConsole.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Market is closed");
        Dispatcher.semaphoreConsole.release();
        marketStatistics();      //вывод статистики
    }

    private static void workingMarket(ExecutorService cashiers, ExecutorService buyers, int i) {
        numberOfBuyers.offerFirst(Dispatcher.buyersCount.get());   //для статистики
        cashiersCount.offerFirst(Dispatcher.cashiersCount.get());   //для статистики
        queueSize.offerFirst(BuyerQueue.queue.size());             //для статистики
        int num = Dispatcher.marketIsClosed() ? 0 : getNum(i);      //количество запускаемых покупателей
        enteredBuyers.offerFirst(num);        //для статистики
        for (int j = 0; j < num; j++) {       //запускаем покупателей
            if (Dispatcher.marketIsClosed()) break;
            buyers.execute(new Buyer(Dispatcher.buyersNumber.getAndIncrement()));
        }
        if (BuyerQueue.queue.size() > Dispatcher.cashiersCount.get() * 5 &&   //если нехватает открываем кассы
                Dispatcher.cashiersCount.get() < 5)
            cashiers.execute(new Cashier(Dispatcher.cashiersNumber.getAndIncrement()));
    }

    private static int getNum(int i) {
        int sec = i % 60;
        int num = -1;
        if (sec < 30) {
            if (Dispatcher.buyersCount.get() < 10 + sec) {
                num = (sec + 10 - Dispatcher.buyersCount.get()) > 2 ? 2 :
                        (Utils.getRandom(sec + 10 - Dispatcher.buyersCount.get(), 2));
            }
        } else {
            if (Dispatcher.buyersCount.get() > 40 + 30 - sec)
                num = 0;
        }
        if (num == -1) num = Utils.getRandom(0, 2);
        return num;
    }

    private static void marketStatistics() {
        System.out.println("Buyers in Market Statistics:");
        System.out.println("------------------------------------------------------------------" +
                "----------------------------------------------------------------------------");
        int n = numberOfBuyers.size();
        System.out.print("entry №  | number of buyers in the market | entered buyers |" +
                " total number of buyers (in the market + entered) | queue size | cashier's count |\n");
        for (int i = 1; i <= n; i++) {
            int n1, n2;
            Integer nu1 = numberOfBuyers.pollLast();
            Integer nu2 = enteredBuyers.pollLast();
            Integer nu3 = queueSize.pollLast();
            Integer nu4 = cashiersCount.pollLast();
            if (nu1 != null) n1 = nu1;
            else throw new NullPointerException();
            if (nu2 != null) n2 = nu2;
            else throw new NullPointerException();
            System.out.printf("%6d   |%28d    |%12d    |%46d    |%6d      |%10d       |\n",
                    i, nu1, nu2, n1 + n2, nu3, nu4);
        }
    }
}
