package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String email = Form.getString(req, "email", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            DAO dao = DAO.getDao();
            String where = String.format(
                    " WHERE `email`='%s' AND `password`='%s'",
                    email, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                User user = users.get(0);
                req.setAttribute("user", user);
            }
        }
        return Action.LOGIN;
    }
}
