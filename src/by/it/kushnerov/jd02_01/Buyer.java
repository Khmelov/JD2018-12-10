package by.it.kushnerov.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioner = false;

    Buyer(int number) {
        super("Buyer №"+number);
        if (number % 4 == 0){
           pensioner = true;
           this.setName(this.getName() + " pensioner");
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        System.out.flush();
        Dispatcher.counterBuyer--;
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
        int amount = Util.getRandom(1,4);
        Random random = new Random();
        List<String> keys = new ArrayList<>(Goods.goods.keySet());
        String randomKey;
        StringBuilder sb = new StringBuilder();
        System.out.println(this+" puts goods to the basket "+timeout);
        for (int i = 0; i < amount; i++) {
            randomKey = keys.get(random.nextInt(keys.size()));
            sb.append(randomKey).append(" ");
        }
        Util.sleep((pensioner) ? (int)(timeout*1.5) : timeout);
        System.out.println(this+" put "+sb.toString()+" to the basket");
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
