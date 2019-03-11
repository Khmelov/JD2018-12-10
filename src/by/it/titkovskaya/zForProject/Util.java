package by.it.titkovskaya.zForProject;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Util {

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return null;
        }
        Object oUser = session.getAttribute("user");
        if (oUser == null) {
            return null;
        } else {
            return (User) oUser;
        }
    }

    static Account findAccount(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return null;
        }
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return null;
        } else {
            return account;
        }
    }

    static String findLanguage(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return null;
        }
        String language = (String) session.getAttribute("language");
        if (language == null) {
            return null;
        } else {
            return language;
        }
    }

    public static String getHash(User user) {
        String key = user.getEmail() + user.getLogin() + user.getPassword() + "this is salt";
        return DigestUtils.md5Hex(key);
    }

    static void setCookie(HttpServletRequest req, Cookie cookie) {
        HttpServletResponse resp = (HttpServletResponse) req.getAttribute("resp");
        resp.addCookie(cookie);
    }

    static void loadImage(HttpServletRequest req, String filename) throws IOException, ServletException {
        Part reqPart = req.getPart("fileimg");
        if (reqPart.getSize() > 0) {
            try (InputStream fileimg = reqPart.getInputStream();
                 FileOutputStream fileout = new FileOutputStream(
                         req.getServletContext().getRealPath(filename))) {
                byte[] bytes = new byte[Math.min(128 * 1024, fileimg.available())];
                while (fileimg.available() > 0) {
                    int size = fileimg.read(bytes);
                    fileout.write(bytes, 0, size);
                }
            }
        }
    }
}
