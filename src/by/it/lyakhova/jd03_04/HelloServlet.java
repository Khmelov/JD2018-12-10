package by.it.lyakhova.jd03_04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println(" <head>");
        writer.println("  <title>Hello title</title>");
        writer.println(" </head>");
        writer.println(" <body>");
        writer.println("  <p>Hello servlet!!!! <hr></p>");
        writer.println(" </body>");
        writer.println("<html>");
        writer.flush();
    }
}
