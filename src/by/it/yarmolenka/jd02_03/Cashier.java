package by.it.yarmolenka.jd02_03;

import java.util.Map;

public class Cashier implements Runnable {
    private String name;
    private int cashierNumber;

    @Override
    public String toString() {
        return this.name;
    }

    public Cashier(int number) {
        Dispatcher.cashiersCount.incrementAndGet();
        this.name = "Cashier #" + number;
        this.cashierNumber = number;
    }

    @Override
    public void run() {
        try {
            Dispatcher.semaphoreConsole.acquire();
        System.out.println(this + " opened");
        Dispatcher.semaphoreConsole.release();
        while (!Dispatcher.planComplete() &&
                BuyerQueue.queue.size() >= (Dispatcher.cashiersCount.get() - 1) * 5
        ) {
            Buyer buyer = BuyerQueue.pollBuyer();
            if (buyer != null) {
                cashierServiceBuyer(buyer);
            }
        }
        Dispatcher.cashiersCount.decrementAndGet();
        Dispatcher.semaphoreConsole.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(this + " closed");
        Dispatcher.semaphoreConsole.release();
    }

    private void cashierServiceBuyer(Buyer buyer) throws InterruptedException {
        String s = getShiftForConsole();
        Dispatcher.semaphoreConsole.acquire();
            cashierWorkToConsole(buyer, s);
        Dispatcher.semaphoreConsole.release();
        int time = Utils.getRandom(2000, 5000);
        Utils.sleep(buyer.retired ? (int) (time * 1.5) : time);
        Dispatcher.semaphore.release();
    }

    private void cashierWorkToConsole(Buyer buyer, String s) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSize of queue: " +
                BuyerQueue.queue.size());
        System.out.println(s + this + " service " + buyer);
        int price = 0;
        for (Map.Entry<String, Integer> entry : buyer.basket.goods.entrySet()) {
            System.out.println(s + buyer + " bought " + entry.getKey() + " for " + entry.getValue());
            price += entry.getValue();
        }
        System.out.println(s + buyer + " totally paid = " + price);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tMarket's cashier: " +
                Dispatcher.overallPrice.addAndGet(price));
    }

    private String getShiftForConsole() {
        String s;
        switch (this.cashierNumber) {
            case 1:
                s = "\t\t\t";
                break;
            case 2:
                s = "\t\t\t\t\t\t";
                break;
            case 3:
                s = "\t\t\t\t\t\t\t\t\t";
                break;
            case 4:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 5:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 6:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 7:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 8:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            default:
                s = "";
        }
        return s;
    }
}
