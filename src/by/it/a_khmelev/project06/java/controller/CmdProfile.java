package by.it.a_khmelev.project06.java.controller;

import by.it.a_khmelev.project06.java.beans.Ad;
import by.it.a_khmelev.project06.java.beans.User;
import by.it.a_khmelev.project06.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            String where=String.format(" WHERE `users_id`='%d'",user.getId());
            List<Ad> ads = Dao.getDao().ad.getAll(where);
            req.setAttribute("ads",ads);
            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
