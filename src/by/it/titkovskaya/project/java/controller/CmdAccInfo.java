package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.Payment;
import by.it.titkovskaya.project.java.beans.Replenishment;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CmdAccInfo implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            Dao dao = Dao.getDao();
            getAccInfo(req, user, dao);
            if (Form.isGet(req) && req.getParameter("accInfoButton") != null) {
                long id = Form.getLong(req, "id");
                Account account = dao.account.read(id);
                String whereAccId = String.format(" WHERE `accounts_id`='%d'", account.getId());

                List<Replenishment> replenishments = dao.replenishment.getAll(whereAccId);
                req.setAttribute("replenishments", replenishments);

                List<Payment> payments = dao.payment.getAll(whereAccId);
                req.setAttribute("payments", payments);

                String messageInfo = "ACCOUNT №" + " " + account.getNumber() + " " + "STATEMENT";
                req.setAttribute("messageInfo", messageInfo);
                String replenInfo = "Replenishments";
                req.setAttribute("replenInfo", replenInfo);
                String paymentInfo = "Payments / Money transfers";
                req.setAttribute("paymentInfo", paymentInfo);
            }
            return Action.ACCINFO;
        }
        return Action.LOGIN;
    }

    void getAccInfo(HttpServletRequest req, User user, Dao dao) throws SQLException {
        long start = 0;
        if (req.getParameter("start") != null)
            start = Form.getLong(req, "start");
        String where = String.format(" WHERE `users_id`='%d' LIMIT %d,3", user.getId(), start);
        List<Account> accounts = dao.account.getAll(where);
        if (accounts.size() < 1) {
            String message1 = "NOTIFICATION: You have no open accounts.";
            req.setAttribute("message1", message1);
        }
        req.setAttribute("accounts", accounts);
        HashMap<Long, Double> balances = AccBalance.getAccBalances(accounts);
        req.setAttribute("balances", balances);
        where = String.format(" WHERE `users_id`='%d'", user.getId());
        int accCount = dao.account.getAll(where).size();
        req.setAttribute("accCount", accCount);
    }
}
