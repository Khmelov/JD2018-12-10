package by.it.subach.project.java.dao;


import by.it.subach.project.java.beans.Role;
import by.it.subach.project.java.dao.dbInit.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao implements InterfaceDao<Role> {

    public boolean create(Role role) throws SQLException {
        String sql = String.format("INSERT INTO `roles`(`role`) VALUES ('%s')",
                role.getRole());
        long id = executeCreate(sql);
        if (id > 0) {
            role.setId(id);
            return true;
        }

        return false;
    }

    public Role read(long id) throws SQLException {
            String sql = String.format(" WHERE id=" +
                    id);
            List<Role> rolesList = getAll(sql);
            if(rolesList.size() > 0) {
                return rolesList.get(0);
            }
        return null;
    }

    public boolean update(Role role) throws SQLException {
        String sql = String.format("UPDATE `roles` SET `role`='%s' WHERE `id`=%d",
                role.getRole(),
                role.getId()
        );

        return executeUpdate(sql);
    }


    public boolean delete(Role role) throws SQLException {
            String sql = String.format("DELETE FROM `roles` WHERE `id`='%d'",
                    role.getId());
            return executeUpdate(sql);
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> rolesList = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `roles` " +
                    where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getLong(1));
                role.setRole(resultSet.getString("role"));
                rolesList.add(role);
            }
        }
        return rolesList;
    }
}
