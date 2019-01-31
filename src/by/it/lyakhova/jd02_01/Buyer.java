package by.it.lyakhova.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioneer;

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
        System.out.flush();
        Dispatcher.counterBuyer--;

    }

    @Override
    public String toString() {
        return this.getName();
    }

    public Buyer(int number, boolean pensioneer) {
        super(pensioneer ? "Buyer №" + number + " pensioneer" : "Buyer №" + number);
        this.pensioneer = pensioneer;


    }

    @Override
    public void chooseGoods(){
        int countGoods = Util.getRandom(1, 4);
        System.out.println(this + " need " + countGoods + " goods");
        for (int i = 0; i < countGoods; i++) {
            int timeout = Util.getRandom(500, 2000)*(pensioneer ? 3/2 : 1)*5;
            System.out.println(this + " chose goods " + timeout + " milliseconds");
            Util.sleep(timeout);
            System.out.println(this + " chose goods");
            putGoodsToBasket();
        }

    }

    @Override
    public void goOut(){
        System.out.println(this + " go out from Market");
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");

    }

    @Override
    public void takeBasket() {
        System.out.println(this + " took the basket");

    }

    @Override
    public void putGoodsToBasket() {
        Goods goods = new Goods();
        int timeOperation = Util.getRandom(100, 200)*(pensioneer ? 3/2 : 1);
        Util.sleep(timeOperation);
        System.out.println(this + goods.getGoods() + "to the Basket " + timeOperation + " milliseconds");

    }
}
