package by.it.skosirskiy.jd02_03;

import java.util.HashMap;

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
            Util.sleep(Util.getRandom(2000,5000));
            if (buyer != null) {
                HashMap<String, Integer> hm=new HashMap<>(Backet.checkHashMap.get(buyer));
                int sum=0;
                for (int value : hm.values()) {
                    sum=sum+value;
                }

                System.out.println(this + " service " + buyer+" \ncheck\n"+hm+"\n"+"общая сумма "+sum);


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
