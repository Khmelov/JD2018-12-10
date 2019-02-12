package by.it.lyakhova.jd02_03;


import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioneer;
    @SuppressWarnings("WeakerAccess")
    protected Map<String, Integer> goodsBasket = new HashMap<>();

    boolean iWait;

    Object getMonitor(){
        return this;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goOut();
                                            //System.out.println(Dispatcher.getCounterBuyerInShop() + " in shop SAXParser");
        System.out.flush();
    }

    @Override
    public void goToQueue() {

        try {
            Dispatcher.semaphoreConsol.acquire();
            System.out.println(this + " go to the Queue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Dispatcher.semaphoreConsol.release();
        }

        synchronized (this){
            DequeBuyer.add(this, pensioneer);
            iWait = true;
            while (iWait)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public Buyer(int number, boolean pensioneer) {
        super(pensioneer ? "Buyer №" + number + " pensioneer" : "Buyer №" + number);
        this.pensioneer = pensioneer;
        Dispatcher.newBuyer();
        //System.out.println(Dispatcher.getCounterBuyerInShop() + "  in shop Buyer");


    }

    @Override
    public void chooseGoods(){
        int countGoods = Util.getRandom(1, 4);
        synchronized (Dispatcher.CONSOL) {
            System.out.println(this + " need " + countGoods + " goods");
        }
        for (int i = 0; i < countGoods; i++) {
            int timeout = Util.getRandom(500, 2000)*(pensioneer ? 3/2 : 1); //*10;
            try {
                Dispatcher.semaphoreConsol.acquire();
                System.out.println(this + " chose goods " + timeout + " milliseconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                Dispatcher.semaphoreConsol.release();
            }

            Util.sleep(timeout);
            try {
                Dispatcher.semaphoreConsol.acquire();
                System.out.println(this + " chose goods");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                Dispatcher.semaphoreConsol.release();
            }
            putGoodsToBasket();
        }
    }

    @Override
    public void goOut(){
        Dispatcher.buyerComplete();
        Basket.returnBasket();
        try {
            Dispatcher.semaphoreConsol.acquire();
            System.out.println(this + " go out from Market");
            //System.out.println(Basket.getSizeBasket() + " number of Basket in the shop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Dispatcher.semaphoreConsol.release();
        }

    }

    @Override
    public void enterToMarket() {
        try {
            Dispatcher.semaphoreConsol.acquire();
            System.out.println(this + " enter to Market");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Dispatcher.semaphoreConsol.release();
        }

    }

    @Override
    public void takeBasket() {
        Basket.getBasket(this);
        try {
            Dispatcher.semaphoreConsol.acquire();
            System.out.println(this + " took the basket");
            //System.out.println(Basket.getSizeBasket() + " number of Basket in the shop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Dispatcher.semaphoreConsol.release();
        }

    }

    @Override
    public void putGoodsToBasket() {
        int timeOperation = Util.getRandom(100, 200)*(pensioneer ? 3/2 : 1);
        Util.sleep(timeOperation);
        String name = Goods.getGoods().getKey();
        Integer value = Goods.getGoods().getValue();
        this.goodsBasket.put(name, value);
        try {
            Dispatcher.semaphoreConsol.acquire();
            System.out.println(this + " put " + name + " price " + value + " to the Basket " + timeOperation + " milliseconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Dispatcher.semaphoreConsol.release();
        }

    }
}
