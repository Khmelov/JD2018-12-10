package by.it.a_khmelev.project08.java.controller;

import by.it.a_khmelev.project08.java.beans.Ad;
import by.it.a_khmelev.project08.java.beans.User;
import by.it.a_khmelev.project08.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        User user = Util.findUser(req);
        if (user != null) {

            if (Form.isPost(req)) {
                String email = Form.getString(req, "email");
                String password = Form.getString(req, "password");
                user.setEmail(email);
                user.setPassword(password);
                dao.user.update(user);
            }


            long start = 0;
            if (req.getParameter("start") != null)
                start = Form.getLong(req, "start");

            String where = String.format(" WHERE `users_id`='%d' LIMIT %d,5", user.getId(), start);
            List<Ad> ads = dao.ad.getAll(where);
            req.setAttribute("ads", ads);

            where = String.format(" WHERE `users_id`='%d'", user.getId());
            int adsCount = dao.ad.getAll(where).size();
            req.setAttribute("adsCount", adsCount);

            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
