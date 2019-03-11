package by.it.titkovskaya.jd03.jd03_03.custom_DAO;

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
}
