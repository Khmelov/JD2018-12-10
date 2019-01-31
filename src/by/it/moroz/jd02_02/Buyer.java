package by.it.moroz.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    Buyer(int num) {
        super("Buyer №" + num);
        Util.newBuyer();
    }

    private boolean pensioner;

    void setPensioner(boolean value) {
        this.pensioner = value;
    }


    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int count = Util.getRandom(1, 4);
        for (int i = 0; i < count; i++) {
            String good = GoodsInMarket.choseRandomGood(GoodsInMarket.goods);
            chooseGoods(good);
            putGoodsToBasket(good);
        }
        goToQueue();
        goOut();
        System.out.flush();
        Util.buyerComplete();
    }

    @Override
    public void enterToMarket() {
        if (pensioner)
            Util.sleep((int) (10 * 1.5));
        else Util.sleep(10);
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods(String good) {
        int time = Util.getRandom(5000, 20000);
        if (pensioner)
            Util.sleep((int) (time * 1.5));
        else
            Util.sleep(time);
        System.out.println(this + " chose " + good);
    }

    @Override
    public void goToQueue() {
        System.out.println(this+" go to queue");
        DequeBuyers.add(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        if (pensioner)
            Util.sleep((int) (10 * 1.5));
        else Util.sleep(10);
        System.out.println(this + " go out from Market");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        int time = Util.getRandom(1000, 2000);
        if (pensioner)
            Util.sleep((int) (time * 1.5));
        else
            Util.sleep(time);
        System.out.println(this + " took the basket");
    }

    @Override
    public void putGoodsToBasket(String good) {
        int time = Util.getRandom(1000, 2000);
        if (!pensioner)
            Util.sleep(time);
        else
            Util.sleep((int) (time * 1.5));
        System.out.println(this + " put " + good + " to basket");

    }
}
