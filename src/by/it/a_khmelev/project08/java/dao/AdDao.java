package by.it.a_khmelev.project08.java.dao;

import by.it.a_khmelev.project08.java.beans.Ad;

public class AdDao extends UniversalDao<Ad> {
    public AdDao() {
        super(Ad.class, "ads");
    }
}
