package by.it.subach.project.java.dao;

public class DAO {

    private volatile static DAO instance;

    public RoleDao role;
    public UserDao user;
    public CategoryDao category;
    public ProductDao product;
    public BlackListDao blackList;
    public CheckoutDao checkout;
    public OrderDao order;



    private DAO() {
        role = new RoleDao();
        user = new UserDao();
        category = new CategoryDao();
        product = new ProductDao();
        blackList = new BlackListDao();
        checkout = new CheckoutDao();
        order = new OrderDao();

    }

    public static DAO getInstance(){
        if(instance == null){
            synchronized (DAO.class){
                if(instance == null){
                    instance = new DAO();

//                    user = new UserDao();
//                    role = new RoleDao();
//                    category = new CategoryDao();

                }
            }
        }
        return instance;
    }
}
