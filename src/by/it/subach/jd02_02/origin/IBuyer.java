package by.it.subach.jd02_02.origin;

public interface IBuyer {
    void enterToMarket();    //вошел в магазин (мгновенно)
    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)
    void goToQueue();
    void goOut();            //отправился на выход(мгновенно)
}
