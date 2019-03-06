package by.it.skosirskiy.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public class CmdError implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}

