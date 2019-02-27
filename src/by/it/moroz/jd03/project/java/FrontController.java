package by.it.moroz.jd03.project.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        Action action = Action.define(req);
        //resp.setHeader("Cache-Control", "no-store");
        try{
            Action nextAction = action.command.execute(req);
            if(nextAction!=action)
                resp.sendRedirect("do?command="+nextAction.name().toLowerCase());
            else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(action.getJSP());
                requestDispatcher.forward(req, resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
