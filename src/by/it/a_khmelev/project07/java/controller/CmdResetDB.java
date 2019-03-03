package by.it.a_khmelev.project07.java.controller;

import by.it.a_khmelev.project07.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao.getDao().reset();
        return Action.INDEX;
    }
}
