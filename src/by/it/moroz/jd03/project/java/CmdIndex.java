package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Order;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Order> orders = DAO.getDao().order.getAll();
        req.setAttribute("orders",orders);
        return Action.INDEX;
    }
}
