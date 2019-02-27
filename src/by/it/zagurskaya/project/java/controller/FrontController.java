package by.it.zagurskaya.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    // HttpServletRequest req - информация о запросе - т.е. ВХОД - то что читать
    // HttpServletResponse resp - информация о результате - т.е. ВЫХОД - то куда писать
    private void process(HttpServletRequest req, HttpServletResponse resp) {
        Action action = Action.define(req);
        try {
            Action nextAction = action.command.execute(req);
            if (nextAction == action) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(action.getJsp());
                requestDispatcher.forward(req, resp);
            } else {
                resp.sendRedirect("do?command=" + nextAction.name().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
