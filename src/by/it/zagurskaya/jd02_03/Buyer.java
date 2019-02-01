package by.it.zagurskaya.jd02_03;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private static final boolean[] BUYER_PLACES = new boolean[20];
    private static final Semaphore SEMAPHORE = new Semaphore(20, true);
    private static volatile AtomicInteger parkingNumber = new AtomicInteger(0);

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
        chooseGoods();
        goToQueue();
        goOut();
        System.out.flush();
        Dispatcher.buyerComplete();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to Market");
    }

    @Override
    public void chooseGoods()  {
                try {
            SEMAPHORE.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("симофор начал");
        synchronized (BUYER_PLACES) {
            for (int i = 0; i < 20; i++) {
                if (!BUYER_PLACES[i]) {//Если место свободно
                    BUYER_PLACES[i] = true;  //занимаем его
                    parkingNumber.set( i );
                    takeBucket();
                    int timeout = Util.getRandom(500, 2000);
                    System.out.println(this + " chose goods " + timeout + " milliseconds");

                    while (timeout > 0) {
                        int pickDelayTime = (int) (Util.getRandom(100, 200) * speedRate);
                        Util.sleep(pickDelayTime);
                        putGoodsToBucket();
                        timeout = timeout - pickDelayTime;
                    }
                    System.out.println(this + " chose goods");
                    break;
                }
            }
        }

    }

    @Override
    public void goToQueue() {

        synchronized (BUYER_PLACES) {
            BUYER_PLACES[parkingNumber.get()] = false;//Освобождаем место
        }
        SEMAPHORE.release();
        System.out.println("симофор отпустил");
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
