package by.it.dziomin.jd03_03.test;

import by.it.dziomin.jd03_03.Dao.RoleDAO;
import by.it.dziomin.jd03_03.beans.Role;
import org.junit.Test;

import java.util.List;

public class RoleDAOTest {

    private RoleDAO dao = RoleDAO.getInstance();

    @Test()
    public void _1testCreate(){
        Role role = new Role();
        role.setName("test_role");
        role.setId(999L);

        Role created = dao.create(role);
        Role result = dao.getById(999L);
        assert "test_role".equals(result.getName());
    }

    @Test
    public void _2testGetAll(){
        List<Role> result = dao.getAll();
        assert !result.isEmpty();
    }

    @Test
    public void _3testUpdate(){
        Role role = new Role();
        role.setId(999L);
        role.setName("test_role_updated");

        dao.update(role);
        Role result = dao.getById(999L);
        assert "test_role_updated".equals(result.getName());
    }

    @Test
    public void _4testDelete(){
        Role role = new Role();
        role.setId(999L);
        dao.delete(role);
        Role result = dao.getById(999L);
        assert (result == null);
    }

}
