package by.it.moroz.jd02_02;

class Cashier implements Runnable {

    private String name;
    private int numCashier;

    Cashier(int number) {
        Util.newCashier();
        name = "Cashier №" + number;
        this.numCashier = number;
    }

    @Override
    public void run() {
        synchronized (Util.PRINTER) {
            System.out.println(this + " opened");
        }
        while (!Util.planComplete()) {
            Buyer pensioner = DequeBuyers.poll(DequeBuyers.pensionerDeque);
            if (pensioner != null) {
                serveTheBuyer(pensioner);
            } else {
                Buyer buyer = DequeBuyers.poll(DequeBuyers.buyerDeque);
                if (buyer != null)
                    serveTheBuyer(buyer);
                else Util.sleep(1);
            }
        }
        synchronized (Util.PRINTER) {
            System.out.println(this + " closed");
        }
    }

    private void serveTheBuyer(Buyer buyer) {
        int time = Util.getRandom(2000, 5000);
        Util.sleep(time);
        String whichCashier = whichCashier();
        synchronized (Util.PRINTER) {
            System.out.println(whichCashier + this + " service " + buyer);
            buyer.takeCheck(whichCashier);
        }
        synchronized (buyer.getMonitor()) {
            buyer.notify();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    private String whichCashier() {
        switch (this.numCashier) {
            case 1:
                return "";
            case 2:
                return "\t\t\t\t\t\t\t\t";
            case 3:
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
            case 4:
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
            case 5:
                return "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        }
        return null;
    }
}
