package by.it.titkovskaya.jd02_02_2.jd02_02;

public class Cashier implements Runnable {

    private String name;
    static volatile boolean goOnBreak = false;
    static volatile boolean continueWorking = false;
    boolean isOnBreak;

    Object getMonitor() {
        return this;
    }

    Cashier(int number) {
        name = "Cashier №" + number;
        Dispatcher.cashierNumber.incrementAndGet();
    }

    @Override
    public void run() {
        cashierAction(" opened");
        while (!Dispatcher.planComplete()) {
            if (goOnBreak) {
                synchronized (this) {
                    goOnBreak = false;
                    this.cashierAction(" is on break");
                    CashDeskManager.sendToStaffRoom(this);
                    isOnBreak = true;
                    while (isOnBreak){
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            cashierWorks();
        }
        cashierAction(" closed");
    }

    private void cashierWorks() {
        Buyer buyer = DequeBuyer.poll();
        if (buyer != null) {
            int timeout = Util.getRandom(2000, 5000);
            Util.sleep(timeout);
            addAmountBuyerSpentToTotalRevenue(buyer);
            servesBuyerAndPrintCashVoucher(buyer, formBuyerCashVoucher(buyer));
            synchronized (buyer.getMonitor()) {
                buyer.iWait = false;
                buyer.notify();
            }
        } else {
            Util.sleep(1);
        }
    }

    void cashierAction(String action) {
        if (this.name.contains("1")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , this + action, "", "", "", "", "", "");
        } else if (this.name.contains("2")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", this + action, "", "", "", "", "");
        } else if (this.name.contains("3")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", this + action, "", "", "", "");
        } else if (this.name.contains("4")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", "", this + action, "", "", "");
        } else if (this.name.contains("5")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", "", "", this + action, "", "");
        } else System.out.println("Cashier is not identified!");
    }

    private void addAmountBuyerSpentToTotalRevenue(Buyer buyer) {
        Double buyerTotalSum = Buyer.buyerTotalSum.get(buyer);
        synchronized (Dispatcher.REVENUE_MON) {
            Dispatcher.setTotalRevenueCounter(buyerTotalSum);
        }
    }

    private String[] formBuyerCashVoucher(Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        sb.append("______________________").append(";");
        sb.append("  CHECK of ").append(buyer.toString().replace(" (pensioner)", "")).append(";");
        sb.append(Basket.buyersBaskets.get(buyer));
        sb.append("TOTAL: ").append(String.format("%.1f", Buyer.buyerTotalSum.get(buyer))).append("$").append(";");
        sb.append("______________________");
        return sb.toString().split(";");
    }

    private void servesBuyerAndPrintCashVoucher(Buyer buyer, String[] forCheck) {
        if (this.name.contains("1")) {
            synchronized (Dispatcher.CONSOLE_MON) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , this + " is serving ", "", "", "", "", DequeBuyer.getTotalDequeSize()
                        , Dispatcher.getTotalRevenueCounter()
                        , buyer, "", "", "", "", "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , str, "", "", "", "", "", "");
                }
            }
        } else if (this.name.contains("2")) {
            synchronized (Dispatcher.CONSOLE_MON) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", this + " is serving ", "", "", "", DequeBuyer.getTotalDequeSize()
                        , Dispatcher.getTotalRevenueCounter()
                        , "", buyer, "", "", "", "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , "", str, "", "", "", "", "");
                }
            }
        } else if (this.name.contains("3")) {
            synchronized (Dispatcher.CONSOLE_MON) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", this + " is serving ", "", "", DequeBuyer.getTotalDequeSize()
                        , Dispatcher.getTotalRevenueCounter()
                        , "", "", buyer, "", "", "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , "", "", str, "", "", "", "");
                }
            }
        } else if (this.name.contains("4")) {
            synchronized (Dispatcher.CONSOLE_MON) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", "", this + " is serving ", "", DequeBuyer.getTotalDequeSize()
                        , Dispatcher.getTotalRevenueCounter()
                        , "", "", "", buyer, "", "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , "", "", "", str, "", "", "");
                }
            }
        } else if (this.name.contains("5")) {
            synchronized (Dispatcher.CONSOLE_MON) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", "", "", this + " is serving ", DequeBuyer.getTotalDequeSize()
                        , Dispatcher.getTotalRevenueCounter()
                        , "", "", "", "", buyer, "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , "", "", "", "", str, "", "");
                }
            }
        } else System.out.println("Cashier is not identified!");
    }

    @Override
    public String toString() {
        return name;
    }
}
