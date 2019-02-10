package by.it.moroz.jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    Object getMonitor() {
        return this;
    }

    Buyer(int num) {
        super("Buyer №" + num);
        Util.newBuyer();
    }

    static List<Thread> threads = new ArrayList<>();

    private boolean pensioner;
    private Basket basket = new Basket();

    void setPensioner(boolean value) {
        this.pensioner = value;
    }

    @Override
    public void run() {
        threads.add(this);
        enterToMarket();
        takeBasket();
        int count = Util.getRandom(1, 4);
        for (int i = 0; i < count; i++) {
            String good = GoodsInMarket.choseRandomGood(GoodsInMarket.goods);
            chooseGoods(good);
            putGoodsToBasket(good);
        }
        goToQueue();
        goOut();
        System.out.flush();
        Util.buyerComplete();
    }

    void takeCheck(String whichCashier) {
        int sum = 0;
        System.out.println(whichCashier + "*****************************");
        for (Map.Entry<String, Integer> pair : basket.basket.entrySet()) {
            System.out.printf(whichCashier + "%-15s ------- %5d\n", pair.getKey(), pair.getValue());
            sum += pair.getValue();
        }
        Util.moreProceeds(sum);
        System.out.println(whichCashier + "=============================");
        System.out.printf(whichCashier + "%-15s ------- %5d\n", "Total", sum);
        System.out.println(whichCashier + "=============================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" +
                "Buyers in queue: " + DequeBuyers.getCountAllBuyer() + "\t" +
                "Market's proceeds: " + Util.getProceeds());
    }

    @Override
    public void enterToMarket() {
        if (pensioner)
            Util.sleep(30);
        else Util.sleep(15);
        synchronized (Util.PRINTER) {
            System.out.println(this + " enter to Market");
        }
    }

    @Override
    public void chooseGoods(String good) {
        int time = Util.getRandom(7500, 30000);
        if (pensioner)
            Util.sleep((int) (time * 1.5));
        else
            Util.sleep(time);
        synchronized (Util.PRINTER) {
            System.out.println(this + " chose " + good);
        }
    }

    @Override
    public void goToQueue() {
        synchronized (Util.PRINTER) {
            System.out.println(this + " go to queue");
        }
        if (pensioner)
            DequeBuyers.add(DequeBuyers.pensionerDeque, this);
        else
            DequeBuyers.add(DequeBuyers.buyerDeque, this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        if (pensioner)
            Util.sleep(30);
        else Util.sleep(15);
        synchronized (Util.PRINTER) {
            System.out.println(this + " go out from Market");
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        int time = Util.getRandom(1500, 3000);
        if (pensioner)
            Util.sleep((int) (time * 1.5));
        else
            Util.sleep(time);
        synchronized (Util.PRINTER) {
            System.out.println(this + " took the basket");
        }
    }

    @Override
    public void putGoodsToBasket(String good) {
        int time = Util.getRandom(1500, 3000);
        if (!pensioner)
            Util.sleep(time);
        else
            Util.sleep((int) (time * 1.5));
        synchronized (Util.PRINTER) {
            System.out.println(this + " put " + good + " to basket");
        }
        basket.putGoodInBasket(basket.basket, good, GoodsInMarket.getPrice(GoodsInMarket.goods, good));
    }
}
