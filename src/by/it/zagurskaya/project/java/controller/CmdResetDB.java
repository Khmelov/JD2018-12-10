package by.it.zagurskaya.project.java.controller;

import by.it.zagurskaya.project.java.InitDataBase;
import by.it.zagurskaya.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
//        Dao.getDao().reset();
        InitDataBase.main(new String[0]);
        Action.INDEX.setPATH("/");
        return Action.INDEX;
    }
}
