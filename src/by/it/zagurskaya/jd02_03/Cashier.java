package by.it.zagurskaya.jd02_03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static by.it.zagurskaya.jd02_03.Runner.CASHIERS;

class Cashier implements Runnable {

    private static AtomicInteger index = new AtomicInteger(0);

    private static AtomicInteger cashierCount = new AtomicInteger(0);

    private static final Semaphore SEMAPHORE = new Semaphore(1, true);

    private Thread thisThread;

    private String name;

    Cashier() {
        name = "Cashier #" + index.incrementAndGet();
        cashierCount.incrementAndGet();
    }

    @Override
    public void run() {
        System.out.println("++++++++++++++++++++++++++ " + this + " opened");
        while (!Dispatcher.planComplete() || DequeBuyer.getDequeBuyerSize() != 0) {

            try {
                SEMAPHORE.acquire();
                if (((((DequeBuyer.getDequeBuyerSize() - 1) / 5) + 1) > cashierCount.get()) && (cashierCount.get() < 5)) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> " + DequeBuyer.getDequeBuyerSize() + " = " + cashierCount.get());
                    Cashier cashier = new Cashier();
                    if (!CASHIERS.isShutdown()) {
                        CASHIERS.execute(cashier);
                    }
                }
                if ((((DequeBuyer.getDequeBuyerSize() - 1) / 5) + 1) < cashierCount.get()) {
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<< " + DequeBuyer.getDequeBuyerSize() + " = " + cashierCount.get());
                    cashierCount.decrementAndGet();
                    SEMAPHORE.release();
                    break;
                }
                SEMAPHORE.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Buyer serviceBuyer = DequeBuyer.poll();
            if (serviceBuyer != null) {
                System.out.println(this + " service " + serviceBuyer + ". Bill = " + serviceBuyer.getBill());
                synchronized (serviceBuyer.getMonitor()) {
                    serviceBuyer.notifyAll();
                }
            } else {
                Util.sleep(10);
            }
            Util.sleep(3000);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public Thread getThread() {
        return thisThread;
    }

    public void setThread(Thread thisThread) {
        this.thisThread = thisThread;
    }

}
