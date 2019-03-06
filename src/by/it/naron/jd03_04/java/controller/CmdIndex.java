package by.it.naron.jd03_04.java.controller;

import by.it.naron.jd03_04.java.beans.*;
import by.it.naron.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        List<Goods_flower> goodsFlowerList = Dao.getDao().goodsFlower.getAll();
     //   List<Ad> ads = Dao.getDao().Gds.getAll();
        req.setAttribute("goods_flower",goodsFlowerList);
        return Action.INDEX;
    }
}
