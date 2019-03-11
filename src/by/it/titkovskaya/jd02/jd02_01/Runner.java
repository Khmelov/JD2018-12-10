package by.it.titkovskaya.jd02.jd02_01;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Runner {

    private static List<Buyer> buyers = new LinkedList<>();
    static Set<Map.Entry<String, Double>> entries = Goods.goodsList.entrySet();
    private static int number = 0;
    static int time;

    public static void main(String[] args) {
        Goods.load();
        marketOpening();
        marketWorkingTime();
        marketClosing();
        summarizing();
    }

    private static void marketOpening() {
        System.out.printf("\n%-85s\n%-85s" + "\n %-23s | %-35s | %-6s | %-11s | %-5s | %-10s\n" +
                        " %-23s | %-35s | %-6s | %-11s | %-5s | %-10s\n" +
                        "%-85s\n"
                , " MARKET OPENED"
                , "-------------------------------------------------------------------------------------------------------------------"
                , "Buyer (special signs)", "Actions", "Money", "Time spent,", "Exit", "Total buyers number"
                , " ", " ", "spent", "sec", "time", "before exit"
                , "-------------------------------------------------------------------------------------------------------------------");
    }

    private static void marketWorkingTime() {

        for (time = 1; time <= 120; time++) {
            int sec = time % 60;
            if (time <= 30 || time >= 61 && time <= 90) {
                buyersTraffic(sec + 10 - Dispatcher.buyersCounter);
            } else if (Dispatcher.buyersCounter > 40 + (30 - sec)) {
                Util.sleep(1000);
            }
            else{
                buyersTraffic(Util.getRandom(1));
            }
        }
        while (Dispatcher.buyersCounter > 0) {
            Util.sleep(1);
        }
    }

    private static void buyersTraffic(int count) {
        for (int i = 0; i < count; i++) {
            Buyer buyer = new Buyer(++number);
            buyers.add(buyer);
            Dispatcher.buyersCounter++;
            buyer.start();
        }
        Util.sleep(1000);
    }

    private static void marketClosing() {
        System.out.printf("%-85s\n" +
                        " %-23s | %-35s | %-6s | %-11s | %-5s | %-10s\n" +
                        " %-23s | %-35s | %-6s | %-11s | %-5s | %-10s\n" +
                        "%-85s\n" +
                        "%-85s\n"
                , "-------------------------------------------------------------------------------------------------------------------"
                , "Buyer (special signs)", "Actions", "Money", "Time spent,", "Exit", "Total buyers number"
                , " ", " ", "spent", "sec", "time", "before exit"
                , "-------------------------------------------------------------------------------------------------------------------"
                , " MARKET CLOSED");
    }

    private static void summarizing() {
        System.out.printf("\n\n%-15s\n%-85s\n" +
                        " %23s | %-10s  %23s | %-6.1f$\n" +
                        " %23s | %-10s  %23s | %-2.1f$\n" +
                        " %23s | %-10.1f  %23s | %-7s\n  " +
                        " %21s | %-10.1f  %23s | %-7.1f\n", " STATISTICS"
                , "----------------------------------------------------------------------------"
                , "TOTAL BUYERS", buyers.size(), "TOTAL SUM", Dispatcher.totalSumCounter
                , "incl. pensioners", Dispatcher.pensionersCounter, "average per buyer",
                Dispatcher.totalSumCounter / buyers.size()
                , "TOTAL TIME SPENT", Dispatcher.totalTimeSpent, "TOTAL GOODS", Dispatcher.totalGoodsCounter
                , "average per buyer", Dispatcher.totalTimeSpent / buyers.size()
                , "average per buyer", (double) Dispatcher.totalGoodsCounter / buyers.size());
    }
}
