package by.it.zagurskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import by.it.zagurskaya.project.java.controller.cash.*;
import by.it.zagurskaya.project.java.controller.cash.cmdcurrency.*;
import by.it.zagurskaya.project.java.controller.cash.cmdmain.CmdCloseDuties;
import by.it.zagurskaya.project.java.controller.cash.cmdmain.CmdOpenDuties;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.*;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment.*;
import by.it.zagurskaya.project.java.controller.cash.cmdreport.*;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    LOGIN(new CmdLogin()),
    RESETDB(new CmdResetDB()),
    LOGOUT(new CmdLogout()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),

    //    CASH
    MAIN(new CmdMain()),
    CURRENCY(new CmdCurrency()),
    OPERATION(new CmdOperation()),
    REPORT(new CmdReport()),
    EXIT(new CmdExit()),

    //    CASH/CMDMAIN
    CLOSEDUTIES(new CmdCloseDuties()),
    OPENDUTIES(new CmdOpenDuties()),

    //    CASH / CMDCURRENCY
    ALLCURRENCY(new CmdAllCurrency()),
    RATECB(new CmdRateCB()),
    RATENB(new CmdRateNB()),

    //    CASH / CMDOPERATION
    PAYMENT(new CmdPayment()),
    BALANCE(new CmdBalance()),
    USEROPERATIONS(new CmdUseroperations()),

//   CASH / CMDOPERATION/CMDPAYMENT
    SELECTPAYMENT(new CmdSelectPayment()),

    //    CASH / CMDREPORT
    SPRREPORTS(new CmdSprReports()),
    ENTRIES(new CmdEntries());

    Cmd command;
    String PATH = "";

    Action(String PATH) {
        this.PATH = PATH;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    Action(Cmd command) {
        this.command = command;
    }

    String getJsp() {
        return PATH + name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req) {
        String command = req.getParameter("command").toUpperCase();
        try {
            return Action.valueOf(command);
        } catch (Exception e) {
            return Action.ERROR;
        }
    }


}
