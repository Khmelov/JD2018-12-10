package by.it.dziomin.jd03_03.test;

import by.it.dziomin.jd03_03.Dao.CarDAO;
import by.it.dziomin.jd03_03.Dao.RentDAO;
import by.it.dziomin.jd03_03.Dao.RoleDAO;
import by.it.dziomin.jd03_03.Dao.UserDAO;
import by.it.dziomin.jd03_03.beans.Car;
import by.it.dziomin.jd03_03.beans.Rent;
import by.it.dziomin.jd03_03.beans.Role;
import by.it.dziomin.jd03_03.beans.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class RentDAOTest {

    private static UserDAO userDAO = UserDAO.getInstance();
    private static CarDAO carDAO = CarDAO.getInstance();
    private static RoleDAO roleDAO = RoleDAO.getInstance();
    private RentDAO rentDAO = RentDAO.getInstance();

    @BeforeClass
    public static void prepareData(){
        Car car = new Car();
        car.setName("test_car");
        car.setId(997L);
        carDAO.create(car);

        Role role = new Role();
        role.setName("test_role");
        role.setId(996L);
        roleDAO.create(role);

        User user = new User();
        user.setName("test_user");
        user.setId(998L);
        user.setRoleId(996L);
        userDAO.create(user);
    }

    @AfterClass
    public static void deleteTestData(){
        Car car = new Car();
        car.setId(997L);
        carDAO.delete(car);

        User user = new User();
        user.setId(998L);
        userDAO.delete(user);

        Role role = new Role();
        role.setId(996L);
        roleDAO.delete(role);
    }

    @Test()
    public void _1testCreate(){
        Rent rent = new Rent();
        rent.setDate(new Date());
        rent.setId(999L);
        rent.setPrice(22.34);
        rent.setOpen(true);
        rent.setUserId(998L);
        rent.setCarId(997L);

        Rent created = rentDAO.create(rent);
        Rent result = rentDAO.getById(999L);
        assert new Double(22.34).equals(result.getPrice());
    }

    @Test
    public void _2testGetAll(){
        List<Rent> result = rentDAO.getAll();
        assert !result.isEmpty();
    }

    @Test
    public void _3testUpdate(){
        Rent rent = new Rent();
        rent.setId(999L);
        rent.setPrice(22.35);
        rent.setCarId(997L);
        rent.setUserId(998L);
        rent.setOpen(false);

        rentDAO.update(rent);
        Rent result = rentDAO.getById(999L);
        assert new Double(22.35).equals(result.getPrice());
    }

    @Test
    public void _4testDelete(){
        Rent rent = new Rent();
        rent.setId(999L);
        rentDAO.delete(rent);
        Rent result = rentDAO.getById(999L);
        assert (result == null);
    }

}
