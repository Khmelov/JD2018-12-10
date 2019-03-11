package by.it.titkovskaya.project.java.custom_DAO;

import java.sql.SQLException;

public class Dao {

    private volatile static Dao dao;

    public RoleDao role;
    public UserDao user;
    public AccountDao account;
    public AccountStatusDao status;
    public ReplenishmentDao replenishment;
    public PaymentDao payment;

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        account = new AccountDao();
        status = new AccountStatusDao();
        replenishment = new ReplenishmentDao();
        payment = new PaymentDao();
    }

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        }
        return dao;
    }

    public void reset() throws SQLException {
        Reset.resetDB();
    }
}
