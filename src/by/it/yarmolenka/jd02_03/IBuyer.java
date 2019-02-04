package by.it.yarmolenka.jd02_03;

public interface IBuyer {
    void enterToMarket() throws InterruptedException;      //вошёл в магазин (мгновенно)
    void chooseGoods() throws InterruptedException;        //выбрал товар (от 0,5 до 2 секунд)
    void goOut() throws InterruptedException;              //отправился на выход (мгновенно)
}
