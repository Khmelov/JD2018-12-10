package by.it.zagurskaya.project.java.controller.cash.cmdmain;

import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.DutiesDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CmdOpenDuties implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000");
        Date date = new Date();
        String today = dateFormat.format(date);
        if (user != null) {
            List<Duties> OpenDuties = new ArrayList<>();
            OpenDuties.addAll(OpenDutiesUserToday(user, today));

            if (OpenDuties.size() == 0) {
                Timestamp now = new Timestamp(System.currentTimeMillis());
                String todayNow = dateFormat.format(now);
                Duties userNewDuties = new Duties(0, user.getId(), now, MaxNumberDutiesToday(user, today), false);
                DutiesDao dutiesDao = new DutiesDao();
//                dutiesDao.create(userNewDuties);
                if (dutiesDao.create(userNewDuties)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("duties", userNewDuties);
                    req.setAttribute("duties", userNewDuties);
                    String massageOpenDuties = "open new duties";
                    req.setAttribute("massageOpenDuties", massageOpenDuties);
                }
            } else {
                String massageOpenDuties = "there is open duties";
                req.setAttribute("massageOpenDuties", massageOpenDuties);
                req.setAttribute("duties", OpenDuties);
            }
        }
//        Action.MAIN.setPATH("/cash/");
//        return Action.MAIN;
        Action.OPENDUTIES.setPATH("/cash/main/");
        return Action.OPENDUTIES;
    }

    static Integer MaxNumberDutiesToday(User user, String today) throws SQLException {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd 00:00:00.000");
//        Date date = new Date();
//        String today = dateFormat.format(date);
        DutiesDao dutiesDao = new DutiesDao();
        Integer numberDuties = 0;
        if (user != null) {
            String where = String.format(" WHERE `userId`='%d' AND `timestamp` >= '%s' AND `isClose`= 1", user.getId(), today);
            List<Duties> closeDutiesList = dutiesDao.getAll(where);
            if (closeDutiesList.size() != 0) {
                List<Integer> closeDutiesNumberList = new ArrayList<Integer>();
                for (Duties duties : closeDutiesList) {
                    closeDutiesNumberList.add(duties.getNumber());
                }
                numberDuties = Integer.parseInt(Collections.max(closeDutiesNumberList).toString()) + 1;
            } else {
                numberDuties = 1;
            }
        }
        return numberDuties;
    }

    static List<Duties> OpenDutiesUserToday(User user, String today) throws SQLException {
        String where = String.format(" WHERE `userId`='%d' AND `timestamp` >= '%s' AND `isClose`=0", user.getId(), today);
        DutiesDao dutiesDao = new DutiesDao();
        List<Duties> duties = dutiesDao.getAll(where);
        return duties;
    }
}
