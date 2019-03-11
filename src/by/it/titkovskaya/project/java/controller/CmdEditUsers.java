package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUsers implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        User currentUser = Util.findUser(req);
        if (currentUser == null)
            return Action.LOGIN;
        else if (currentUser.getRoles_id() != 1)
            return Action.PROFILE;
        else if (Form.isPost(req)) {
            long id = Form.getLong(req, "id");
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email");
            String name = Form.getString(req, "name");
            long roles_id = Form.getLong(req, "roles_id");
            User user = new User(id, login, password, email, name, roles_id);
            if (req.getParameter("update") != null){
                if (dao.user.update(user)){
                    String message = "NOTIFICATION: Operation completed successfully. Data of user with ID"
                            + user.getId() + " " + "is updated.";
                    req.setAttribute("message", message);
                    if (currentUser.getId()==user.getId())
                        req.getSession().setAttribute("user", user);
                } else {
                    String message = "NOTIFICATION: Operation failed.";
                    req.setAttribute("message", message);
                }
            }
            else if (req.getParameter("delete")!=null){
                if (dao.user.delete(user)){
                    String message = "NOTIFICATION: Operation completed successfully. Personal account " +
                            "of user with ID" + user.getId() + " " + "is deleted.";
                    req.setAttribute("message", message);
                    if (user.getId()==currentUser.getId())
                        return Action.LOGOUT;
                } else {
                    String message = "NOTIFICATION: Operation failed.";
                    req.setAttribute("message", message);
                }
            }
        }
        long start = 0;
        if (req.getParameter("start") != null)
            start= Form.getLong(req, "start");
        String where = String.format(" LIMIT %d,5", start);
        List<User> users = dao.user.getAll(where);
        req.setAttribute("users", users);
        int usersCount = dao.user.getAll().size();
        req.setAttribute("usersCount", usersCount);

        return Action.EDITUSERS;
    }
}
