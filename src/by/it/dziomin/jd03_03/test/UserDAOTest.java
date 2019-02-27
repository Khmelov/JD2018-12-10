package by.it.dziomin.jd03_03.test;

import by.it.dziomin.jd03_03.Dao.RoleDAO;
import by.it.dziomin.jd03_03.Dao.UserDAO;
import by.it.dziomin.jd03_03.beans.Role;
import by.it.dziomin.jd03_03.beans.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class UserDAOTest {

    private UserDAO dao = UserDAO.getInstance();
    private static RoleDAO roleDAO = RoleDAO.getInstance();

    @BeforeClass
    public static void prepareData(){
        Role role = new Role();
        role.setName("test_role");
        role.setId(998L);

        roleDAO.create(role);
    }

    @AfterClass
    public static void deleteTestData(){
        Role role = new Role();
        role.setName("test_role");
        role.setId(998L);
        roleDAO.delete(role);
    }

    @Test()
    public void _1testCreate(){
        User user = new User();
        user.setName("test_user");
        user.setId(999L);
        user.setPassport("test_passport");
        user.setPhone("test_phone");
        user.setRoleId(998L);

        User created = dao.create(user);
        User result = dao.getById(999L);
        assert "test_user".equals(result.getName());
    }

    @Test
    public void _2testGetAll(){
        List<User> result = dao.getAll();
        assert !result.isEmpty();
    }

    @Test
    public void _3testUpdate(){
        User user = new User();
        user.setId(999L);
        user.setName("test_user_updated");
        user.setRoleId(998L);

        dao.update(user);
        User result = dao.getById(999L);
        assert "test_user_updated".equals(result.getName());
    }

    @Test
    public void _4testDelete(){
        User user = new User();
        user.setId(999L);
        dao.delete(user);
        User result = dao.getById(999L);
        assert (result == null);
    }

}
