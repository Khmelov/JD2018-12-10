package by.it.zagurskaya.project.java.controller;

//import by.it.zagurskaya.project.java.beans.Ad;
//import by.it.zagurskaya.project.java.dao.Dao;

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
//        if (Form.isPost(req)) {
//            Ad ad = new Ad();
//            ad.setDescription(Form.getString(req, "description"));
//            ad.setAddress(Form.getString(req, "address"));
//            ad.setFloor(Form.getInt(req, "floor"));
//            ad.setFloors(Form.getInt(req, "floors"));
//            ad.setRooms(Form.getInt(req, "rooms"));
//            ad.setPrice(Form.getDouble(req, "price"));
//            ad.setArea(Form.getInt(req, "area"));
//            Timestamp date = Timestamp.valueOf(LocalDateTime.now());
//            ad.setData(date);
//            ad.setUsers_id(3);
//            if (Dao.getDao().ad.create(ad))
//                return Action.INDEX;
//
//        }
//        return Action.CREATEAD;
        return Action.INDEX;
    }
}
