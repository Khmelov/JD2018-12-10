package by.it.zagurskaya.jd02_02;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

class Cashier implements Runnable {

    private static Deque<Cashier> q = new LinkedBlockingDeque<>();
    private static Integer index = 0;

    private static final Object lock = new Object();

    private Thread thisThread;

    private String name;

    Cashier() {
        synchronized (lock) {
            name = "Cashier #" + ++index;
        }
        q.addLast(this);
    }

    @Override
    public void run() {
        System.out.println("++++++++++++++++++++++++++ " + this + " opened");
        while (!Dispatcher.planComplete()) {

            synchronized (lock) {
                if ((((DequeBuyer.getDequeBuyerSize() - 1) / 5) + 1) > q.size()) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> " + DequeBuyer.getDequeBuyerSize() + " = " + q.size());

                    Cashier cashier = new Cashier();
                    Thread cashierThread = new Thread(cashier);
                    cashier.setThread(cashierThread);
                    cashierThread.start();
                }
                if ((((DequeBuyer.getDequeBuyerSize() - 1) / 5) + 1) < q.size()) {
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<< " + DequeBuyer.getDequeBuyerSize() + " = " + q.size());
                    q.remove(this);
                    break;
                }
            }

            Buyer buyer = DequeBuyer.poll();
            if (buyer != null) {
                System.out.println(this + " service " + buyer + ". Bill = " + buyer.getBill());
                synchronized (buyer.getMonitor()) {
                    buyer.notifyAll();
                }
            } else {
                Util.sleep(10);
            }
            Util.sleep(500);
        }
        q.remove(this);
        System.out.println("-------------------------- " + this + " closed");
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

    public static Deque<Cashier> getQ() {
        return q;
    }
}
