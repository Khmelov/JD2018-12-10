package by.it.skosirskiy.project.java.controller;


import by.it.skosirskiy.project.java.beans.Status;
import by.it.skosirskiy.project.java.beans.User;
import by.it.skosirskiy.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;

public class Util {

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session==null)
            return null;
        Object oUser = session.getAttribute("user");
        if (oUser == null) {
            return null;
        } else {
            return (User) oUser;
        }
    }
    static List<Status> getStatuses(HttpServletRequest req) throws SQLException {
        return Dao.getDao().status.getAll("");

    }
}
