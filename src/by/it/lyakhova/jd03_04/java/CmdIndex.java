package by.it.lyakhova.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        return Action.INDEX;
    }
}
