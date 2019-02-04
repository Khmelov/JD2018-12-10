package by.it.yarmolenka.jd02_03;


interface IUseBasket {
    void takeBasket() throws InterruptedException;                                    //взял корзину
    void putGoodsToBasket(Goods goods, int listSize) throws InterruptedException;     //положил выбранный товар в корзину (goods - список товаров магазина)
}
