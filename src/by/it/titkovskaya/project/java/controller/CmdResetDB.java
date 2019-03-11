package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CmdResetDB implements Cmd{

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        dao.reset();
        User currentUser = Util.findUser(req);
        if (currentUser != null) {
            long id = currentUser.getId();
            if (dao.user.read(id) == null){
                req.getSession().invalidate();
                Cookie cookie = new Cookie("login", "none");
                Util.setCookie(req, cookie);
            }
        }
        return Action.INDEX;
    }
}
