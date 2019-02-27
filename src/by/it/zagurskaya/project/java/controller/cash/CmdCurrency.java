package by.it.zagurskaya.project.java.controller.cash;

import javax.servlet.http.HttpServletRequest;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Action;

public class CmdCurrency implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Action.CURRENCY.setPATH("/cash/");
        return Action.CURRENCY;
    }
}
