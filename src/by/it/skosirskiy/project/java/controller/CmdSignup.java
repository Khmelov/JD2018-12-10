package by.it.skosirskiy.project.java.controller;


import by.it.skosirskiy.project.java.dao.Dao;
import by.it.skosirskiy.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SiteException {
        if(Form.isPost(req)){
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");

            System.out.println(login);
            String password = Form.getString(req,"password");
            String email = Form.getString(req,"email");
            User user= new User(0,login,password,email,1);
            Dao dao= Dao.getDao();
            if(dao.user.create(user)){
                return Action.LOGIN;
            }
        }
        return Action.SIGNUP;
    }

}

