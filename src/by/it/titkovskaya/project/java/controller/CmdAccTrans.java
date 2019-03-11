package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdAccTrans implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            Dao dao = Dao.getDao();
            CmdAccInfo info = new CmdAccInfo();
            info.getAccInfo(req, user, dao);
            if (Form.isPost(req)) {
                long id = Form.getLong(req, "id");
                Account account = dao.account.read(id);
                if (account.getAccount_status_id() != 2) {
                    HttpSession reqSession = req.getSession();
                    reqSession.setAttribute("account", account);
                    if (req.getParameter("replenish") != null) {
                        return Action.REPLENISH;
                    } else if (req.getParameter("payment") != null) {
                        return Action.PAYMENT;
                    }
                } else {
                    String message = "NOTIFICATION: Operation failed. Account" + " № "
                            + account.getNumber() + " " + "is locked. To perform this operation unlock " +
                            "previously current account or choose another one.";
                    req.setAttribute("message", message);
                }
            }
            return Action.ACCTRANS;
        }
        return Action.LOGIN;
    }
}
