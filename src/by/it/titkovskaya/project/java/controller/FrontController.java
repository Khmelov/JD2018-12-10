package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.AccountStatus;
import by.it.titkovskaya.project.java.beans.Role;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class FrontController extends HttpServlet {

    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        try {
            Dao dao = Dao.getDao();
            List<Role> roles = dao.role.getAll();
            servletContext.setAttribute("roles", roles);
            List<AccountStatus> accstatuses = dao.status.getAll();
            servletContext.setAttribute("accstatuses", accstatuses);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache");
        req.setAttribute("resp", resp);
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
            showException(req, resp, e);
        }
    }

    private void showException(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Action.ERROR.getJsp());
        StackTraceElement[] stackTrace = e.getStackTrace();
        String error = e.toString() + "<hr>" + Arrays.toString(stackTrace).replace("," , "<br>");
        req.setAttribute("error", error);
        requestDispatcher.forward(req, resp);
    }
}