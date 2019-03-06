package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Menu;
import by.it.moroz.jd03.project.java.beans.Order;
import by.it.moroz.jd03.project.java.beans.Role;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.MenuDAO;
import by.it.moroz.jd03.project.java.dao.OrderDAO;
import by.it.moroz.jd03.project.java.dao.RoleDAO;
import by.it.moroz.jd03.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdReset implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            MenuDAO menu = new MenuDAO();
            OrderDAO order = new OrderDAO();
            RoleDAO role = new RoleDAO();
            UserDAO user = new UserDAO();

            List<Order> orders = order.getAll();
            for (Order oneOrder : orders) {
                order.delete(oneOrder);
            }
            List<User> users = user.getAll();
            for (User oneUser : users) {
                user.delete(oneUser);
            }
            List<Menu> menuAll = menu.getAll();
            for (Menu oneMenu : menuAll) {
                menu.delete(oneMenu);
            }
            List<Role> roles = role.getAll();
            for (Role oneRole : roles) {
                role.delete(oneRole);
            }
            return Action.INDEX;
        }
        return Action.RESET;
    }
}
