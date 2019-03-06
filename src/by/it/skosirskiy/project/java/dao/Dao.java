package by.it.skosirskiy.project.java.dao;

import java.sql.SQLException;

public class Dao {

    private volatile static Dao dao;

    public RoleDao role;
    public UserDao user;
    public RequestDao request;
    public StatusDao status;
    public AddressDao address;

    private Dao(){

        role = new RoleDao();
        user= new UserDao();
        request = new RequestDao();
        status = new StatusDao();
        address = new AddressDao();

    }
    public void reset() throws SQLException {
        Reset.main(new String[0]);
    }

    public static Dao getDao(){
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                    dao.user = new UserDao();
                    dao.role = new RoleDao();
                    dao.request = new RequestDao();
                    dao.status = new StatusDao();
                    dao.address= new AddressDao();
                }
            }
        }
        return dao;
    }

}
