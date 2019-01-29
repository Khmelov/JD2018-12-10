package by.it.skosirskiy.jd02_02;



class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        System.out.flush();

        while (true) {
            System.out.println("DequeBuyer "+DequeBuyer.sizeDeque());
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
                if (DequeBuyer.sizeDeque()==0){
                    if(Dispatcher.getCounterBuyerInShop()==0){
                        break;
                    }
                }
            }
        }
        System.out.println(this + " closed");

        System.out.flush();
    }

    @Override
    public String toString() {
        return name;
    }
}
