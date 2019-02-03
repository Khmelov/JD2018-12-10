package by.it.skosirskiy.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Cashier extends Thread {

    private String name;
    public boolean close = true;

    HashMap<String, Integer> bufHashMap= new HashMap<>();
    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");

        while (!Dispatcher.planComplete()) {

            if (close) {
//                System.out.println("касса отдыхает");
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Buyer buyer = DequeBuyer.poll();
            if (buyer != null) {Util.sleep(Util.getRandom(2000, 5000));
                int sum=0;
                synchronized (bufHashMap){
                bufHashMap = Backet.cheсkHashMap.get(buyer);}
                for (Map.Entry entry : bufHashMap.entrySet()) {
                     sum=sum+(int)entry.getValue();


                }
                //System.out.printf("%10s%10s%12s\n%12s\n%15\n%12s%8s", this, " service ", " + buyer+"," check ", bufHashMap, " Сумма чека:", sum);
                System.out.println(this + " service " + buyer+". check \n"+bufHashMap+" Сумма чека:\n"+sum);



                synchronized (buyer.getMonitor()) {
                    buyer.getMonitor().notify();
                }
            } else {
                Util.sleep(1);
            }
        }
        System.out.println(this + " closed");
    }
    public void close() {
//        System.out.println(this + "closed");
        this.close = false;
        synchronized (this) {
            notify();
        }
    }

    public boolean getStatus() {
        return close;
    }
    public void goToWork() {
//        System.out.println(this+"start working");
        this.close = false;
        synchronized (this) {
            notify();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
