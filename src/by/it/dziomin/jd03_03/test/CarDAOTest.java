package by.it.dziomin.jd03_03.test;

import by.it.dziomin.jd03_03.Dao.CarDAO;
import by.it.dziomin.jd03_03.beans.Car;
import org.junit.Test;

import java.util.List;

public class CarDAOTest {

    private CarDAO dao = CarDAO.getInstance();

    @Test()
    public void _1testCreate(){
        Car car = new Car();
        car.setName("test_car");
        car.setId(999L);

        Car created = dao.create(car);
        Car result = dao.getById(999L);
        assert "test_car".equals(result.getName());
    }

    @Test
    public void _2testGetAll(){
        List<Car> result = dao.getAll();
        assert !result.isEmpty();
    }

    @Test
    public void _3testUpdate(){
        Car car = new Car();
        car.setId(999L);
        car.setName("test_car_updated");

        dao.update(car);
        Car result = dao.getById(999L);
        assert "test_car_updated".equals(result.getName());
    }

    @Test
    public void _4testDelete(){
        Car car = new Car();
        car.setId(999L);
        dao.delete(car);
        Car result = dao.getById(999L);
        assert (result == null);
    }

}
