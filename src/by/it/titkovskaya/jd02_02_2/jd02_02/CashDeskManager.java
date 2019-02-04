package by.it.titkovskaya.jd02_02_2.jd02_02;

import java.util.LinkedList;
import java.util.List;

public class CashDeskManager extends Thread {

    private static List<Thread> threads = new LinkedList<>();
    private static int cashDeskNumber = 0;
    private static int cashDeskOpened = 0;

    @Override
    public void run() {
        int cashiersToStart = 2;
        cashDeskOpen(cashiersToStart);

        while (!Dispatcher.planComplete()) {
            checkCashDeskRequired();
        }
        Util.sleep(1);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void cashDeskOpen(int cashDesksRequired) {
        for (int i = cashDeskNumber + 1; i <= cashDesksRequired; i++) {
            Thread cashier = new Thread(new Cashier(i));
            threads.add(cashier);
            cashDeskNumber++;
            cashDeskOpened++;
            cashier.start();
        }
    }

    private static void checkCashDeskRequired() {
        int cashDesksRequired = DequeBuyer.getTotalDequeSize() / 5 + 1;
        if (cashDesksRequired > 5) cashDesksRequired = 5;
        if (cashDeskOpened < cashDesksRequired) {
            if (cashDeskNumber < cashDesksRequired) {
                cashDeskOpen(cashDesksRequired);
            }
            if (cashDeskOpened < cashDesksRequired) {
                Cashier.continueWorking = true;
            }
        }
        if (cashDeskOpened > cashDesksRequired) {
            Cashier.goOnBreak = true;
            cashDeskOpened--;
        }
    }

    static void sendToStaffRoom(Cashier cashier) {
        if (Cashier.continueWorking) {
            Cashier.continueWorking = false;
            synchronized (cashier.getMonitor()) {
                cashier.isOnBreak = false;
                cashier.notify();
            }
            cashier.cashierAction(" is reopened");
            cashier.run();
            cashDeskOpened++;
        }
    }

}
