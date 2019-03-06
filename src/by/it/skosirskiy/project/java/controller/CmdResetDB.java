package by.it.skosirskiy.project.java.controller;

import by.it.skosirskiy.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdResetDB implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {
        Dao.getDao().reset();
        return Action.INDEX;
    }
}
