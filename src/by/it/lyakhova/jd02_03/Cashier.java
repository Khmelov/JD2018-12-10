package by.it.lyakhova.jd02_03;


import java.util.Map;

public class Cashier extends Thread {

    private String name;
    private Buyer buyer;



    Object getMonitor(){
        return this;
    }


    public Cashier (int number){
        //this.number = number;
        this.name = "Cashier №" + number;
    }

    private void open(){
        System.out.println(this + " opened");
    }

    private void service(){

        Util.sleep(Util.getRandom(2000, 5000));
        try {
            Dispatcher.semaphoreConsol.acquire();
            System.out.println();
            if (this.toString().contains("1")) {
                System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n", this + " service " + buyer, "", "", "", "", "", "");
            }
            if (this.toString().contains("2")) {
                System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n", "", this + " service " + buyer, "", "", "", "", "");
            }
            if (this.toString().contains("3")) {
                System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n", "", "", this + " service " + buyer, "", "", "", "");
            }
            if (this.toString().contains("4")) {
                System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n", "", "", "", this + " service " + buyer, "", "", "");
            }
            if (this.toString().contains("5")) {
                System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n", "", "", "", "", this + " service " + buyer, "", "");
            }
            printCheck(buyer);
            System.out.println();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            Dispatcher.semaphoreConsol.release();
        }

        synchronized (buyer.getMonitor()) {
            buyer.iWait = false;
            buyer.getMonitor().notify();
        }
    }

    private void printCheck(Buyer buyer) {
        int price = 0;
        for (Map.Entry<String, Integer> entry: buyer.goodsBasket.entrySet()){
            if (this.toString().contains("1")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n",buyer + " " + entry.getKey() + " for " + entry.getValue(),"","","","","","");}
            if (this.toString().contains("2")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","",buyer + " " + entry.getKey() + " for " + entry.getValue(),"","","","","");}
            if (this.toString().contains("3")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","","",buyer + " " + entry.getKey() + " for " + entry.getValue(),"","","","");}
            if (this.toString().contains("4")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","","","",buyer + " " + entry.getKey() + " for " + entry.getValue(),"","","");}
            if (this.toString().contains("5")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","","","","",buyer + " " + entry.getKey() + " for " + entry.getValue(),"","");}
            price+=entry.getValue();
        }
        Dispatcher.totalSum.addAndGet(price);
        if (this.toString().contains("1")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","Totally paid " + price,"","","","","Queue = "+ DequeBuyer.getSizePensioneer(),"Total sum = "+ Dispatcher.totalSum);}
        if (this.toString().contains("2")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","","Totally paid " + price,"","","","Queue = "+ DequeBuyer.getSizePensioneer(),"Total sum = "+ Dispatcher.totalSum);}
        if (this.toString().contains("3")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","","","Totally paid " + price,"","","Queue = "+ DequeBuyer.getSizePensioneer(),"Total sum = "+ Dispatcher.totalSum);}
        if (this.toString().contains("4")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","","","","Totally paid " + price,"","Queue = "+ DequeBuyer.getSizePensioneer(),"Total sum = "+ Dispatcher.totalSum);}
        if (this.toString().contains("5")){System.out.printf("%-40s||%-40s||%-40s||%-40s||%-40s||%-15s||%-15s\n","","","","","Totally paid " + price,"Queue = "+ DequeBuyer.getSizePensioneer(),"Total sum = "+ Dispatcher.totalSum);}
    }


    private void close(){
        System.out.println(this + " closed");
    }


    @Override
    public void run() {

        while(!Dispatcher.planComplete()){

            open();
            synchronized (this){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



            /*if (DequeBuyer.getSizePensioneer() > 0) {buyer = DequeBuyer.pollPensioneer();}
            else {buyer = DequeBuyer.pollBuyer();}*/

            buyer = DequeBuyer.takeBuyer();

            if (buyer!=null){
                service();

            } else {
                Util.sleep(1);
            }
        }
       //close();
    }

    @Override
    public String toString() {
        return name;
    }
}
