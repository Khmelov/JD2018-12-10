package by.it.moroz.jd02_03;

import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private Semaphore semaphore = new Semaphore(20); //семафор для входа покупателей в торговый зал
    private Semaphore semaphoreBasket = new Semaphore(50); //семафор на количество корзин в магазине

    private Printer printer = new Printer();

    Object getMonitor() {
        return this;
    }

    Buyer(int num) {
        super("Buyer №" + num);
        Util.newBuyer();
    }

    private boolean pensioner;

    void setPensioner(boolean value) {
        this.pensioner = value;
    }

    private Basket basket = new Basket();

    @Override
    public void run() {
        enterToMarket(); //входит в магазин
        takeBasket(); //берет корзину
        try {
            semaphore.acquire(); //получает разрешение на вход в зал
            int count = Util.getRandom(1, 4);
            for (int i = 0; i < count; i++) {
                String good = GoodsInMarket.choseRandomGood(GoodsInMarket.goods); //рандомный товар
                chooseGoods(good); //выбирает товары
                putGoodsToBasket(good); //кладет выбранные товары в корзину
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        goToQueue(); //идет в очередь
        goOut(); //выходит из магазина
        System.out.flush();
        Util.buyerComplete();
    }
    //метод для вывода чека кассиром для каждого покупателя
    void takeCheck(String whichCashier) {
        int sum = 0;
        System.out.println(whichCashier+"*****************************");
        for (Map.Entry<String, Integer> pair : basket.basket.entrySet()) {
            System.out.printf(whichCashier+"%-15s ------- %5d\n", pair.getKey(), pair.getValue());
            sum += pair.getValue();
        }
        Util.moreProceeds(sum);
        System.out.println(whichCashier+"=============================");
        System.out.printf(whichCashier+"%-15s ------- %5d\n", "Total", sum);
        System.out.println(whichCashier+"=============================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+
                "Market's proceeds: "+Util.getProceeds());
    }

    @Override
    public void enterToMarket() {
        if (pensioner)
            Util.sleep(30);
        else Util.sleep(15);
        try {
            printer.semaphore.acquire();
            System.out.println(this + " enter to Market");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
        }
    }

    @Override
    public void chooseGoods(String good) {
        int time = Util.getRandom(7500, 30000);
        if (pensioner)
            Util.sleep((int) (time * 1.5));
        else
            Util.sleep(time);
        try {
            printer.semaphore.acquire();
            System.out.println(this + " chose " + good);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
        }
    }

    @Override
    public void goToQueue() {
        try {
            printer.semaphore.acquire();
            System.out.println(this + " go to queue");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
        }
        if (pensioner)
            DequeBuyers.add(DequeBuyers.pensionerDeque, this);
        else
            DequeBuyers.add(DequeBuyers.buyerDeque, this);
        synchronized (this) {
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
            Util.sleep(30);
        else Util.sleep(15);
        try{
            printer.semaphore.acquire();
            System.out.println(this + " go out from Market");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
        }
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
            try {
                semaphoreBasket.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphoreBasket.release();
            }
        try {
            printer.semaphore.acquire();
            System.out.println(this + " took the basket");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
        }
    }

    @Override
    public void putGoodsToBasket(String good) {
        int time = Util.getRandom(1500, 3000);
        if (!pensioner)
            Util.sleep(time);
        else
            Util.sleep((int) (time * 1.5));
        try {
            printer.semaphore.acquire();
            System.out.println(this + " put " + good + " to basket");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            printer.semaphore.release();
        }
        basket.putGoodInBasket(basket.basket, good, GoodsInMarket.getPrice(GoodsInMarket.goods, good));
    }
}
