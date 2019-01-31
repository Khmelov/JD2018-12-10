package by.it.yarmolenka.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket = new Basket();
    private boolean retired = false;

    Buyer(int number) {
        super("buyer №" + number);
        Dispatcher.totalBuyersCount++;
        Dispatcher.buyersCount++;
        if (Utils.getRandom(1, 4) == 1) {
            this.retired = true;
            Dispatcher.totalRetiredCount++;
            this.setName(this.getName() + "(retired)");
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int quantity = Utils.getRandom(1, 4);
        for (int i = 0; i < quantity; i++) {
            chooseGoods();
            putGoodsToBasket();
        }
        goOut();
        Dispatcher.buyersCount--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " entered the market");
        System.out.flush();
    }

    @Override
    public void chooseGoods() {
        int timeout = Utils.getRandom(500, 2000);
        System.out.println(this.getName() + " is choosing priceList " + timeout + " milliseconds");
        Utils.sleep(retired ? (int) (timeout * 1.5) : timeout);
        System.out.flush();
    }

    @Override
    public void goOut() {
        System.out.println(this.getName() + " exited the market");
        System.out.flush();
    }

    @Override
    public void takeBasket() {
        System.out.println(this.getName() + " took basket");
        int timeToTakeBasket = Utils.getRandom(100, 200);
        Utils.sleep(retired ? (int) (timeToTakeBasket * 1.5) : timeToTakeBasket);
        System.out.flush();
    }

    @Override
    public void putGoodsToBasket() {
        String goods = Utils.getRandomGoods();
        System.out.println(this.getName() + " took " + goods);
        System.out.flush();
        int timeToTakeGoods = Utils.getRandom(100, 200);
        Utils.sleep(retired ? (int) (timeToTakeGoods * 1.5) : timeToTakeGoods);
        double price = Goods.priceList.get(goods);
        this.basket.goods.put(goods, price);
    }
}
