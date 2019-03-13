package by.it.naron.project.java.controller;

import by.it.naron.project.java.beans.User;
import by.it.naron.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();
            if (Util.isAdmin(req)) {
                if (Form.isPost(req)) {
                    long id = Form.getLong(req, "id");
                    String login = Form.getString(req, "login");
                    String password = Form.getString(req, "password");
                    String name = Form.getString(req, "name");
                    String dateOfBirth = Form.getString(req, "dateofbirth");
                    String email = Form.getString(req, "email");
                    String tel = Form.getString(req, "tel");
                    long roles_Id = Form.getLong(req, "roles_Id");
                    User user = new User(id, name, login, password, dateOfBirth, email, tel, roles_Id);
                    if (req.getParameter("Update") != null)
                        dao.user.update(user);
                    if (req.getParameter("Delete") != null)
                        dao.user.delete(user);
                }
                List<User> users = dao.user.getALL();
                req.setAttribute("users", users);
            } else return Action.INDEX;
        } else return Action.LOGIN;

        return Action.EDITUSERS;
    }
}
