package by.it.zagurskaya.project.java.controller.cash;

import javax.servlet.http.HttpServletRequest;

import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.dao.DutiesDao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CmdMain implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd 00:00:00.000");
        Date now = new Date();
        String today = dateFormat.format(now);
        if (user != null) {
            String where = String.format(" WHERE `userId`='%d' AND `timestamp` >= '%s' AND `isClose`=0", user.getId(), today);
            DutiesDao dutiesDao = new DutiesDao();
            List<Duties> duties = dutiesDao.getAll(where);

            if (duties.size() != 0) {
                req.setAttribute("duties", duties);
            } else {
                String notduties = "Not open duties";
                req.setAttribute("notduties", notduties);
            }
        }
        Action.MAIN.setPATH("/cash/");
        return Action.MAIN;
    }
}
