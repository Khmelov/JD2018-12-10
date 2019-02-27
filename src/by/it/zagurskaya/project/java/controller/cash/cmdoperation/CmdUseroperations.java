package by.it.zagurskaya.project.java.controller.cash.cmdoperation;

import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;

import javax.servlet.http.HttpServletRequest;

public class CmdUseroperations implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Action.USEROPERATIONS.setPATH("/cash/operation/");
        return Action.USEROPERATIONS;
    }
}
