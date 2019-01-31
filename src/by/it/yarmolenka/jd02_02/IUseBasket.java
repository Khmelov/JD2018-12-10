package by.it.yarmolenka.jd02_02;

interface IUseBasket {
    void takeBasket();                      //взял корзину
    void putGoodsToBasket(Goods list_of_goods, int priceListSize);     //положил выбранный товар в корзину (goods - список товаров магазина)
}
