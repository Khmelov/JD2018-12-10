package by.it.moroz.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    public static void main(String[] args) {

        System.out.println("Market opened");
        GoodsInMarket.checkTheGoods(GoodsInMarket.goods); //проверяем наличие товара в магазине
        int numBuyer = 0;
        int numCashier = 0;
        ExecutorService cashiers = Executors.newFixedThreadPool(5);
        ExecutorService buyers = Executors.newFixedThreadPool(100);
        while (Util.marketOpened()) {
            for (int sec = 1; sec <= 60; sec++) {
                if(DequeBuyers.getCountAllBuyer() > Util.getCountCashiers() * 5)
                    cashiers.execute(new Cashier(++numCashier));
                if (sec < 30) {
                    if (Util.getCounterBuyerInMarket() <= sec + 10) {
                        int count = Util.getRandom(0, 2);
                        for (int j = 0; j < count; j++)
                            getNewBuyer(++numBuyer, buyers); //создаем нового покупателя
                    }
                } else {
                    if (Util.getCounterBuyerInMarket() <= 40 + (30 - sec)) {
                        int count = Util.getRandom(0, 2);
                        for (int j = 0; j < count; j++)
                            getNewBuyer(++numBuyer, buyers);
                    }
                }
                Util.sleep(1000);
            }
        }
        cashiers.shutdown();
        buyers.shutdown();
        while (!cashiers.isTerminated() || !buyers.isTerminated()) Util.sleep(1);
        System.out.println("Market closed");
    }

    //метод по созданию нового покупателя
    private static void getNewBuyer(int numBuyer, ExecutorService buyers) {
        if (Util.marketOpened()) {
            Buyer buyer = new Buyer(numBuyer);
            if (numBuyer % 4 == 0)
                buyer.setPensioner(true);
            else buyer.setPensioner(false);
            buyers.execute(buyer);
        }
    }
}
