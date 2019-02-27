package by.it.dziomin.jd03_03.Dao;


import by.it.dziomin.jd03_03.beans.Rent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentDAO extends GenericDAO<Rent> implements InterfaceDAO<Rent> {

    private static final String SELECT_BY_ID_SQL = "select * from RENT where id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM RENT";
    private static final String DELETE_SQL = "DELETE from RENT where id = ?";
    private static final String UPDATE_SQL = "update RENT set date = ?, price = ?, isopen= ?, user_id = ?, car_id = ? where id = ?";
    private static final String INSERT_SQL = "INSERT INTO rent (id, date, price, isopen, user_id, car_id) VALUES (?, ?, ?, ?, ?, ?)";

    private static RentDAO instance;

    private RentDAO() {
    }

    public static RentDAO getInstance() {
        if (instance == null) {
            synchronized (RentDAO.class) {
                if (instance == null) {
                    instance = new RentDAO();
                }
            }
        }
        return instance;
    }

    @Override
    protected List<Rent> mapResultSet(ResultSet rs) throws SQLException {
        List<Rent> rents = new ArrayList<>();
        while (rs.next()) {
            Rent rent = new Rent();
            rent.setId(rs.getLong("id"));
            rent.setDate(rs.getDate("date"));
            rent.setPrice(rs.getDouble("price"));
            rent.setOpen(rs.getBoolean("isopen"));
            rent.setUserId(rs.getLong("user_id"));
            rent.setCarId(rs.getLong("car_id"));
            rents.add(rent);
        }
        return rents;
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

    @Override
    protected List<Object> getInsertParams(Rent entity) {
        List<Object> params = new ArrayList<>(6);
        params.add(entity.getId());
        params.add(entity.getDate());
        params.add(entity.getPrice());
        params.add(entity.getOpen());
        params.add(entity.getUserId());
        params.add(entity.getCarId());
        return params;
    }

    @Override
    protected List<Object> getUpdateParams(Rent entity) {
        List<Object> params = new ArrayList<>(6);
        params.add(entity.getDate());
        params.add(entity.getPrice());
        params.add(entity.getOpen());
        params.add(entity.getUserId());
        params.add(entity.getCarId());
        params.add(entity.getId());
        return params;
    }
}
