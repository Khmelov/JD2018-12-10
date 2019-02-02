package by.it.skosirskiy.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Cashier implements Runnable {

    private String name;

    HashMap<String, Integer> bufHashMap= new HashMap<>();
    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Dispatcher.planComplete()) {
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

    @Override
    public String toString() {
        return name;
    }
}
