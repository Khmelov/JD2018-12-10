package by.it.skosirskiy.jd03_04.java;

import javax.servlet.http.HttpServletRequest;


public class CmdIndex implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) {
        return Action.INDEX;
    }
}
