package by.it.skosirskiy.project.java.controller;

import by.it.skosirskiy.project.java.beans.User;
import by.it.skosirskiy.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {

        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            Dao dao = Dao.getDao();
            String where = String.format(
                    " WHERE `login`='%s' AND `password`='%s'",
                    login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                HttpSession session= req.getSession(true);
                User user = users.get(0);
                session.setAttribute("user",user);

                req.setAttribute("user",user);


            }

        }

        return Action.LOGIN;
    }
}
