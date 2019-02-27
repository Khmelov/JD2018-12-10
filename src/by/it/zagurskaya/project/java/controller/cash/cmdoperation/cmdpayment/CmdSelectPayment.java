package by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment;

import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;

import javax.servlet.http.HttpServletRequest;

public class CmdSelectPayment implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Action.SELECTPAYMENT.setPATH("/cash/operation/payment/");
        return Action.SELECTPAYMENT;
    }
}
