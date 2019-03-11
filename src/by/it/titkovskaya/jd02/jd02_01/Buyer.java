package by.it.titkovskaya.jd02.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioner = false;

    public Buyer(int number) {
        super("Buyer №" + number);
        if (Util.getRandom(1, 4) == 1) {
            pensioner = true;
            this.setName("Buyer №" + number + " (pensioner)");
            Dispatcher.pensionersCounter++;
        }
    }

    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        System.out.flush();
        Dispatcher.buyersCounter--;
    }

    @Override
    public void enterToMarket() {
        System.out.printf(" %-23s | %-35s | %-6s | %-11s | %-5s | %-10s\n"
                            , this, "entered the market", "", "", "", "");
    }

    @Override
    public void takeBasket() {
        int timeout = Util.getRandom(1000, 2000);
        timeout = pensioner ? (timeout * 3 / 2) : timeout;
        Util.sleep(timeout);
        System.out.printf(" %-23s | %-35s | %-6s | %-11.1f | %-5s | %-10s\n"
                            , this, "took a basket", "", (double) timeout / 1000, "", "");
        Dispatcher.totalTimeSpent += (double) timeout / 1000;
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(5000, 20000);
        timeout = pensioner ? (timeout * 3 / 2) : timeout;
        Util.sleep(timeout);
        System.out.printf(" %-23s | %-35s | %-6s | %-11.1f | %-5s | %-10s\n"
                            , this, "was choosing goods ", "", (double) timeout / 1000, "", "");
        Dispatcher.totalTimeSpent += (double) timeout / 1000;
    }

    @Override
    public void putGoodsToBasket() {
        int count = Util.getRandom(1, 4);
        for (int i = 0; i < count; i++) {
            int timeout = Util.getRandom(1000, 2000);
            timeout = pensioner ? (timeout * 3 / 2) : timeout;
            Util.sleep(timeout);
            String[] basket = Runner.entries.toArray()[Util.getRandom(0, Runner.entries.size() - 1)]
                                .toString().split("=");
            System.out.printf(" %-23s | %-35s | %-6s | %-11.1f | %-5s | %-10s\n"
                    , this, "put to the basket " + basket[0], basket[1] + "$", (double) timeout / 1000, "", "");
            Dispatcher.totalGoodsCounter++;
            Dispatcher.totalSumCounter += Double.parseDouble(basket[1]);
            Dispatcher.totalTimeSpent += (double) timeout / 1000;
        }
    }

    @Override
    public void goOut() {
        System.out.printf(" %-23s | %-35s | %-6s | %-11s | %-5s | %-18s  %-10s\n"
                            , this, "went out from the market", "", "", Runner.time
                            , Dispatcher.buyersCounter, Thread.activeCount() + " active threads");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

/*
            System.out.println(this + " put to the basket " + Runner.entries.toArray()[Util.getRandom(0,
                    Runner.entries.size() - 1)].toString().replace("=", " for ") + "$");

 */