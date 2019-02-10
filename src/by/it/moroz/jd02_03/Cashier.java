package by.it.moroz.jd02_03;

class Cashier implements Runnable {

    private String name;
    private int numCashier;

    private Printer printer = new Printer();

    Cashier(int number) {
        Util.newCashier();
        name = "Cashier №" + number;
        this.numCashier = number;
    }

    @Override
    public void run() {
        try {
            printer.semaphore.acquire();
            System.out.println(this + " opened");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
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
        try {
            printer.semaphore.acquire();
            System.out.println(this + " closed");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
        }
    }

    private void serveTheBuyer(Buyer buyer) {
        int time = Util.getRandom(2000, 5000);
        Util.sleep(time);
        String whichCashier = whichCashier();
        try {
            printer.semaphore.acquire();
            System.out.println(whichCashier + this + " service " + buyer);
            buyer.takeCheck(whichCashier);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
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
