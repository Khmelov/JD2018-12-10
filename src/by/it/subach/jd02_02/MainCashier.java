package by.it.subach.jd02_02;


public class MainCashier extends Thread{

    private String name;

    public MainCashier() {
        name = "Boss";
    }

    public String getBossName(){
        return name;
    }

    public void run(){
        System.out.println(this.name + " READY!");

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
//            Dispatcher.waitingCashiers.addFirst(cashier);
            cashier.start();
//            Util.sleep(1000);
        }



    }

}
