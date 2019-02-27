package by.it.moroz.jd03.project.java;

import javax.servlet.http.HttpServletRequest;

public interface Cmd {

    Action execute(HttpServletRequest req) throws Exception;

}
