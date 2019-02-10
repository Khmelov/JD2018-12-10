package by.it.subach.jd02_01;

class Dispatcher {

    static final int K_SPEED = 2;
    static volatile int counterBuyer = 0;

    static synchronized int getCounterBuyer(){
        return counterBuyer;
    }
}