package by.it.zagurskaya.project.java.controller.cash.cmdreport;

import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;

import javax.servlet.http.HttpServletRequest;

public class CmdSprReports implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Action.SPRREPORTS.setPATH("/cash/report/");
        return Action.SPRREPORTS;
    }
}
