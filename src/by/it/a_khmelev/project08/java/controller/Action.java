package by.it.a_khmelev.project08.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    LOGIN(new CmdLogin()),
    EDITUSERS(new CmdEditUsers()),
    LOGOUT(new CmdLogout()),
    PROFILE(new CmdProfile()),
    CREATEAD(new CmdCreateAd()),
    RESETDB(new CmdResetDB()),
    SIGNUP(new CmdSignup());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

    String getJsp(){
        return "/"+name().toLowerCase()+".jsp";
    }

    static Action define(HttpServletRequest req){
        try {
            String command = req.getParameter("command").toUpperCase();
            return Action.valueOf(command);
        }
        catch (Exception e){
            return Action.INDEX;
        }
    }


}
