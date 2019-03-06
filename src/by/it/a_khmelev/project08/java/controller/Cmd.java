package by.it.a_khmelev.project08.java.controller;

import javax.servlet.http.HttpServletRequest;

public interface Cmd {
    Action execute(HttpServletRequest req) throws Exception;
}
