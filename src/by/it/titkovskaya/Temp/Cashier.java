package by.it.titkovskaya.Temp;
/*
import java.util.concurrent.Semaphore;

public class Cashier implements Runnable {

    private String name;
    protected static boolean close = false;
    static double totalRevenue = 0;

    private static Semaphore semaphore1 = new Semaphore(1);
    private static Semaphore semaphore2 = new Semaphore(2);
    private static Semaphore semaphore3 = new Semaphore(3);
    private static Semaphore semaphore4 = new Semaphore(4);
    private static Semaphore semaphore5 = new Semaphore(5);

    Cashier(int number) {
        name = "Cashier №" + number;
        Dispatcher.cashierNumber.incrementAndGet();
    }

    @Override
    public void run() {
        cashierAction(" opened");
        while (!Dispatcher.planComplete()) {
            if (DequeBuyer.getDequeSize()<5) {
                try {
                    semaphore1.acquire();
                    cashierWorks();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore1.release();
                }
            }
            if (DequeBuyer.getDequeSize()>=5&&DequeBuyer.getDequeSize()<10) {
                try {
                    semaphore2.acquire();
                    cashierWorks();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore2.release();
                }
            }
            if (DequeBuyer.getDequeSize()>=10&&DequeBuyer.getDequeSize()<15) {
                try {
                    semaphore3.acquire();
                    cashierWorks();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore3.release();
                }
            }
            if (DequeBuyer.getDequeSize()>=15&&DequeBuyer.getDequeSize()<20) {
                try {
                    semaphore4.acquire();
                    cashierWorks();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore4.release();
                }
            }
            if (DequeBuyer.getDequeSize()>=20) {
                try {
                    semaphore5.acquire();
                    cashierWorks();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore5.release();
                }
            }

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

    private void cashierAction(String action) {
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
        try {
            Dispatcher.semaphoreRevenue.acquire();
            totalRevenue += buyerTotalSum;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Dispatcher.semaphoreRevenue.release();
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
        try {
            Dispatcher.semaphoreToPrint.acquire();
            if (this.name.contains("1")) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , this + " is serving ", "", "", "", "", DequeBuyer.getDequeSize()
                        , totalRevenue
                        , buyer, "", "", "", "", "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , str, "", "", "", "", "", "");
                }
            } else if (this.name.contains("2")) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", this + " is serving ", "", "", "", DequeBuyer.getDequeSize()
                        , totalRevenue
                        , "", buyer, "", "", "", "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , "", str, "", "", "", "", "");
                }
            } else if (this.name.contains("3")) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", this + " is serving ", "", "", DequeBuyer.getDequeSize()
                        , totalRevenue
                        , "", "", buyer, "", "", "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , "", "", str, "", "", "", "");
                }
            } else if (this.name.contains("4")) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", "", this + " is serving ", "", DequeBuyer.getDequeSize()
                        , totalRevenue
                        , "", "", "", buyer, "", "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , "", "", "", str, "", "", "");
                }
            } else if (this.name.contains("5")) {
                System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                                "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", "", "", this + " is serving ", DequeBuyer.getDequeSize()
                        , totalRevenue
                        , "", "", "", "", buyer, "", "");
                for (String str : forCheck) {
                    System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                            , "", "", "", "", str, "", "");
                }
            } else System.out.println("Cashier is not identified!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Dispatcher.semaphoreToPrint.release();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
*/