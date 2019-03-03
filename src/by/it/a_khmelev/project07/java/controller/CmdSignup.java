package by.it.a_khmelev.project07.java.controller;


import by.it.a_khmelev.project07.java.beans.User;
import by.it.a_khmelev.project07.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email");
            User user = new User(0, login, email, password, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user)) {
                return Action.INDEX;
            }
        }
        return Action.SIGNUP;
    }
}
