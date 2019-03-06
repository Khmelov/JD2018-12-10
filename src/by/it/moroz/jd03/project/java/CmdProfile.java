package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Order;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) throws Exception {

        if(Form.isPost(req)){
            req.getSession().invalidate();
            return Action.INDEX;
        }
        User user = Util.findUser(req);
        if(user!=null){
            req.getSession().setMaxInactiveInterval(30);
            String where=String.format(" WHERE `users_id`='%d'",user.getId());
            List<Order> orders = DAO.getDao().order.getAll(where);
            req.setAttribute("orders",orders);
            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
