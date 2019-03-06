package by.it.a_khmelev.jd03_03;

import by.it.a_khmelev.jd03_03.beans.Ad;
import by.it.a_khmelev.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
        Ad ad = new Ad();
        ad.setUsers_id(3);
        Timestamp timestamp=Timestamp.valueOf("2019-02-20 11:45:00");
        ad.setData(timestamp);
        if (dao.ad.create(ad))
            System.out.println("CREATEGOODSFLOWER OK: " + ad);
        ad.setDescription("TestAd");
        if (dao.ad.update(ad))
            System.out.println("UPDATE OK: " + ad);
        ad = dao.ad.read(ad.getId());
        if (ad != null)
            System.out.println("READ OK: " + ad);
//        if (dao.Gds.delete(Gds))
//            System.out.println("DELETE OK: " + Gds);

    }
}
