package by.it.skosirskiy.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public enum Action{

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    PROFILE(new CmdProfile()),
    CREATEREQUEST(new CmdCreateRequest()),
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

            String command= req.getParameter("command").toUpperCase();
        System.out.println(command);
        try {
            return Action.valueOf(command);

        }
        catch (Exception e){return Action.ERROR;}


    }

}
