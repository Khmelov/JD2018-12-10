package by.it.dziomin.jd03_03.Dao;

import by.it.dziomin.jd03_03.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO extends GenericDAO<User> implements InterfaceDAO<User> {

    private static final String SELECT_BY_ID_SQL = "select * from USER where id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM USER";
    private static final String DELETE_SQL = "DELETE from USER where id = ?";
    private static final String UPDATE_SQL = "update USER set name = ?, passport = ?, phone = ?, role_id = ? where id = ?";
    private static final String INSERT_SQL = "INSERT INTO user (id, name, passport, phone, role_id) VALUES (?, ?, ?, ?, ?)";

    private static UserDAO instance;

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    @Override
    protected List<User> mapResultSet(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setPassport(rs.getString("passport"));
            user.setPhone(rs.getString("phone"));
            user.setRoleId(rs.getLong("role_id"));
            users.add(user);
        }
        return users;
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
    protected List<Object> getInsertParams(User entity) {
        List<Object> params = new ArrayList<>(5);
        params.add(entity.getId());
        params.add(entity.getName());
        params.add(entity.getPassport());
        params.add(entity.getPhone());
        params.add(entity.getRoleId());
        return params;
    }

    @Override
    protected List<Object> getUpdateParams(User entity) {
        List<Object> params = new ArrayList<>(5);
        params.add(entity.getName());
        params.add(entity.getPassport());
        params.add(entity.getPhone());
        params.add(entity.getRoleId());
        params.add(entity.getId());
        return params;
    }
}
