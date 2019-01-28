package by.it.yarmolenka.jd02_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Runner {
    private static LinkedList<Integer> numberOfBuyers = new LinkedList<>();
    private static LinkedList<Integer> enteredBuyers = new LinkedList<>();
    private static List<Buyer> listOfBuyers = new ArrayList<>();
    private static int number = 1;

    public static void main(String[] args) {
        Goods.loadPriceList();
        workingMarket();
        marketStatistics();
    }

    private static void marketStatistics() {
        System.out.println("Buyers in Market Statistics:");
        System.out.printf("Total buyers: %d, retired buyers: %d\n", Dispatcher.totalBuyersCount, Dispatcher.totalRetiredCount);
        System.out.println("-------------------------------------------------------------------------------------");
        int n = numberOfBuyers.size();
        System.out.print("entry № | number of buyers in the market | entered buyers | total number of buyers (in the market + entered) |\n");
        for (int i = 1; i <= n; i++) {
            int n1, n2;
            Integer nu1 = numberOfBuyers.pollLast();
            Integer nu2 = enteredBuyers.pollLast();
            if (nu1 != null) n1 = nu1; else throw new NullPointerException();
            if (nu2 != null) n2 = nu2; else throw new NullPointerException();
            System.out.printf("%6d   |%28d    |%12d    |%46d    |\n", i, nu1, nu2, n1 + n2);
        }
    }

    private static void workingMarket() {
        int max_entries = 8;
        System.out.println("Market is open");
        for (int i = 1; i <= 120; i++) {
            enteringBuyers(max_entries, i);
        }
        for (Buyer buyer : listOfBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed");
    }

    private static void enteringBuyers(int max_entries, int i) {
        int sec = i % 60;
        int num = -1;
        if (sec <= 30) {
            if (Dispatcher.buyersCount < 10 + sec) {
                num = (sec + 10 - Dispatcher.buyersCount) > max_entries ? max_entries :
                        (Utils.getRandom(sec + 10 - Dispatcher.buyersCount, max_entries));
            }
        } else {
            if (Dispatcher.buyersCount > 40 + 30 - sec)
                num = 0;
        }
        if (num == -1) num = Utils.getRandom(0, max_entries);
        numberOfBuyers.offerFirst(Dispatcher.buyersCount);
        enteredBuyers.offerFirst(num);
        for (int j = 0; j < num; j++) {
            Buyer buyer = new Buyer(number++);
            listOfBuyers.add(buyer);
            buyer.start();
        }
        Utils.sleep(1000);
    }
}
