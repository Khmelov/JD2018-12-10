package by.it.moroz.jd02_02;

public class Market {

    public static void main(String[] args) {

        System.out.println("Market opened");
        GoodsInMarket.checkTheGoods(GoodsInMarket.goods);
        int numBuyer = 0;
        while (Util.marketOpened()) {
            for (int sec = 1; sec <= 60; sec++) {
                if (DequeBuyers.getCountAllBuyer() > Util.getCountCashiers() * 5) {
                    Thread cashier = new Thread(new Cashier(++Util.numCashiers));
                    Buyer.threads.add(cashier);
                    cashier.start();
                }
                if (sec < 30) {
                    if (Util.getCounterBuyerInMarket() <= sec + 10) {
                        int count = Util.getRandom(0, 2);
                        for (int j = 0; j < count; j++)
                            getNewBuyer(++numBuyer);
                    }
                } else {
                    if (Util.getCounterBuyerInMarket() <= 40 + (30 - sec)) {
                        int count = Util.getRandom(0, 2);
                        for (int j = 0; j < count; j++)
                            getNewBuyer(++numBuyer);
                    }
                }
                Util.sleep(1000);
            }
        }
        for (Thread thread : Buyer.threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }

    private static void getNewBuyer(int numBuyer) {
        if (Util.marketOpened()) {
            Buyer buyer = new Buyer(++numBuyer);
            if (numBuyer % 4 == 0)
                buyer.setPensioner(true);
            else buyer.setPensioner(false);
            buyer.start();
        }
    }
}
