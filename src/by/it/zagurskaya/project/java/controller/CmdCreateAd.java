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
//            Ad Gds = new Ad();
//            Gds.setDescription(Form.getString(req, "description"));
//            Gds.setAddress(Form.getString(req, "address"));
//            Gds.setFloor(Form.getInt(req, "floor"));
//            Gds.setFloors(Form.getInt(req, "floors"));
//            Gds.setRooms(Form.getInt(req, "rooms"));
//            Gds.setPrice(Form.getDouble(req, "price"));
//            Gds.setArea(Form.getInt(req, "area"));
//            Timestamp date = Timestamp.valueOf(LocalDateTime.now());
//            Gds.setData(date);
//            Gds.setUser_id(3);
//            if (Dao.getDao().Gds.create(Gds))
//                return Action.INDEX;
//
//        }
//        return Action.CREATEGDS;
        return Action.INDEX;
    }
}
