package by.it.titkovskaya.Temp;
/*
import by.it.titkovskaya.jd02_02_2.jd02_02.Cashier;
import by.it.titkovskaya.jd02_02_2.jd02_02.DequeBuyer;
import by.it.titkovskaya.jd02_02_2.jd02_02.Dispatcher;
import by.it.titkovskaya.jd02_02_2.jd02_02.Util;

import java.util.Deque;
import java.util.LinkedList;

public class CashDeskManager extends Thread {

    static Deque<Cashier> cashiers = new LinkedList<>();
    private static int cashDeskNumber = 0;
    private static int cashDeskOpened = 0;

    @Override
    public void run() {
        int cashiersToStart = 2;
        cashDeskOpen(cashiersToStart);

        while (!Dispatcher.planComplete()) {
            checkCashDeskRequired();
        }
        Util.sleep(1000);

        for (Cashier cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void cashDeskOpen(int cashDesksRequired) {
        for (int i = cashDeskNumber + 1; i <= cashDesksRequired; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            cashDeskNumber++;
            cashDeskOpened++;
            cashier.start();
        }
    }

    private void checkCashDeskRequired() {
        int cashDesksRequired = DequeBuyer.getTotalDequeSize() / 5 + 1;
        if (cashDesksRequired > 5) cashDesksRequired = 5;
        if (cashDeskOpened < cashDesksRequired) {
            if (cashDeskNumber < cashDesksRequired) {
                cashDeskOpen(cashDesksRequired);
            }
            if (cashDeskOpened < cashDesksRequired) {
                for (int i = 1; i <= cashDesksRequired - cashDeskOpened; i++) {
                    Cashier cashier = cashiers.poll();
                    if (cashier != null) {
                        cashDeskOpened++;
                        synchronized (cashier.getMonitor()) {
                            cashier.notify();
                        }
                    }
                }
            }
        }
        if (cashDeskOpened > cashDesksRequired) {
            Cashier.goOnBrake = true;
            cashDeskOpened--;
        }
    }

}
*/