package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdAccLock implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        User user = Util.findUser(req);
        if (user != null) {
            if (Form.isPost(req)) {
                long id = Form.getLong(req, "id");
                Account account = dao.account.read(id);
                req.setAttribute("account", account);
                if (req.getParameter("lock") != null) {
                    if (account.getAccount_status_id() != 2) {
                        account.setAccount_status_id(2);
                        if (dao.account.update(account)) {
                            String message = "NOTIFICATION: Operation completed successfully. " +
                                    "Account" + " № " + account.getNumber() + " " + "is locked.";
                            req.setAttribute("message", message);
                        }
                    } else {
                        String message = "NOTIFICATION: Operation failed. Account" + " № "
                                + account.getNumber() + " " + "has already been locked.";
                        req.setAttribute("message", message);
                    }
                } else if (req.getParameter("unlock") != null) {
                    if (account.getAccount_status_id() != 1) {
                        account.setUnlock_request(1);
                        if (dao.account.update(account)) {
                            String message = "NOTIFICATION: Request to unlock account" + " № "
                                    + account.getNumber() + " " + "accepted for processing. As soon as it is " +
                                    "completed you will see updated account status on pages of PERSONAL CABINET";
                            req.setAttribute("message", message);
                        }
                    } else {
                        String message = "NOTIFICATION: Operation failed. Account" + " № "
                                + account.getNumber() + " " + "is not locked.";
                        req.setAttribute("message", message);
                    }
                }
            }
            CmdAccInfo info = new CmdAccInfo();
            info.getAccInfo(req, user, dao);
            return Action.ACCLOCK;
        }
        return Action.LOGIN;
    }
}
