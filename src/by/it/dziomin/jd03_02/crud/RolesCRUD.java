package by.it.dziomin.jd03_02.crud;

import by.it.dziomin.jd03_02.DBConnector;
import by.it.dziomin.jd03_02.beans.Roles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RolesCRUD {


    public boolean create(Roles role) {
        try {
            String sql = String.format(
                    "INSERT INTO `role`(`name`) VALUES ('%s')",
                    role.getName());
            int count = DBConnector.getStatement().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = DBConnector.getStatement().getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Roles role) {
        try {
            String sql = String.format(
                    "UPDATE `role` SET `name`='%s' " +
                            "WHERE `id`='%d'",
                    role.getName(),
                    role.getId());
            return 1 == DBConnector.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Roles role) {
        try {
            String sql = String.format(
                    "DELETE FROM `role` WHERE `id`='%d'",
                    role.getId());

            return 1 == DBConnector.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Roles read(long id) {
        try {
            String sql = String.format(
                    "SELECT * FROM `role` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = DBConnector.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                Roles role = new Roles();
                role.setId(resultSet.getLong("id"));
                role.setName(resultSet.getString("name"));
                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
