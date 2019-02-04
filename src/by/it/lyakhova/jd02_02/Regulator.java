package by.it.lyakhova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Regulator extends Thread{


    private List<Cashier> cashiers = new ArrayList<>();

    private void createCashier(){
        for (int i = 1; i < 6; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            cashier.start();
        }
    }


    @Override
    public void run() {

        createCashier();

        while (!Dispatcher.planComplete()) {
            
            double numberOfCashier = Math.ceil(DequeBuyer.getFullQueue()/5)+1 ;

            if (DequeBuyer.getFullQueue()>0) {

                for (int i = 0; i < numberOfCashier && i < 5; i++) {
                    Cashier cashier = cashiers.get(i);
                    synchronized (cashier.getMonitor()) {
                        cashier.notify();
                    }
                }
            }

            Util.sleep(1000);
        }

        for (Cashier cashier :
                cashiers) {
            System.out.println(cashier + " close");
            synchronized (cashier.getMonitor()) {
                cashier.notify();
            }
        }


    }
}
