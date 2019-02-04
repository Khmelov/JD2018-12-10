package by.it.dziomin.jd02_02;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.it.dziomin.jd02_02.Constants.MARKET_WORK_TIME;
import static by.it.dziomin.jd02_02.Constants.MAX_CASHIER_COUNT;

public class Market extends Thread implements IMarket {

    private Map<String, Good> marketGoods;

    private Queue<Buyer> buyers = new ConcurrentLinkedQueue<>();

    private Queue<Buyer> pensioners = new ConcurrentLinkedQueue<>();

    private Lock lock = new ReentrantLock();

    private AtomicBoolean isOpened = new AtomicBoolean(false);

    private AtomicInteger buyerCount = new AtomicInteger();

    private List<Cashier> cashierList = new ArrayList<>();

    private AtomicInteger openedCashiers = new AtomicInteger();

    private Thread cashierDispatcher;

    private Thread statusDispatcher;

    private Double marketRevenue = 0d;

    Market(String name) {
        super(name);
        marketGoods = initMarketGoods();
        initDispatchCashier();
        initDispatchStatus();
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

    private void initDispatchCashier() {
        this.cashierDispatcher = new Thread(() -> {
            createCashiers();

            while (true) {
                synchronized (cashierDispatcher) {
                    try {
                        cashierDispatcher.wait();
                    } catch (InterruptedException e) {
                        for (Cashier cashier : cashierList) {
                            cashier.interrupt();
                        }
//                        System.out.println("Cashier dispather is finally closed");
                        break;
                    }
                }
                checkCashiersCount();
            }

        });
        cashierDispatcher.start();
    }

    private void initDispatchStatus() {
        this.statusDispatcher = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
//                    System.out.println("State dispatcher is finally closed");
                    break;
                }
                StringBuilder sb = new StringBuilder("MARKET STATE: |  ");
                for (Cashier cashier : cashierList) {
                    sb.append(cashier.isOpened()).append("\t|\t");
                }
                sb.append(buyerCount).append("\t|\t").append("%.2f  |\n");
                lock.lock();
                try {
                    System.out.printf(sb.toString(), marketRevenue);
                } finally {
                    lock.unlock();
                }
            }
        });
        statusDispatcher.start();
    }

    private void checkCashiersCount() {
        int n = (int) Math.ceil((double) buyerCount.get() / 5);
//        System.out.println("----------------- n = " + n);
        int diff = n - openedCashiers.get();
        if (diff > 0) {
            for (int i = 0; i < n && i < MAX_CASHIER_COUNT; i++) {
                Cashier cashier = cashierList.get(i);
                cashier.setOpened();
                synchronized (cashier) {
                    cashier.notify();
                }
            }
        } else if (diff < 0) {
            for (int i = n; i < cashierList.size(); i++) {
                Cashier cashier = cashierList.get(i);
                cashier.setClosed();
            }
        }
        openedCashiers.set(n > MAX_CASHIER_COUNT ? MAX_CASHIER_COUNT : n);
    }

    private void createCashiers() {
        for (int i = 0; i < MAX_CASHIER_COUNT;) {
            Cashier cashier = new Cashier("Cashier " + ++i, this);
            cashierList.add(cashier);
            System.out.println(cashier.getName() + " created");
            cashier.start();
        }
    }

    private void close() {
        isOpened.set(false);
        while (buyerCount.get() > 0) {
            Util.sleep(100);
        }

        cashierDispatcher.interrupt();
        statusDispatcher.interrupt();

        System.out.println("Market is closed: " + LocalTime.now());
        System.out.printf("Market Revenue: %.2f \n", marketRevenue );
    }

    @Override
    public Basket getBasket() {
        return new Basket();
    }

    @Override
    public void addBuyer(Buyer buyer) {
        if (buyer.isPensioner()) {
            pensioners.add(buyer);
        } else {
            buyers.add(buyer);
        }
        buyerCount.incrementAndGet();
        synchronized (cashierDispatcher) {
            cashierDispatcher.notify();
        }
    }

    public void removeBuyer(Buyer buyer) {
        buyerCount.decrementAndGet();
        synchronized (cashierDispatcher) {
            cashierDispatcher.notify();
        }
    }

    @Override
    public Buyer getBuyerFromQueue() {
        Buyer buyer = pensioners.poll();
        if (buyer == null) {
            buyer = buyers.poll();
        }

        return buyer;
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

    public void addCashToRevenue(double cash) {
        lock.lock();
        try {
            marketRevenue = marketRevenue + cash;
        } finally {
            lock.unlock();
        }
    }

    private Map<String, Good> initMarketGoods() {
        return Stream.of(new Good("Хлеб", 1.28), new Good("Молоко", 1.02), new Good("Сахар", 2.20),
                new Good("Конфеты", 5.50), new Good("Чай", 3.59))
                .collect(Collectors.toMap(Good::getName, good -> good));
    }
}
