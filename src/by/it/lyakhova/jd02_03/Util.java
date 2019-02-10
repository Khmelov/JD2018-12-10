package by.it.lyakhova.jd02_03;

public class Util {

    static int getRandom(int min, int max){
        return min+(int) (Math.random()*(max-min + 1));
    }

    private static int getRandom(int max){
        return getRandom(0, max);
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int setMaxPeople(int time){
        int sec = (time>60 ? time - 60*(time/60) : time);

       if  (sec<30){ return ((Dispatcher.getCounterBuyerInShop()<(sec+10)) ? getRandom(sec + 10 - Dispatcher.getCounterBuyerInShop()) : getRandom(2)); } //????????
       else {
           int count = 40 + (30 -sec);
           return (Dispatcher.getCounterBuyerInShop()<=count ? getRandom(2): -1);
        }
    }

}
