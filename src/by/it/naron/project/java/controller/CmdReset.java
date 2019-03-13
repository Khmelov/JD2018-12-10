package by.it.naron.project.java.controller;

import by.it.naron.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdReset implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        Dao.restoreDB();
        return Action.INDEX;
    }
}
