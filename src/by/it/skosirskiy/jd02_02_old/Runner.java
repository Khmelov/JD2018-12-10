package by.it.skosirskiy.jd02_02_old;


import java.util.ArrayList;
import java.util.List;

public class Runner {
    static List<Thread> threads = new ArrayList<>();
    private static Manager manager;
    public static List<Cashier> cashiers = new ArrayList<>();
    public static void main(String[] args) {
        manager = new Manager();
        threads.add(manager);
        manager.start();
        openMarket();
        marketWorkingTime();

        System.out.println("Market closed");
        System.out.flush();

    }

    private static void marketWorkingTime() {
        int number = 0;



        for (int time = 1; ; time++) {
            Util.sleep(3500);
            if (time % 60 <= 30) {
                if ((Dispatcher.getCounterBuyerInShop() <= time + 10) && Dispatcher.marketOpened()) {
                    int count = Util.getRandom(10);
                    for (int i = 0; i < count; i++) {
                        if (!Dispatcher.marketOpened()) {
                            break;
                        }
                        Buyer buyer = new Buyer(++number);
                        threads.add(buyer);
                        buyer.start();
                    }
                } else Util.sleep(1000);
            } else {
                if ((Dispatcher.getCounterBuyerInShop() >= 40 + (30 - time)) && Dispatcher.marketOpened()) {
                    Util.sleep(1000);
                } else {
                    int count = Util.getRandom(2);


                    for (int i = 0; i < count; i++) {
                        if (!Dispatcher.marketOpened()) {
                            break;
                        }
                        Buyer buyer = new Buyer(++number);
                        threads.add(buyer);
                        buyer.start();
                    }
                }
            }
            if (Dispatcher.planComplete()) {
                for (Thread thread : threads) {
                    try {
                        thread.join();
                        Util.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }

    private static void openMarket() {

        System.out.println("Market opened");
        System.out.flush();
        Goods.getPriceList();
    }
}