package by.it.dziomin.jd03_03.Dao;

import by.it.dziomin.jd03_03.beans.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends GenericDAO<Role> implements InterfaceDAO<Role> {

    private static final String SELECT_BY_ID_SQL = "select id, name from ROLE where id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM role";
    private static final String DELETE_SQL = "DELETE from ROLE where id = ?";
    private static final String UPDATE_SQL = "update ROLE set name = ? where id = ?";
    private static final String INSERT_SQL = "INSERT INTO role (id, name) values(?,?)";

    private static RoleDAO instance;

    private RoleDAO() {
    }

    public static RoleDAO getInstance() {
        if (instance == null) {
            synchronized (RoleDAO.class) {
                if (instance == null) {
                    instance = new RoleDAO();
                }
            }
        }
        return instance;
    }

    @Override
    protected List<Role> mapResultSet(ResultSet rs) throws SQLException {
        List<Role> roles = new ArrayList<>();
        while (rs.next()) {
            Role role = new Role();
            role.setId(rs.getLong("id"));
            role.setName(rs.getString("name"));
            roles.add(role);
        }
        return roles;
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
    protected List<Object> getInsertParams(Role entity) {
        List<Object> params = new ArrayList<>(2);
        params.add(entity.getId());
        params.add(entity.getName());
        return params;
    }

    @Override
    protected List<Object> getUpdateParams(Role entity) {
        List<Object> params = new ArrayList<>(2);
        params.add(entity.getName());
        params.add(entity.getId());
        return params;
    }

}
