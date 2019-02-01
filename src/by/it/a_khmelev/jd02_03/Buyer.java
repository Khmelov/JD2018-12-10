package by.it.a_khmelev.jd02_03;

public class Buyer extends Thread implements IBuyer {

    Object getMonitor() {
        return this;
    }

    boolean iWait;

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        System.out.flush();
        Dispatcher.buyerComplete();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this + " chose goods " + timeout + " milliseconds");
        Util.sleep(timeout);
        System.out.println(this + " chose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to Queue");
        synchronized (this) {
            //ошибка №1 есть шанс, что кассир заберет покупателя из очереди
            //и отправит notify до this.wait();
            DequeBuyer.add(this);
            //ошибку №2 смотрите в методе add(this)

            //ошибка №3 кроме того notifyAll может прислать не только кассир
            //это стоит контролировать
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
    public void goOut() {
        System.out.println(this + " go out from market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
