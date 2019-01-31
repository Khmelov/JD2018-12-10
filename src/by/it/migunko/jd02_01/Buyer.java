package by.it.migunko.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket{
    Buyer(int number){
        super("Customer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered to the market");
    }

    @Override
    public void takeBacket() {
        int timeout = Util.random(100,200);
        Util.sleep(timeout);
        System.out.println(this + "took a basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choosing goods");
        int timeout = Util.random(500,2000);
        Util.sleep(timeout);
        System.out.println(this + "made a choice");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.random(100,200);
        Util.sleep(timeout);
        int goodsCount = Util.random(1,4);
        System.out.println(this + "put " + goodsCount+
                " goods into the basket: " + Util.goods(goodsCount));
    }

    @Override
    public void goOut() {
        System.out.println(this + "went out");
    }

    @Override
    public String toString() {
        return getName() + ": ";
    }





}
