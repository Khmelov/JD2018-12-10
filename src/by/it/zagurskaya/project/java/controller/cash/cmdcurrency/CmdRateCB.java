package by.it.zagurskaya.project.java.controller.cash.cmdcurrency;

import by.it.zagurskaya.project.java.beans.RateCB;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.dao.RateCBDao;

import javax.servlet.http.HttpServletRequest;

public class CmdRateCB implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        RateCBDao rateCBDao = new RateCBDao();
        req.setAttribute("RateCB", rateCBDao.getAll());
        Action.RATECB.setPATH("/cash/currency/");
        return Action.RATECB;
    }
}
