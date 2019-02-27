package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdLogin implements Cmd{

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if(Form.isPost(req)){
            String login = Form.getString(req, "login", "a-zA-z0-9_-");
            String password = Form.getString(req, "password", "a-zA-z0-9_-");
            DAO dao = DAO.getInstance();
            String where = String.format(" WHERE `login`='%s' AND `password`='%s'",
                    login, password);
            List<User> users = dao.user.getAll(where);
            if(users.size() > 0){
                User user = users.get(0);
                req.setAttribute("user", user);
            }
        }
        return Action.LOGIN;
    }
}
