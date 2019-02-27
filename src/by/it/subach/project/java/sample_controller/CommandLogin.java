package by.it.subach.project.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

import static by.it.subach.project.java.sample_controller.Actions.LOGIN;

class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //DO SOMETHING;
        //USE DAO
        //&ETC
        return LOGIN.jsp;
    }
}