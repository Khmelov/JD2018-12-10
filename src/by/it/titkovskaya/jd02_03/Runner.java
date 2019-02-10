package by.it.titkovskaya.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    static int time;
    private static int buyerNumber = 0;

    public static void main(String[] args) {
        Goods.load();
        marketOpening();
        marketWorkingTime();
        marketClosing();
        summarizing();
        System.out.println(Dispatcher.cashierNumber.get());
    }

    private static void marketOpening() {
        System.out.printf("\n%-85s\n%-85s" + "\n" +
                        " %-48s | %-22s | %-22s | %-22s\n" +
                        " %-48s | %-22s | %-22s | %-22s\n" +
                        "%-85s\n" +
                        " %-23s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s \n" +
                        "%-85s\n\n"
                , " MARKET OPENED"
                , "--------------------------------------------------------------------------------------------------------------------------------------------------------"
                , "Buyers actions", "Enter/Exit", "BuyersInShop", ""
                , " ", "time", "before exit", ""
                , "--------------------------------------------------------------------------------------------------------------------------------------------------------"
                , "Cash Desk №1", "Cash Desk №2", "Cash Desk №3", "Cash Desk №4", "Cash Desk №5", "Queue Size", "TOTAL Revenue"
                , "--------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void marketWorkingTime() {

        ExecutorService buyers = Executors.newFixedThreadPool(100);

        CashDeskManager manager = new CashDeskManager();
        manager.start();

        for (time = 1; Dispatcher.marketOpened(); time++) {
            int sec = time % 60;
            if (time <= 30 || time >= 61 && time <= 90) {
                buyersTraffic(buyers, sec + 10 - Dispatcher.getCounterBuyerInShop().get());
            } else if (Dispatcher.getCounterBuyerInShop().get() >= 40 + (30 - sec)) {
                Util.sleep(1000);
            } else {
                buyersTraffic(buyers, 1);
            }
        }
        buyers.shutdown();
        while (!buyers.isTerminated())
            Util.sleep(1);

        try {
            manager.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void buyersTraffic(ExecutorService buyers, int count) {
        for (int i = 0; i < count; i++) {
            if (Dispatcher.marketOpened()) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyers.execute(buyer);
            }
        }
        Util.sleep(1000);
    }

    private static void marketClosing() {
        Util.sleep(10000);
        System.out.printf("\n%-85s\n" +
                        " %-23s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s \n" +
                        "%-85s\n" +
                        " %-48s | %-22s | %-22s | %-22s\n" +
                        " %-48s | %-22s | %-22s | %-22s\n" +
                        "%-85s\n" +
                        "%-85s\n"
                , "--------------------------------------------------------------------------------------------------------------------------------------------------------"
                , "Cash Desk №1", "Cash Desk №2", "Cash Desk №3", "Cash Desk №4", "Cash Desk №5", "Queue Size", "TOTAL Revenue"
                , "--------------------------------------------------------------------------------------------------------------------------------------------------------"
                , "Buyers actions", "Enter/Exit", "BuyersInShop", ""
                , " ", "time", "before exit", ""
                , "--------------------------------------------------------------------------------------------------------------------------------------------------------"
                , " MARKET CLOSED");
    }

    private static void summarizing() {
        System.out.printf("\n\n\n%-15s\n%-85s\n" +
                        " %23s | %-10s  %23s | %-6.1f$\n" +
                        " %23s | %-10s  %23s | %-2.1f$\n" +
                        " %23s | %-10s  %23s | %-7s\n  " +
                        " %21s | %-10.1f  %23s | %-7.1f\n", " STATISTICS"
                , "----------------------------------------------------------------------------"
                , "TOTAL BUYERS", Dispatcher.getCounterBuyerComplete(), "TOTAL SUM", Cashier.totalRevenue
                , "incl. pensioners", Dispatcher.getPensionersCounter(), "average per buyer"
                , Cashier.totalRevenue / Dispatcher.getCounterBuyerComplete().get()
                , "TOTAL TIME SPENT", Dispatcher.getTotalTimeSpent(), "TOTAL GOODS", Dispatcher.getTotalGoodsCounter()
                , "average per buyer"
                , (double) Dispatcher.getTotalTimeSpent().get() / Dispatcher.getCounterBuyerComplete().get()
                , "average per buyer", (double) Dispatcher.getTotalGoodsCounter().get() / Dispatcher.getCounterBuyerComplete().get());
    }

}
