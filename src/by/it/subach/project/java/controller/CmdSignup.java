package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if(Form.isPost(req)){
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email");
            DAO dao = DAO.getInstance();
            User user = new User();
            user.setRole_id(2);
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            if(dao.user.create(user)){
                return Action.LOGIN;
            }
        }
        return Action.SIGNUP;
    }
}
