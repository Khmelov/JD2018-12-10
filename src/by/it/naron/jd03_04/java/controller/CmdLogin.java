package by.it.naron.jd03_04.java.controller;

import by.it.naron.jd03_04.java.beans.Users;
import by.it.naron.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password","[a-zA-Z0-9_-]{5,}");
            Dao dao = Dao.getDao();
            String where = String.format(Locale.ENGLISH,
                    " WHERE `login`='%s' AND `password`='%s'",
                    login, password);
            List<Users> users = dao.users.getAll(where);
            if (users.size() > 0) {
                Users user = users.get(0);
                req.setAttribute("users",user);
            }
        }

        return Action.LOGIN;

    }
}
