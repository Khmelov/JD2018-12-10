package by.it.skosirskiy.project.java.controller;



import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface Cmd {

    Action execute(HttpServletRequest req) throws SiteException, SQLException;

}
