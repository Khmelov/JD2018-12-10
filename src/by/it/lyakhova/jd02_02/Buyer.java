package by.it.lyakhova.jd02_02;


import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioneer;
    protected Map<String, Integer> goodsBasket = new HashMap<>();
    Goods goods = new Goods();


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
        System.out.flush();
    }

    @Override
    public void goToQueue() {
        synchronized (Dispatcher.CONSOL){
            System.out.println(this + " go to the Queue");
        }

        DequeBuyer.add(this, pensioneer);
        synchronized (this){
            try {
                this.wait();//this.wait();
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
            synchronized (Dispatcher.CONSOL) {
                System.out.println(this + " chose goods " + timeout + " milliseconds");
            }
            Util.sleep(timeout);
            synchronized (Dispatcher.CONSOL) {
                System.out.println(this + " chose goods");
            }
            putGoodsToBasket();
        }

    }

    @Override
    public void goOut(){
        Dispatcher.buyerComplete();
        synchronized (Dispatcher.CONSOL) {
            System.out.println(this + " go out from Market");
        }
    }

    @Override
    public void enterToMarket() {
        synchronized (Dispatcher.CONSOL) {
            System.out.println(this + " enter to Market");
        }

    }

    @Override
    public void takeBasket() {
        synchronized (Dispatcher.CONSOL) {
            System.out.println(this + " took the basket");
        }

    }

    @Override
    public void putGoodsToBasket() {
        int timeOperation = Util.getRandom(100, 200)*(pensioneer ? 3/2 : 1);
        Util.sleep(timeOperation);
        String name = Goods.getGoods().getKey();
        Integer value = Goods.getGoods().getValue();
        this.goodsBasket.put(name, value);
        synchronized (Dispatcher.CONSOL) {
            System.out.println(this + " put " + name + " price " + value + " to the Basket " + timeOperation + " milliseconds");
        }

    }
}
