package by.it.a_khmelev.project07.java.dao;

import java.sql.SQLException;

public class Dao {

    private volatile static Dao dao;

    public RoleDao role;
    public UserDao user;
    public AdDao ad;

    public void reset() throws SQLException {
        Reset.main(new String[0]);
    }

    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        ad=new AdDao();
    }

    public static Dao getDao(){
        if (dao==null) {
            synchronized (Dao.class){
                if (dao==null)
                    dao=new Dao();
            }
        }
        return dao;
    }
}
