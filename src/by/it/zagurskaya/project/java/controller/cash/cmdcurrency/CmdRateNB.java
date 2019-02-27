package by.it.zagurskaya.project.java.controller.cash.cmdcurrency;

import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.dao.RateNBDao;

import javax.servlet.http.HttpServletRequest;

public class CmdRateNB implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        RateNBDao rateCBDao = new RateNBDao();
        req.setAttribute("RateNB", rateCBDao.getAll());
        Action.RATENB.setPATH("/cash/currency/");
        return Action.RATENB;
    }
}
