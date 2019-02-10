package by.it.subach.jd02_01;

public class Buyer extends Thread implements IByuer, IUseBasket {

    Buyer(int number) {
        super("Buyer №" + number);
    }

    private double speed = 1;
    static int pens;
    private boolean pensioneer;

    @Override
    public void run() {
        checkAge();
        if (pensioneer) speed = 1.5;
        enterToMarket();
        Thread.yield();
        takeBasket();
        int goodsCount = Util.getRandom(1, 4);
        for (int i = 1; i <= goodsCount; i++) {
            chooseGoods();
            putGoodsToBasket();
        }
        goOut();
        Thread.yield();
        System.out.flush();
        Dispatcher.counterBuyer--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");
        System.out.flush();
    }

    @Override
    public void chooseGoods() {
        int timeout = (int) (Util.getRandom(500, 2000) * speed);
        int value = Util.getRandom(Util.products.length - 1);
        String good = Util.products[value];
        System.out.println(this + " choose " + good + ". Cost: " + Util.priceList.get(good) + " in " + timeout + " msec");
        Util.sleep(timeout);
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from market\n");
        System.out.flush();
        Util.sleep(200);
    }

    @Override
    public void takeBasket() {
        int timeout = (int) (Util.getRandom(100, 200) * speed);
        System.out.println(this + " take the basket in " + timeout + " msec");
        Util.sleep(timeout);
    }

    @Override
    public void putGoodsToBasket() {
        int timeout = (int) (Util.getRandom(100, 200) * speed);
        System.out.println(this + " put good to basket " + timeout + " msec");
        Util.sleep(timeout);

    }

    private void checkAge() {
        if (Math.random() < 0.25) {
            pensioneer = true;
            pens++;
        }
    }

    @Override
    public String toString() {
        if (pensioneer) return this.getName() + " пенсионер";
        else return this.getName();
    }


}
