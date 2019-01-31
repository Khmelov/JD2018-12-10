package by.it.moroz.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    Buyer(int num) {
        super("Buyer №" + num);
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
        goOut();
        System.out.flush();
        Util.counterBuyer--;
    }

    @Override
    public void enterToMarket() {
        if (pensioner)
            Util.sleep((int) (15 * 1.5));
        else Util.sleep(15);
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods(String good) {
        int time = Util.getRandom(7500, 30000);
        if (pensioner)
            Util.sleep((int) (time * 1.5));
        else
            Util.sleep(time);
        System.out.println(this + " chose " + good);
    }

    @Override
    public void goOut() {
        if (pensioner)
            Util.sleep((int) (15 * 1.5));
        else Util.sleep(15);
        System.out.println(this + " go out from Market");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        int time = Util.getRandom(1500, 3000);
        if (pensioner)
            Util.sleep((int) (time * 1.5));
        else
            Util.sleep(time);
        System.out.println(this + " took the basket");
    }

    @Override
    public void putGoodsToBasket(String good) {
        int time = Util.getRandom(1500, 3000);
        if (!pensioner)
            Util.sleep(time);
        else
            Util.sleep((int) (time * 1.5));
        System.out.println(this + " put " + good + " to basket");

    }
}
