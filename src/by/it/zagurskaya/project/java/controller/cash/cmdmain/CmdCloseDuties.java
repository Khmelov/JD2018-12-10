package by.it.zagurskaya.project.java.controller.cash.cmdmain;

import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmdCloseDuties implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        Duties duties = Util.findDuties(req);

        if (user != null) {
            if (duties != null) {
                DutiesDao dutiesDao = new DutiesDao();
                duties.setIsClose(true);
                dutiesDao.update(duties);
                String massageCloseDuties = "close duties";
                req.setAttribute("massageCloseDuties", massageCloseDuties);
            }
        }
        Action.CLOSEDUTIES.setPATH("/cash/main/");
        return Action.CLOSEDUTIES;
    }
}
