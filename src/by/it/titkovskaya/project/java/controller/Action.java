package by.it.titkovskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    PROFILE(new CmdProfile()),
    USERDATA(new CmdUserData()),
    CREATEACC(new CmdCreateAcc()),
    ACCINFO(new CmdAccInfo()),
    ACCTRANS(new CmdAccTrans()),
    PAYMENT(new CmdPayment()),
    REPLENISH(new CmdReplenish()),
    EDITUSERS(new CmdEditUsers()),
    EDITACC(new CmdEditAcc()),
    ACCLOCK(new CmdAccLock()),
    RESETDB(new CmdResetDB()),
    SIGNUP(new CmdSignup());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

    String getJsp() {
        return "/" + name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req) {
        try {
            String command = req.getParameter("command").toUpperCase();
            return Action.valueOf(command);
        } catch (Exception e) {
            return Action.INDEX;
        }
    }
}
