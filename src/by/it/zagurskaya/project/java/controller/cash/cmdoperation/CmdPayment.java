package by.it.zagurskaya.project.java.controller.cash.cmdoperation;

import by.it.zagurskaya.project.java.controller.*;
import by.it.zagurskaya.project.java.controller.cash.*;
import by.it.zagurskaya.project.java.controller.cash.cmdcurrency.*;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.*;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment.*;
import by.it.zagurskaya.project.java.controller.cash.cmdreport.*;
import by.it.zagurskaya.project.java.dao.SprOperationsDao;

import javax.servlet.http.HttpServletRequest;

public class CmdPayment implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
//        if (Form.isPost(req)) {
//            String login = Form.getString(req, "id", "[0-9]{1,}");
////            String password = Form.getString(req, "password");
////            Long roleId = Long.parseLong(Form.getString(req, "roleId"));
////            User user = new User(0, login, password, roleId);
////            UserDao userDao = new UserDao();
//            if (SprOperationsDao.create(user)) {
//                Action.INDEX.setPATH("/");
//                return Action.INDEX;
//            }
//        }
        Action.PAYMENT.setPATH("/cash/operation/");
        return Action.PAYMENT;
    }
}
