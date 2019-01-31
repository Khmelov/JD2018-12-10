package by.it.yarmolenka.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    Basket basket = new Basket();     //у каждого покупателя создаётся экземпляр корзины
    boolean retired = false;     //поле, помечающее пенсионеров
    private int buyerNumber;     //номер покупателя

    //конструктор по номеру
    Buyer(int number) {
        super("buyer №" + number);
        this.buyerNumber = number;
        Dispatcher.newBuyer();
        if (Utils.getRandom(1, 4) == 1) {
            this.retired = true;
            this.setName(this.getName() + "(retired)");
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        Goods goods = new Goods();
        int priceListSize = goods.getPriceListSize();
        int quantity = Utils.getRandom(1, 4);
        for (int i = 0; i < quantity; i++) {
            chooseGoods();
            putGoodsToBasket(goods, priceListSize);
        }
        goToQueue();
        goOut();
        Dispatcher.buyerLeaved(this);
    }

    //метод для кастования buyer'a к object'у
    static Object getMonitor(Buyer buyer) {
        return buyer;
    }

    //геттер для номера покупателя
    int getBuyerNumber() {
        return buyerNumber;
    }

    //покупатель отправляется в очередь
    private void goToQueue() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " went to the Queue");
        }
        BuyerQueue.putToQueue(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enterToMarket() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " entered the market");
        }
    }

    @Override
    public void chooseGoods() {
        int timeout = Utils.getRandom(500, 2000);
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " is choosing goods " + timeout + " milliseconds");
        }
        Utils.sleep(retired ? (int) (timeout * 1.5) : timeout);
    }

    @Override
    public void goOut() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " exited the market");
        }
    }

    @Override
    public void takeBasket() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " took basket");
        }
        int timeToTakeBasket = Utils.getRandom(100, 200);
        Utils.sleep(retired ? (int) (timeToTakeBasket * 1.5) : timeToTakeBasket);
    }

    @Override
    public void putGoodsToBasket(Goods list_of_goods, int priceListSize) {
        String goods = Utils.getRandomGoods(priceListSize);
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " took " + goods);
        }
        int timeToTakeGoods = Utils.getRandom(100, 200);
        Utils.sleep(retired ? (int) (timeToTakeGoods * 1.5) : timeToTakeGoods);
        double price = list_of_goods.getPrice(goods);
        this.basket.goods.put(goods, price);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
