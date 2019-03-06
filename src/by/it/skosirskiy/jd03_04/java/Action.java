package by.it.skosirskiy.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public enum Action{

    INDEX(new CmdIndex()), ERROR(new CmdError()),SIGNUP(new CmdSignup());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

    String getJsp(){
        return "/"+name().toLowerCase()+".jsp";
    }

    static Action define(HttpServletRequest req){

            String command= req.getParameter("command").toUpperCase();
        try {
            return Action.valueOf(command);

        }
        catch (Exception e){return Action.ERROR;}


    }

}
