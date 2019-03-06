package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Menu;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Menu> menu = DAO.getDao().menu.getAll();
        req.setAttribute("menu", menu);
        User user = Util.findUser(req);
        if (user != null)
            req.getSession().setMaxInactiveInterval(30);
        return Action.INDEX;
    }
}
