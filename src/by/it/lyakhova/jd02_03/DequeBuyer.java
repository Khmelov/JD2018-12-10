package by.it.lyakhova.jd02_03;

import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeBuyer {

    //private static BlockingDeque<Buyer> q = new LinkedBlockingDeque<>();
    private static BlockingDeque<Buyer> p = new LinkedBlockingDeque<>(30);


    static void add(Buyer buyer, boolean pensioneer){
        //if (pensioneer)
        try {
            p.put(buyer);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //else q.addLast(buyer);

    }

    static Buyer takeBuyer(){
        Buyer buyer = null;

        Iterator<Buyer> iterator = p.iterator();
        boolean pensNone = true;
        while (iterator.hasNext()){
            buyer = iterator.next();
            if (buyer.getName().contains("pensioneer")) {
                pensNone = false;
                iterator.remove();
                //System.out.println(p);
                break;
            }
        }
        if (pensNone) {
            buyer = p.pollFirst();
            //System.out.println(p);
        }

        return buyer;
    }

   /* static Buyer pollPensioneer(){
        return p.pollFirst();
    }

    static Buyer pollBuyer(){
        //the same to  - synchronized(DequeBuyer.class)
        return q.pollFirst();
    }

    static int getSizeBuyer(){
        return q.size();
    }*/

    static int getSizePensioneer(){
        return p.size();
    }

    /*static int getFullQueue(){
        return (q.size()+p.size());
    }
    */



}
