package by.it.a_khmelev.project08.java.controller;

import by.it.a_khmelev.project08.java.beans.Role;
import by.it.a_khmelev.project08.java.dao.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class FrontController extends HttpServlet {


    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        try {
            List<Role> roles = Dao.getDao().role.getAll();
            servletContext.setAttribute("roles", roles);
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
        req.setAttribute("resp",resp);
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
            ShowException(req, resp, e);
        }

    }

    private void ShowException(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Action.ERROR.getJsp());
        StackTraceElement[] stackTrace = e.getStackTrace();
        String error = e.toString()+"<hr>"+
                Arrays.toString(stackTrace).replace(",", "<br>");
        req.setAttribute("error",error);
        requestDispatcher.forward(req, resp);
    }
}
