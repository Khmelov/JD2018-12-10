package by.it.a_khmelev.jd02_03;

class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Dispatcher.planComplete()) {
            Buyer buyer = DequeBuyer.poll();
            if (buyer != null) {
                System.out.println(this + " service " + buyer);
                synchronized (buyer.getMonitor()) {
                    //снятие признака ожидания
                    buyer.iWait=false;
                    buyer.getMonitor().notify();
                }
            } else {
                Util.sleep(1);
            }
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
