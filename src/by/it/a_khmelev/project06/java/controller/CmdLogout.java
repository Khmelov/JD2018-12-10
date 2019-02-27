package by.it.a_khmelev.project06.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        req.getSession().invalidate();
        return Action.LOGIN;
    }
}
