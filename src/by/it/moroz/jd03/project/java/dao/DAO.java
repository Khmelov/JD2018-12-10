package by.it.moroz.jd03.project.java.dao;


public class DAO {

    private static volatile DAO dao;

    public RoleDAO role;
    public UserDAO user;
    public OrderDAO order;

    public DAO() {
        role = new RoleDAO();
        user = new UserDAO();
        order = new OrderDAO();
    }

    public static DAO getDao() {
        if(dao==null){
            synchronized (DAO.class){
                if(dao==null)
                    dao=new DAO();
            }
        }
        return dao;
    }

}
