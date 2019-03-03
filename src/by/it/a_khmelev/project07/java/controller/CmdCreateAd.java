package by.it.a_khmelev.project07.java.controller;

import by.it.a_khmelev.project07.java.beans.Ad;
import by.it.a_khmelev.project07.java.beans.User;
import by.it.a_khmelev.project07.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CmdCreateAd implements Cmd {

//    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf(now);
//        System.out.println(timestamp);
//    }

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user==null)
            return Action.LOGIN;
        if (Form.isPost(req) ) {
            Ad ad = new Ad();
            ad.setDescription(Form.getString(req, "description"));
            ad.setAddress(Form.getString(req, "address"));
            ad.setFloor(Form.getInt(req, "floor"));
            ad.setFloors(Form.getInt(req, "floors"));
            ad.setRooms(Form.getInt(req, "rooms"));
            ad.setPrice(Form.getDouble(req, "price"));
            ad.setArea(Form.getInt(req, "area"));
            Timestamp date = Timestamp.valueOf(LocalDateTime.now());
            ad.setData(date);
            //todo userid
            ad.setUsers_id(user.getId());
            if (Dao.getDao().ad.create(ad))
                return Action.PROFILE;

        }
        return Action.CREATEAD;
    }
}
