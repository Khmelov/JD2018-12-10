package by.it.zagurskaya.project.java.controller;


import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password","[a-zA-Z0-9_-]{5,}");
            Long roleId = Long.parseLong(Form.getString(req, "roleId","[0-9]{1,}"));
            User user = new User(0, login, password, roleId);
            UserDao userDao = new UserDao();
            if (userDao.create(user)) {
                Action.INDEX.setPATH("/");
                return Action.INDEX;
            }
        }
        Action.SIGNUP.setPATH("/");
        return Action.SIGNUP;
    }
}
