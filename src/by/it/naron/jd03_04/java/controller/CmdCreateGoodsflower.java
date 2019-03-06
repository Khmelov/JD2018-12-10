package by.it.naron.jd03_04.java.controller;

import by.it.naron.jd03_04.java.beans.*;
import by.it.naron.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CmdCreateGoodsflower implements Cmd {

//    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf(now);
//        System.out.println(timestamp);
//    }

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            Goods_flower goodsFlower = new Goods_flower();
            goodsFlower.setName(Form.getString(req,"name","[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\\-!?,. ]{7,49}"));
            goodsFlower.setColour(Form.getString(req,"colour","[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\\-!?,. ]{7,49}"));
            goodsFlower.setSize(Form.getInt(req,"size"));
            goodsFlower.setPrice(Form.getDouble(req,"price"));
         //   Timestamp date = Timestamp.valueOf(LocalDateTime.now());
         //   goodsFlower.setDate_orders(date);
            //todo userid
         //   goodsFlower.setUser_id(2);
            if (Dao.getDao().goodsFlower.create(goodsFlower))
                return Action.INDEX;
        }
        return Action.CREATEGOODSFLOWER;
    }
}
