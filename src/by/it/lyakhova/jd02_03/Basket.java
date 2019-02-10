package by.it.lyakhova.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Basket {

    private static BlockingDeque<Buyer> basket = new LinkedBlockingDeque<>(30);

   static void getBasket(Buyer buyer){
       try{
           basket.put(buyer);
       }catch (InterruptedException e){
           e.printStackTrace();
       }

   }

   static void returnBasket(){
       basket.poll();
   }

   static int getSizeBasket(){
       return basket.size();
   }
}
