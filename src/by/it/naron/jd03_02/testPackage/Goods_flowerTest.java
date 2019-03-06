package by.it.naron.jd03_02.testPackage;

import by.it.naron.jd03_02.beans.Goods_flower;
import by.it.naron.jd03_02.crudOperations.Goods_flowerCrud;

import java.sql.SQLException;

public class Goods_flowerTest {

    public static void main(String[] args) throws SQLException {

//        String s = String.format("sdsdsd %s,+ %d,+ %10.3f","строка",20,3.2);
//        System.out.println(s);

//        Gds goods_flower = new Gds(3,"somename",
//                "somecolour",5.0);
//
//        try {
////проверка BeanCRUD для пользователей
//            Goods_flowerCrud goodsFlowerCrud = new Goods_flowerCrud();
//
//            //чтение
//            System.out.println("read: "+goodsFlowerCrud.read(goods_flower.getId()));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        Goods_flower goods_flower = new Goods_flower(
                1,"somename","somecolour",5,3.5);
        Goods_flowerCrud goods_flowerCrud = new Goods_flowerCrud();

       if (goods_flowerCrud.create(goods_flower))
            System.out.println("CREATEGOODSFLOWER OK: " + goods_flower);
        goods_flower.setName("Testgoods_flowerUpdate");
        if (goods_flowerCrud.update(goods_flower))
            System.out.println("UPDATE OK: " + goods_flower);
        goods_flower = goods_flowerCrud.read(goods_flower.getId());
        if (goods_flower != null)
            System.out.println("READ OK: " + goods_flower);
        if (goods_flowerCrud.delete(goods_flower))
            System.out.println("DELETE OK: " + goods_flower);















    }

}
