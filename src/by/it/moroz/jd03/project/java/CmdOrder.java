package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Order;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdOrder implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if(user==null)
            return Action.LOGIN;
        if(Form.isPost(req)){
            req.getSession().setMaxInactiveInterval(30);
            Order order = new Order();
            order.setMenu_id(Form.getLong(req, "dish"));
            order.setCount(Form.getInt(req, "count"));
            order.setCheck(2.0*Form.getDouble(req, "price"));
            order.setUsers_id(user.getId());
            if(DAO.getDao().order.create(order))
                return Action.PROFILE;
        }
        return Action.ORDER;
    }
}
