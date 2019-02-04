package by.it.dziomin.jd02_03;

import java.util.concurrent.atomic.AtomicBoolean;

public class Cashier implements Runnable {

    private AtomicBoolean isOpened = new AtomicBoolean(false);

    private String name;
    private Market market;

    public Cashier(String name, Market market) {
        this.name = name;
        this.market = market;
    }

    @Override
    public void run() {
        while (market.isAlive()) {

            cashClose();
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }

            cashOpen();
            while (isOpened.get()) {
                Buyer buyer = market.getBuyerFromQueue();
                if (buyer != null) {
                    processBuyer(buyer);

                    synchronized (buyer.getMonitor()) {
                        buyer.getMonitor().notify();
                    }
                }
            }
        }
    }

    private void processBuyer(Buyer buyer) {
        String pens = buyer.isPensioner() ? " pens" : "";
        System.out.println(name + " service " + buyer.getName() + pens);

        double sum = buyer.getBasket().getGoods().entrySet().stream()
                .map(e -> e.getKey().getPrice() * e.getValue())
                .mapToDouble(Double::doubleValue).sum();

        System.out.printf(name + ": receipt of " + buyer.getName() + buyer.getBasket() + "Total sum: %.2f \n", sum);
        market.addCashToRevenue(sum);

        Util.sleep(Util.getRandom(2000, 5000));
    }

    void cashOpen() {
        System.out.println(name + " opened");
    }

    void cashClose() {
        System.out.println(name + " closed");
    }

    public void setClosed() {
        isOpened.set(false);
    }

    public void setOpened() {
        isOpened.set(true);
    }

    public boolean isOpened() {
        return isOpened.get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
