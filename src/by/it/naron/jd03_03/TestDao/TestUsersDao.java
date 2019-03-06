package by.it.naron.jd03_03.TestDao;

import by.it.naron.jd03_03.beans.Users;
import by.it.naron.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.sql.Timestamp;

public class TestUsersDao {

    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
    //    Ad Gds = new Ad();
        Users users = new Users(1,"testLogin","testPassword","testEmail",2);
    //    Gds.setUser_id(3);
    //    Timestamp timestamp=Timestamp.valueOf("2019-02-20 11:45:00");
    //    Gds.setData(timestamp);
     //   users.setId(3);
        if (dao.users.create( users ))
            System.out.println("CREATEGOODSFLOWER OK: " + users);
        users.setEmail("TestEm");
        if (dao.users.update(users))
            System.out.println("UPDATE OK: " + users);
        users = dao.users.read(users.getId());
        if (users != null)
            System.out.println("READ OK: " + users);
        if (dao.users.delete(users))
            System.out.println("DELETE OK: " + users);

    }
}
