package by.it.titkovskaya.jd02_02_2.jd02_02;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    protected static boolean pensioner = false;
    static HashMap<Buyer, Double> buyerTotalSum = new HashMap<>();
    boolean iWait;

    Object getMonitor() {
        return this;
    }

    public Buyer(int number) {
        super("Buyer №" + number);
        if (Util.getRandom(1, 4) == 1) {
            pensioner = true;
            this.setName("Buyer №" + number + " (pensioner)");
            Dispatcher.newPensioner();
        }
        Dispatcher.newBuyer();
    }

    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        System.out.flush();
        Dispatcher.buyerComplete();
    }

    @Override
    public void enterToMarket() {
        System.out.printf(" %-48s   %-22s   %-22s   %-22s\n", this + " entered the market"
                , Runner.time + " timeIn", Dispatcher.getCounterBuyerInShop() + " buyersInShop", "");
    }

    @Override
    public void takeBasket() {
        int timeout = Util.getRandom(100, 200);
        timeout = pensioner ? (timeout * 3 / 2) : timeout;
        Util.sleep(timeout);
        System.out.printf(" %-48s   %-22s   %-22s   %-22s\n", this + " took a basket", "", "", "");
        Dispatcher.totalTimeSpent += (double) timeout / 1000;
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(500, 2000);
        timeout = pensioner ? (timeout * 3 / 2) : timeout;
        Util.sleep(timeout);
        System.out.printf(" %-48s   %-22s   %-22s   %-22s\n", this + " chose goods ", "", "", "");
        Dispatcher.totalTimeSpent += (double) timeout / 1000;
    }

    @Override
    public void putGoodsToBasket() {
        StringBuilder sb = new StringBuilder();
        int count = Util.getRandom(1, 4);
        double total = 0;
        for (int i = 0; i < count; i++) {
            int timeout = Util.getRandom(100, 200);
            timeout = pensioner ? (timeout * 3 / 2) : timeout;
            Util.sleep(timeout);
            synchronized (Dispatcher.TIME_MON) {
                Dispatcher.totalTimeSpent += (double) timeout / 1000;
            }
            String[] inBasket = Goods.entries.toArray()[Util.getRandom(0, Goods.entries.size() - 1)]
                    .toString().split("=");
            System.out.printf(" %-48s   %-22s   %-22s   %-22s\n"
                    , this + " put to the basket " + inBasket[0] + " " + inBasket[1] + "$", "", "", "");
            sb.append(inBasket[0]).append(" ").append(inBasket[1]).append("$").append(";");
            total += Double.parseDouble(inBasket[1]);
            synchronized (Dispatcher.GOODS_MON) {
                Dispatcher.totalGoodsCounter++;
            }
        }
        buyerTotalSum.put(this, total);
        Basket.putToBasket(this, sb.toString());
    }

    @Override
    public void goToQueue() {
        System.out.printf(" %-48s   %-22s   %-22s   %-22s\n", this + " went to the queue", "", "", "");
        synchronized (this) {
            DequeBuyer.add(this, pensioner);
            iWait = true;
            while (iWait)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.printf(" %-48s   %-22s   %-22s   %-22s\n", this + " went out from the market"
                , Runner.time + " timeOut", Dispatcher.getCounterBuyerInShop() + " buyersInShop", "");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
