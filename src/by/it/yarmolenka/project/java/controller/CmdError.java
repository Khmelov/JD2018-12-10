package by.it.yarmolenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
