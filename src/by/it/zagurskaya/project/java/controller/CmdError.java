package by.it.zagurskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Action.ERROR.setPATH("/");
        return Action.ERROR;
    }
}
