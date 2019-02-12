package by.it.kushnerov.jd02_02;


public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioner = false;

    Object getMonitor(){
        return this;
    }

    Buyer(int number) {
        super("Buyer №"+number);
        if (number % 4 == 0){
           pensioner = true;
           this.setName(this.getName() + " pensioner");
        }
        Dispatcher.newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        System.out.flush();
        Dispatcher.buyerComplete();
    }


    @Override
    public void enterToMarket() {
        System.out.println(this+" enter the Market");
    }

    @Override
    public void takeBasket(){
        int timeout = Util.getRandom(100,200);
        System.out.println(this+" take basket "+timeout);
        Util.sleep((pensioner) ? (int)(timeout*1.5) : timeout);
        System.out.println(this+"took basket");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this+" choose goods "+timeout);
        Util.sleep((pensioner) ? (int)(timeout*1.5) : timeout);
        System.out.println(this+" chose goods");
    }

    @Override
    public void putGoodsToBasket(){
        int timeout = Util.getRandom(100,200);
        Goods g = new Goods();
        StringBuilder sb = new StringBuilder();
        sb.append(g.chooseRandom());
        Util.sleep((pensioner) ? (int)(timeout*1.5) : timeout);
        System.out.println(this+" put to the basket: "+sb.toString());
    }

    @Override
    public void goToQueue() {
        System.out.println(this+" go to Queue");
        DequeBuyer.add(this);
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
