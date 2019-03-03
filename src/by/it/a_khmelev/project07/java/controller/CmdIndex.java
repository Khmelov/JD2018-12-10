package by.it.a_khmelev.project07.java.controller;

import by.it.a_khmelev.project07.java.beans.Ad;
import by.it.a_khmelev.project07.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        List<Ad> ads = Dao.getDao().ad.getAll();
        req.setAttribute("ads",ads);
        return Action.INDEX;
    }
}
