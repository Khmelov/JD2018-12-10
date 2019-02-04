package by.it.yarmolenka.jd02_03;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private String name;
    Basket basket = new Basket();
    boolean retired;

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            enterToMarket();
        takeBasket();
        Goods goods = new Goods();
        int priceListSize = goods.getPriceListSize();
        for (int i = 0; i < Utils.getRandom(1, 4); i++) {
            chooseGoods();
            putGoodsToBasket(goods, priceListSize);
        }
        goToQueue();
        goOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToQueue() throws InterruptedException {
        Dispatcher.semaphoreBuyers.release();
        Dispatcher.semaphoreConsole.acquire();
        System.out.println(this + " went to queue");
        Dispatcher.semaphoreConsole.release();
        BuyerQueue.putToQueue(this);
        try {
            Dispatcher.semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Buyer(int number) {
        Dispatcher.buyersCount.incrementAndGet();
        this.retired = Math.random() < 0.25;
        if (this.retired) this.name = "Buyer #" + number + "(retired)";
        else this.name = "Buyer #" + number;
    }

    @Override
    public void enterToMarket() throws InterruptedException {
        Dispatcher.semaphoreConsole.acquire();
        System.out.println(this + " entered the market");
        Dispatcher.semaphoreConsole.release();
    }

    @Override
    public void chooseGoods() throws InterruptedException {
        int time = Utils.getRandom(500, 2000);
        Utils.sleep(this.retired ? (int) (time * 1.5) : time);
        Dispatcher.semaphoreConsole.acquire();
            System.out.println(this + " is choosing goods");
        Dispatcher.semaphoreConsole.release();
    }

    @Override
    public void goOut() throws InterruptedException {
        Dispatcher.semaphoreBaskets.release();
        Dispatcher.buyersCount.decrementAndGet();
        Dispatcher.buyersComplete.incrementAndGet();
        Dispatcher.semaphoreConsole.acquire();
            System.out.println(this + " exited the market");
        Dispatcher.semaphoreConsole.release();
    }

    @Override
    public void takeBasket() throws InterruptedException {
        try {
            Dispatcher.semaphoreBaskets.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Dispatcher.semaphoreConsole.acquire();
            System.out.println(this + " took basket");
        Dispatcher.semaphoreConsole.release();
        int time = Utils.getRandom(100, 200);
        Utils.sleep(this.retired ? (int) (time * 1.5) : time);
        try {
            Dispatcher.semaphoreBuyers.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBasket(Goods listOfGoods, int listSize) throws InterruptedException {
        String goods = Utils.getRandomGoods(listSize);
        Dispatcher.semaphoreConsole.acquire();
            System.out.println(this + " took " + goods);
        Dispatcher.semaphoreConsole.release();
        int time = Utils.getRandom(100, 200);
        Utils.sleep(this.retired ? (int) (time * 1.5) : time);
        int price = listOfGoods.getPrice(goods);
        this.basket.goods.put(goods, price);
    }
}
