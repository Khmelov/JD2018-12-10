package by.it.zagurskaya.project.java.controller;

//import by.it.zagurskaya.project.java.beans.Ad;
//import by.it.zagurskaya.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
//        List<Ad> ads = Dao.getDao().Gds.getAll();
//        req.setAttribute("ads",ads);
        Action.INDEX.setPATH("/");
        return Action.INDEX;
    }
}
