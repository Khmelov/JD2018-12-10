package by.it.moroz.jd03.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
