package by.it.dziomin.jd03_03.Dao;

import by.it.dziomin.jd03_03.beans.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends GenericDAO<Car> implements InterfaceDAO<Car> {

    private static final String SELECT_BY_ID_SQL = "select * from CAR where id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM CAR";
    private static final String DELETE_SQL = "DELETE from CAR where id = ?";
    private static final String UPDATE_SQL = "update CAR set name = ?, number = ?, engine = ?, transmission = ? where id = ?";
    private static final String INSERT_SQL = "INSERT INTO car (id, name, number, engine, transmission) VALUES (?, ?, ?, ?, ?)";

    private static CarDAO instance;

    private CarDAO() {
    }

    public static CarDAO getInstance() {
        if (instance == null) {
            synchronized (CarDAO.class) {
                if (instance == null) {
                    instance = new CarDAO();
                }
            }
        }
        return instance;
    }

    @Override
    protected List<Car> mapResultSet(ResultSet rs) throws SQLException {
        List<Car> cars = new ArrayList<>();
        while (rs.next()) {
            Car car = new Car();
            car.setId(rs.getLong("id"));
            car.setName(rs.getString("name"));
            car.setNumber(rs.getString("number"));
            car.setEngine(rs.getString("engine"));
            car.setTransmission(rs.getString("transmission"));
            cars.add(car);
        }
        return cars;
    }

    @Override
    protected String getSelectByIdSql() {
        return SELECT_BY_ID_SQL;
    }

    @Override
    protected String getSelectAllSql() {
        return SELECT_ALL_SQL;
    }

    @Override
    protected String getDeleteSql() {
        return DELETE_SQL;
    }

    @Override
    protected String getInsertSql() {
        return INSERT_SQL;
    }

    @Override
    protected String getUpdateSql() {
        return UPDATE_SQL;
    }

    protected List<Object> getInsertParams(Car entity) {
        List<Object> params = new ArrayList<>(5);
        params.add(entity.getId());
        params.add(entity.getName());
        params.add(entity.getNumber());
        params.add(entity.getEngine());
        params.add(entity.getTransmission());
        return params;
    }

    protected List<Object> getUpdateParams(Car entity) {
        List<Object> params = new ArrayList<>(5);
        params.add(entity.getName());
        params.add(entity.getNumber());
        params.add(entity.getEngine());
        params.add(entity.getTransmission());
        params.add(entity.getId());
        return params;
    }

}
