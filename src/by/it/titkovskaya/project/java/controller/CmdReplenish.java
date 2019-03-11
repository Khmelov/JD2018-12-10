package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.Replenishment;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CmdReplenish implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        Account account = Util.findAccount(req);
        if (user != null & account != null) {
            Dao dao = Dao.getDao();
            req.setAttribute("account", account);
            if (Form.isPost(req)) {
                Replenishment replenishment = new Replenishment();
                Timestamp date = Timestamp.valueOf(LocalDateTime.now());
                replenishment.setDate(date);
                replenishment.setAmount(Form.getDouble(req, "amount"));
                replenishment.setAccounts_id(account.getId());
                if (dao.replenishment.create(replenishment)) {
                    String message = "NOTIFICATION: Operation completed successfully Account" + " № "
                            + account.getNumber() + " " + "was replenished by" + " " + replenishment.getAmount()
                            + " " + account.getCurrency() + ".";
                    req.setAttribute("message", message);
                } else {
                    String message = "NOTIFICATION: Operation failed. Please, check the correctness of the entered data.";
                    req.setAttribute("message", message);
                }
            }
            return Action.REPLENISH;
        }
        return Action.LOGIN;
    }
}
