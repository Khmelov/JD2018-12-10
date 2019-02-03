package by.it.skosirskiy.jd02_02_old;

public class Manager extends Thread {
    private int workingCashiers=0;
    Manager() {
        super();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Runner.cashiers.add(cashier);
            System.out.println("new cassir");
            cashier.start();
        }
        while (Dispatcher.marketOpened()) {
            int n = neededNumOfCashiers();
            if(n==this.workingCashiers) {
                Util.sleep(1000);
                continue;
            }
            if(workingCashiers<n){
                for (Cashier cashier:Runner.cashiers) {
                    if(workingCashiers==n) break;
                    if(cashier.getStatus()) {
                        this.workingCashiers++;
                        cashier.goToWork();
                    }
                }
                continue;
            }
            if(workingCashiers>n){
                for (Cashier cashier:Runner.cashiers) {
                    if(workingCashiers==n) break;
                    if(!(cashier.getStatus())) {
                        this.workingCashiers--;
                        cashier.stop=true;
                    }
                }
            }
            Util.sleep(2000);
        }
        for (Cashier cashier:Runner.cashiers) {
            cashier.close();
        }
    }
    private static int neededNumOfCashiers(){
        int dequeSize = DequeBuyer.getSize();
        if(dequeSize<=5) return 1;
        if(dequeSize>5&&dequeSize<=10) return 2;
        if(dequeSize>10&&dequeSize<=15) return 3;
        if(dequeSize>15&&dequeSize<=20) return 4;
        if(dequeSize>20) return 5;
        return 0;
    }
    public synchronized  int getWorkingCashiers(){
        return workingCashiers;
    }
}