package by.it.zagurskaya.project.java.controller.cash.cmdcurrency;

import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.dao.CurrencyDao;

import javax.servlet.http.HttpServletRequest;

public class CmdAllCurrency implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        CurrencyDao currencyDao = new CurrencyDao();
        req.setAttribute("AllCurrency", currencyDao.getAll());
        Action.ALLCURRENCY.setPATH("/cash/currency/");
        return Action.ALLCURRENCY;
    }
}
