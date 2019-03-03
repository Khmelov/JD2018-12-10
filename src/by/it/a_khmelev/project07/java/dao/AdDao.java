package by.it.a_khmelev.project07.java.dao;

import by.it.a_khmelev.project07.java.beans.Ad;

public class AdDao extends UniversalDao<Ad> {
    public AdDao() {
        super(Ad.class, "ads");
    }
}
