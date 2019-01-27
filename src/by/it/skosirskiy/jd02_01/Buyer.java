package by.it.skosirskiy.jd02_01;



public class Buyer extends Thread implements IBuyer, IUseBacket {

    Buyer(int number){super("Buyer №"+number);}
    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        putGoodsToBacket();
        chooseGoods();
        goOut();
        Dispatcher.counterBuyer--;
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
        System.out.flush();
        Util.sleep(timeout);
        System.out.println(this+" chose goods");
        System.out.flush();
    }

    @Override
    public void goOut() {
        System.out.println(this+" go out from market");
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
            System.out.println(this+" take "+Dispatcher.getRandomBuy()+" in backet,"+" buer is pensionner: "+Dispatcher.pensioneer);
            System.out.flush();
        }
    }

    private void sleepBuy( ) {
        double k=1;
        if(Dispatcher.pensioneer){k =1.5;}
        int timeout = (int) (Util.getRandom(100, 200)*k);
        Util.sleep(timeout);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
