package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception{
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[A-z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email");
            String name = Form.getString(req, "name");
            User user = new User(0, login, password, email, name, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user)){
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
            }
        }
        return Action.SIGNUP;
    }
}
