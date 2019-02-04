package by.it.zagurskaya.jd02_03;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private static final Semaphore SEMAPHORE = new Semaphore(20, true);

    Object getMonitor() {
        return this;
    }

    private Basket basket = new Basket();
    private boolean pensioner = Util.getRandom(3) == 0;
    private int goodLimit = Util.getRandom(1, 4);
    private double speedRate = pensioner ? (double) Util.getRandom(14, 16) / 10 : 1;

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            SEMAPHORE.acquire();
            chooseGoods();
            goToQueue();
            SEMAPHORE.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        goOut();
        System.out.flush();
        Dispatcher.buyerComplete();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to Market");
    }

    @Override
    public void chooseGoods() {
        takeBucket();
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this + " chose goods " + timeout + " milliseconds");

        while (timeout > 0) {
            int pickDelayTime = (int) (Util.getRandom(100, 200) * speedRate);
            Util.sleep(pickDelayTime);
            putGoodsToBucket();
            timeout = timeout - pickDelayTime;
        }

        Util.sleep(1000);
        System.out.println(this + " chose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to Queue");
        synchronized (this) { //избавиться от synchronized??????? сдесь опрвдан, сдесь есть смысл синхронайса
            DequeBuyer.add(this);
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "go out from Market");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBucket() {
        System.out.println(this + "took the basket");
    }

    @Override
    public void putGoodsToBucket() {
        if (basket.show().size() < goodLimit) {
            Map<String, Double> showcase = Showcase.getShowcase();
            int goodIndex = Util.getRandom(showcase.size() - 1);
            String goodName = getElementFromSetAtIndex(showcase.keySet(), goodIndex);

            Map<String, Double> pickGood = Showcase.getGoodByName(goodName);
            basket.put(pickGood);
            System.out.println(this + " chose good " + pickGood.toString());
        }
    }

    private String getElementFromSetAtIndex(Set<String> set, int index) {
//        Iterator<String> iterator = set.iterator();
//        for (int i = 0; i < index ; i++) {
//            iterator.next();
//        }
//        return iterator.next();
        return set.stream().skip(index).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public double getBill() {
        return basket.show().values().stream().mapToDouble(value -> value).sum();
    }
}
