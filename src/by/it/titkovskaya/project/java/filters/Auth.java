package by.it.titkovskaya.project.java.filters;

import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.controller.Util;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.*;
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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Cookie[] cookies = req.getCookies();
        String login = null;
        String hash = null;
        for (Cookie cooky : cookies) {
            if (cooky.getName().equalsIgnoreCase("login")) {
                login = cooky.getValue();
            }
            if (cooky.getName().equalsIgnoreCase("hash")) {
                hash = cooky.getValue();
            }
        }
        if (login != null && hash != null) {
            String where = String.format(" WHERE login='%s'", login);
            try {
                List<User> users = Dao.getDao().user.getAll(where);
                if (users.size() > 0){
                    User user = users.get(0);
                    String hash1 = Util.getHash(user);
                    if (hash1.equals(hash)){
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
