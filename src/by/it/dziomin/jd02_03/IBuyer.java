package by.it.dziomin.jd02_03;

import java.util.List;

public interface IBuyer {

    void enterToMarket(); //вошел в магазин (мгновенно)

    List<Good> chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)

    void goOut(); //отправился на выход(мгновенно)

}
