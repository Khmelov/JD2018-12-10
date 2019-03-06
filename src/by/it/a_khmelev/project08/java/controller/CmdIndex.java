package by.it.a_khmelev.project08.java.controller;

import by.it.a_khmelev.project08.java.beans.Ad;
import by.it.a_khmelev.project08.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        long start = 0;
        if (req.getParameter("start")!=null)
            start=Form.getLong(req, "start");

        List<Ad> ads = Dao.getDao().ad.getAll(" LIMIT "+start+",12");
        req.setAttribute("ads",ads);

        int adsCount=Dao.getDao().ad.getAll().size();
        req.setAttribute("adsCount",adsCount);
        return Action.INDEX;
    }
}
