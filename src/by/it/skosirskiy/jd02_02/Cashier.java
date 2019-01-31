package by.it.skosirskiy.jd02_02;



class Cashier extends Thread {

    private String name;
    public boolean stop = true;
    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        System.out.flush();




        while (true) {
            if (stop) {
//                System.out.println("касса отдыхает");
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("DequeBuyer "+DequeBuyer.getSize());
            Buyer buyer = DequeBuyer.poll();
            Util.sleep(Util.getRandom(2000, 5000));
            if (buyer != null) {

                System.out.println(this + " service " + buyer);

                System.out.flush();
                synchronized (buyer.getMonitor()) {
                    buyer.notify();
                }
            } else {
                Util.sleep(1);
            }
            if (Dispatcher.planComplete()){
                if (DequeBuyer.getSize()==0){
                    if(Dispatcher.getCounterBuyerInShop()==0){
                        break;
                    }
                }
            }
        }
        System.out.println(this + " closed");

        System.out.flush();
    }

    public boolean getStatus() {
        return stop;
    }
    public void goToWork() {
        System.out.println(this+"start working");
        this.stop = false;
        synchronized (this) {
            notify();
        }
    }

    public void close() {
        System.out.println(this + "closed");
        this.stop = false;
        synchronized (this) {
            notify();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
