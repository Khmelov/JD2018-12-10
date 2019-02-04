package by.it.lyakhova.jd02_02;

public interface IBuyer {

    void enterToMarket(); // вошел в магазин
    void chooseGoods();//выбрал товар (от 0,5 до 2 секунд)
    void goOut();//отправился на выход (мгновенно)
    void goToQueue();
}
