package by.it.dziomin.jd02_01;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.it.dziomin.jd02_01.Constants.MARKET_WORK_TIME;

public class Market extends Thread implements IMarket {

    private Map<String, Good> marketGoods;

    private Set<Buyer> buyers = new HashSet<>();

    private Lock lock = new ReentrantLock();

    private AtomicBoolean isOpened = new AtomicBoolean(false);

    private AtomicInteger buyerCount = new AtomicInteger();

    Market(String name) {
        super(name);
        marketGoods = initMarketGoods();
    }

    @Override
    public void run() {
        open();
        Util.sleep(MARKET_WORK_TIME);
        close();
    }

    private void open() {
        System.out.println("Market is opened: " + LocalTime.now());
        isOpened.set(true);
    }

    private void close() {
        isOpened.set(false);
        System.out.println("Enter is closed: " + LocalTime.now());
        while (!buyers.isEmpty()) {
            Util.sleep(100);
        }

        System.out.println("Market is closed: " + LocalTime.now());
    }

    @Override
    public Basket getBasket() {
        return new Basket();
    }

    @Override
    public void addBuyer(Buyer buyer) {
        try {
            lock.lock();
            buyers.add(buyer);
            buyerCount.incrementAndGet();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void removeBuyer(Buyer buyer) {
        try {
            lock.lock();
            buyers.remove(buyer);
            buyerCount.decrementAndGet();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Set<String> getGoodsNames() {
        return marketGoods.keySet();
    }

    @Override
    public Good getGood(String name) {
        return marketGoods.get(name);
    }

    @Override
    public boolean isOpened() {
        return isOpened.get();
    }

    @Override
    public int getBuyerCount() {
        return buyerCount.get();
    }

    private Map<String, Good> initMarketGoods() {
        return Stream.of(new Good("Хлеб", 1.28), new Good("Молоко", 1.02), new Good("Сахар", 2.20),
                new Good("Конфеты", 5.50), new Good("Чай", 3.59))
                .collect(Collectors.toMap(Good::getName, good -> good));
    }
}
