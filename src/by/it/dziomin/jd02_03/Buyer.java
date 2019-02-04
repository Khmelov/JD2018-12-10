package by.it.dziomin.jd02_03;

import java.util.ArrayList;
import java.util.List;

import static by.it.dziomin.jd02_03.Constants.*;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private final Object monitor = new Object();
    private String name;
    private boolean pensioner;
    private IMarket market;
    private Basket basket;

    Buyer(String name, boolean pensioner, IMarket market) {
        super(name);
        this.name = name;
        this.pensioner = pensioner;
        this.market = market;
        System.out.println(name + " is created");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        goSalesArea();
        List<Good> goods = chooseGoods();
        putGoodsToBasket(goods);
        outSalesArea();
        goToQueue();
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                System.out.println(name + "Ожидание прервано");
            }
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        if (pensioner) {
            System.out.println(name + " enter to Market. He is a pensioner");
        } else {
            System.out.println(name + " enter to Market.");
        }
    }

    @Override
    public void takeBasket() {
        this.basket = market.getBasket();

        long timeout = sleeping(Util.getRandom(100, 200));
        System.out.println(name + " took the basket " + timeout / 1000.0 + " seconds");
    }

    private void goSalesArea() {
        market.goSalesArea();
        System.out.println(name + " go to sales area");
    }

    @Override
    public List<Good> chooseGoods() {

        List<String> goodNames = Util.generateChoseGoods(market.getGoodsNames());

        List<Good> choseGoods = new ArrayList<>();
        goodNames.forEach(name -> choseGoods.add(market.getGood(name)));

        long timeout = sleeping(Util.getRandom(500, 2000));
        System.out.println(name + " chooses goods " + timeout / 1000.0 + " seconds");
        return choseGoods;
    }

    @Override
    public void putGoodsToBasket(List<Good> goods) {
        goods.forEach(good -> basket.addGood(good));

        long timeout = sleeping(Util.getRandom(100, 200));
        System.out.println(name + " put all goods in basket " + basket.toString() + ", " + timeout / 1000.0 + " seconds");
    }

    private void outSalesArea() {
        market.outSalesArea();
        System.out.println(name + " go out from sales area");
    }

    private void goToQueue() {
        market.addBuyer(this);
        System.out.println(name + " enter to Queue.");
    }

    @Override
    public void goOut() {
        market.returnBasket(basket);
        market.removeBuyer(this);
        System.out.println(name + " go out from market");
    }


    private long sleeping(long millis) {
        long timeToSleep = pensioner ? (long) (millis * COEFFICIENT_FOR_PENSIONER) : millis;
        Util.sleep(timeToSleep);
        return timeToSleep;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public Object getMonitor() {
        return monitor;
    }

    public Basket getBasket() {
        return basket;
    }
}
