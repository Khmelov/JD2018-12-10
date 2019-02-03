package by.it.skosirskiy.jd02_02_old;

public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void goOut(); //отправился на выход(мгновенно)
    void goToQueue();
}