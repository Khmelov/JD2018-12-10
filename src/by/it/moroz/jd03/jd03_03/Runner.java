package by.it.moroz.jd03.jd03_03;

import by.it.moroz.jd03.jd03_03.beans.Order;
import by.it.moroz.jd03.jd03_03.beans.User;
import by.it.moroz.jd03.jd03_03.dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws SQLException {

        DAO dao = DAO.getDao();
        User user = new User(0, "TestLogin", "TestPassword", "TestEmail",
                "TestAddress", "TestName", "TestSurname", 111111111, 2);
        List<User> users = dao.user.getAll();
        System.out.println("======================\nList of users:\n======================");
        for (User oneUser : users) {
            System.out.println("This is "+dao.role.read(oneUser.getRoles_id()).getRole());
            System.out.println(oneUser);
        }
        if(dao.user.create(user))
            System.out.println("User create:");
        System.out.println("This is "+dao.role.read(user.getRoles_id()).getRole());
        System.out.println(dao.user.read(user.getId()));
        user.setSurname("AnotherSurname");
        if(dao.user.update(user))
            System.out.println("User update:");
        System.out.println("This is "+dao.role.read(user.getRoles_id()).getRole());
        System.out.println(dao.user.read(user.getId()));
        dao.user.delete(user);
        List<User> secondUsers = dao.user.getAll();
        System.out.println("======================\nList of users:\n======================");
        for (User secondUser : secondUsers) {
            System.out.println("This is "+dao.role.read(secondUser.getRoles_id()).getRole());
            System.out.println(secondUser);
        }



    }

}
