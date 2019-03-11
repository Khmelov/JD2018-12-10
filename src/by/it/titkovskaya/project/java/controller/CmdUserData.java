package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdUserData implements Cmd{

    @Override
    public Action execute(HttpServletRequest req) throws Exception{
        User user = Util.findUser(req);
        if (user != null) {
            if (Form.isPost(req)) {
                if (req.getParameter("update") != null){
                    String login = Form.getString(req, "login");
                    String password = Form.getString(req, "password");
                    String email = Form.getString(req, "email");
                    String name = Form.getString(req, "name");
                    user = new User(user.getId(),login,password,email,name,user.getRoles_id());
                    if (Dao.getDao().user.update(user)){
                        Util.loadImage(req, "images/user" + user.getId());
                        String message = "NOTIFICATION: Operation completed successfully.";
                        req.setAttribute("message", message);
                    } else {
                        String message = "NOTIFICATION: Operation failed. Please, check the " +
                                "correctness of the entered data.";
                        req.setAttribute("message", message);
                    }
                } else if (req.getParameter("profileButton") != null){
                    return Action.PROFILE;
                }
            }
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            return Action.USERDATA;
        }
        return Action.LOGIN;
    }
}
