package by.it.titkovskaya.jd02.jd02_02;

import java.util.ArrayList;

public class CashDeskManager extends Thread {

    private static ArrayList<Cashier> cashiers = new ArrayList<>();
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

        for (Cashier cashier : cashiers) {
            synchronized (cashier.getMonitor()) {
                cashier.notifyAll();
            }
        }
    }

    private static void cashDeskOpen(int cashDesksRequired) {
        for (int i = cashDeskNumber + 1; i <= cashDesksRequired; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            cashDeskNumber++;
            cashier.start();
        }
    }

    private void checkCashDeskRequired() {
        int cashDesksRequired = DequeBuyer.getTotalDequeSize() / 5 + 1;
        if (cashDesksRequired > 5) cashDesksRequired = 5;
        for (int i = 0; i < cashDesksRequired; i++) {
            if (cashiers.size()>0){
                Cashier cashier = cashiers.get(i);
                synchronized (cashier.getMonitor()) {
                    cashier.notify();
                }
            }
        }
    }
}
