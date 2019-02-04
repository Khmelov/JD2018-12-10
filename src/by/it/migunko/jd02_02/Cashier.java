package by.it.migunko.jd02_02;

class Cashier implements Runnable {

    private String name;
    Cashier(int number) {
        name = "Кассир №" + number;
    }

    @Override
    public void run() {
        System.out.println(name + " открыл кассу");
        while (Dispatcher.openedMarket()) {
            Buyer buyer = BuyerQueue.extractBuyerFromQueue();
            if (buyer != null) {

                System.out.println(this + " обслуживает " + buyer);
                Util.sleep(Util.rnd(2000, 5000));
                double check=buyer.totalCheck();
                System.out.print(this + " завершил обслуживание " + buyer+", сумма чека: ");
                System.out.printf("%.2f \n", check);
                Dispatcher.completeBuyer();
                synchronized (buyer) {
                    buyer.notify();
                }
            } else
                Util.sleep(10);

        }
        System.out.println(name + " закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
