package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdSighUp implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email");
            String address = Form.getString(req, "address");
            String name = Form.getString(req, "name");
            String surname = Form.getString(req, "surname");
            int number = Form.getInt(req, "numberphone");
            User user = new User(0, login, password, email, address, name, surname, number, 2);
            DAO dao = DAO.getDao();
            if (dao.user.create(user)) {
                return Action.INDEX;
            }
        }
        return Action.SIGNUP;
    }
}
