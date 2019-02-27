package by.it.lyakhova.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public interface Cmd {
    Action execute(HttpServletRequest request) throws Exception;
}
