package by.it.a_khmelev.project07.java.filters;

import by.it.a_khmelev.project07.java.beans.User;
import by.it.a_khmelev.project07.java.controller.Util;
import by.it.a_khmelev.project07.java.dao.Dao;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Auth implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String login = null;
        String hash = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    login = cookie.getValue();
                }
                if (cookie.getName().equals("hash")) {
                    hash = cookie.getValue();
                }
            }
        if (login != null && hash != null) {
            String where = String.format(" WHERE login='%s'", login);
            try {
                List<User> users = Dao.getDao().user.getAll(where);
                if (users.size() > 0) {
                    User user = users.get(0);
                    String hash1 = Util.getHash(user);
                    if (hash1.equals(hash)) {
                        req.getSession().setAttribute("user", user);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
