package by.it.titkovskaya.jd02.jd02_03;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CashDeskManager extends Thread {

    private static ExecutorService cashiers = Executors.newFixedThreadPool(5);
    private static CopyOnWriteArrayList<Cashier> cashiersStaff = new CopyOnWriteArrayList<>();
    private static int cashDeskNumber = 0;

    @Override
    public void run() {

        int cashiersToStart = 2;
        cashDeskOpen(cashiersToStart);
        cashDeskOpen(5);

        while (!Dispatcher.planComplete()) {
            checkCashDeskRequired();
        }
        Util.sleep(1000);

        for (Cashier cashier : cashiersStaff) {
            synchronized (cashier.getMonitor()) {
                cashier.notifyAll();
            }
        }

        cashiers.shutdown();
        while (!cashiers.isTerminated())
            Thread.yield();
    }

    private static void cashDeskOpen(int cashDesksRequired) {
        for (int i = cashDeskNumber + 1; i <= cashDesksRequired; i++) {
            Cashier cashier = new Cashier(i);
            cashiersStaff.add(cashier);
            cashDeskNumber++;
            cashiers.execute(cashier);
        }
    }

    private void checkCashDeskRequired() {
        int cashDesksRequired = DequeBuyer.getDequeSize() / 5 + 1;
        if (cashDesksRequired > 5) cashDesksRequired = 5;
        for (int i = 0; i < cashDesksRequired; i++) {
            if (cashiersStaff.size()>0){
                Cashier cashier = cashiersStaff.get(i);
                synchronized (cashier.getMonitor()) {
                    cashier.notify();
                }
            }
        }
    }
}
