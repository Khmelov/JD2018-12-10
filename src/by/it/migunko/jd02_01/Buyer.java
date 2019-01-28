package by.it.migunko.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket{
    Buyer(int number) {
        super("Buyer №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        System.out.flush();
        Dispatcher.counterBuyer--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to Market");
    }

    @Override
    public void takeBasket() {
        int timeout = Util.getRandom(100,200);
        Util.sleep(timeout);
        System.out.println(this + " took a baсket");
    }
    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this+" chose goods "+timeout+" milliseconds");
        Util.sleep(timeout);
        System.out.println(this+" chose goods");
    }
    @Override
    public void putGoodsToBasket() {
        int timeout = Util.getRandom(100,200);
        Util.sleep(timeout);
        int goodsCount = Util.getRandom(1,4);
        System.out.println(this + " put " + goodsCount+
                " goods into the baсket: " + Util.goods(goodsCount));
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
