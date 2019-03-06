package by.it.a_khmelev.project08.java.controller;

import by.it.a_khmelev.project08.java.beans.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oUser = session.getAttribute("user");
        if (oUser == null) {
            return null;
        } else {
            return (User) oUser;
        }
    }

    public static String getHash(User user) {
        //хеш можно получить проще, на занятии
        //я что-то перемудрил.
        String key = user.getEmail() + user.getLogin() + user.getPassword() + "это как бы соль";
        return DigestUtils.md5Hex(key);
    }

    static void setCookie(HttpServletRequest req, Cookie cookie) {
        HttpServletResponse resp =
                (HttpServletResponse) req.getAttribute("resp");
        resp.addCookie(cookie);
    }

    static void loadImage(HttpServletRequest req, String filename) throws IOException, ServletException {
        Part reqPart = req.getPart("fileimg");
        if (reqPart.getSize() > 0) {
            try (
                    InputStream fileimg = reqPart.getInputStream();
                    OutputStream fileout = new FileOutputStream(
                            req.getServletContext().getRealPath(filename)
                    );
            ) {
                byte[] bytes = new byte[
                        Math.min(128 * 1024, fileimg.available())
                        ];
                while (fileimg.available() > 0) {
                    int size = fileimg.read(bytes);
                    fileout.write(bytes, 0, size);
                }

            }
        }
    }
}
