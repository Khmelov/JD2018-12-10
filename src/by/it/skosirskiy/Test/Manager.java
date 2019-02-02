package by.it.skosirskiy.Test;

public class Manager extends Thread{

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            Thread cashier = new Thread(new Cashier(i));
            Runner.threads.add(cashier);
            cashier.start();
            try {
                cashier.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        

    }
}
