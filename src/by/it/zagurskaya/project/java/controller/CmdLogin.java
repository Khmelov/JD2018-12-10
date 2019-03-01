package by.it.zagurskaya.project.java.controller;


import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            String where = String.format(
                    " WHERE `login`='%s' AND `password`='%s'",
                    login, password);
            UserDao userDao = new UserDao();
            List<User> users = userDao.getAll(where);
            if (users.size() > 0) {
                User user = users.get(0);
                req.setAttribute("user", user);
            }
//            return Action.MAIN;
            Action.LOGIN.setPATH("/");
            return Action.LOGIN;
        }
        Action.LOGIN.setPATH("/");
        return Action.LOGIN;
    }
}
