package by.it.moroz.jd02_02;

class Cashier implements Runnable {

    private String name;

    public Cashier(int number){
        name = "Cashier №"+number;
    }


    @Override
    public void run() {
        System.out.println(this+" opened");
        while (!Util.planComplete()) {
            Buyer buyer = DequeBuyers.poll();
            if(buyer!=null){
                System.out.println(this+" "+buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else Util.sleep(1);
        }
        System.out.println(this+" closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
