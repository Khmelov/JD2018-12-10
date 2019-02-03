package by.it.skosirskiy.jd02_02_old;


public class Buyer extends Thread implements IBuyer, IUseBacket {
    Object getMonitor(){
        return this;
    }
    private static boolean pensioner;
    Buyer(int number){super("Buyer №"+number);
        Dispatcher.newBuyer();}
    @Override
    public void run() {

        enterToMarket();
        isPensioner();
        takeBacket();
        putGoodsToBacket();
        chooseGoods();
        goToQueue();

        goOut();
        System.out.flush();
        Dispatcher.buyerComplete();


    }

    private void isPensioner() {
        if (Util.getRandom(3) == 0) {
            pensioner = true;
        } else {
            pensioner = false;
        }
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to Market");
        System.out.flush();

    }

    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this+" chose goods "+timeout+" milliseconds");
        Util.sleep(timeout);
        System.out.println(this+" chose goods");
        System.out.flush();
    }

    @Override
    public void goToQueue() {
        System.out.println(this+" go to Queue");
        System.out.flush();
        DequeBuyer.add(this);

        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void goOut() {
        System.out.println(this+" go out from market");
        System.out.flush();
    }

    @Override
    public void takeBacket() {
        sleepBuy();
        System.out.println(this+" take backet");
        System.out.flush();
    }

    @Override
    public void putGoodsToBacket() {

        for (int i = 0; i < Util.getRandom(1,4); i++) {
            sleepBuy();
            System.out.println(this+" take "+ Goods.getRandomBuy()+" in backet,"+" buer is pensionner: "+ pensioner);
            System.out.flush();
        }
    }

    private void sleepBuy( ) {
        double k=1;
        if(pensioner){k =1.5;}
        int timeout = (int) (Util.getRandom(100, 200)*k);
        Util.sleep(timeout);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}