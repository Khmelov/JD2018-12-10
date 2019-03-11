package by.it.titkovskaya.jd03.jd03_03.custom_DAO;

import by.it.titkovskaya.jd03.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao implements InterfaceDao<Role> {

    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles = getAll(" WHERE `id`=" + id);
        return roles.size() > 0 ? roles.get(0) : null;
    }

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format("INSERT INTO `roles` (`role`) VALUES ('%s')",
                role.getRole());
        role.setId(executeCreate(sql));
        return role.getId() > 0;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format("UPDATE `roles` " +
                        "SET `role`='%s' WHERE `id`='%d'",
                role.getRole(), role.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `id`='%d'", role.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> roles = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `roles` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setRole(resultSet.getString("role"));
                roles.add(role);
            }
        }
        return roles;
    }
}
