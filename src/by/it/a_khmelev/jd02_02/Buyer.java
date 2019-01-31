package by.it.a_khmelev.jd02_02;

public class Buyer extends Thread implements IBuyer {

    Object getMonitor(){
        return this;
    }

    Buyer(int number) {
        super("Buyer №"+number);
        Dispatcher.newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        System.out.flush();
        Dispatcher.buyerComplete();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to Market");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this+" chose goods "+timeout+" milliseconds");
        Util.sleep(timeout);
        System.out.println(this+" chose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this+" go to Queue");
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
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
