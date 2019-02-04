package by.it.migunko.jd02_01;
import java.util.HashMap;
import java.util.Map;
public class Buyer extends Thread implements IBuyer, IUseBacket{

    private Map<String, Double> goods= new HashMap<>();
    private Map<String, Double> goodBuyers= new HashMap<>();

    private void goodsMarket(){
        goods.put("хлеб", 1.15);
        goods.put("молоко", 0.94);
        goods.put("сметана", 1.35);
        goods.put("гречнева крупа", 0.90);
        goods.put("торт", 13.63);
        goods.put("кофе", 9.85);
        goods.put("печенье", 7.60);
    }


    Buyer(int number) {
        super("Покупатель №" + number);
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }
    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }
    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        System.out.println(this + " взял корзину");
    }
    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout);
        int count= Util.rnd(1,4);
        goodsMarket();
        for (int i = 0; i < count; i++) {
            int index= Util.rnd(0,goods.size()-1);
            for (String good:goods.keySet()) {
                if(index==0) {
                    Double goodPrice=goods.get(good);
                    putGoodsToBacket(good,goodPrice);
                    break;
                }
                index--;
            }
        }
    }
    @Override
    public void putGoodsToBacket(String good,Double goodPrice) {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        goodBuyers.put(good,goodPrice);
        System.out.println(this+" положил в корзину "+ good +":"+ goodPrice+ "р");
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }

}
