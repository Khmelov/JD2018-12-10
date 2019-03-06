package by.it.naron.jd03_03.TestDao;


import by.it.naron.jd03_03.beans.Roles;
import by.it.naron.jd03_03.dao.Dao;

import java.sql.SQLException;

public class TestRolesDao {


    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
        //    Ad Gds = new Ad();
        Roles roles = new Roles(12,"testRole");
        //    Gds.setUser_id(3);
        //    Timestamp timestamp=Timestamp.valueOf("2019-02-20 11:45:00");
        //    Gds.setData(timestamp);
        //   users.setId(3);
        if (dao.roles.create( roles ))
            System.out.println("CREATEGOODSFLOWER OK: " + roles);
        roles.setRole("TestRl");
        if (dao.roles.update(roles))
            System.out.println("UPDATE OK: " + roles);
        roles = dao.roles.read(roles.getId());
        if (roles != null)
            System.out.println("READ OK: " + roles);
        if (dao.roles.delete(roles))
            System.out.println("DELETE OK: " + roles);

    }
}
