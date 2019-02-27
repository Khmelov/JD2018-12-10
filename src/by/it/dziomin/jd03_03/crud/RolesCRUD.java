package by.it.dziomin.jd03_03.crud;

import by.it.dziomin.jd03_03.DBConnector;
import by.it.dziomin.jd03_03.beans.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RolesCRUD {


//    public boolean create(Role role) {
//        try {
//            String sql = String.format(
//                    "INSERT INTO `roles`(`role`) VALUES ('%s')",
//                    role.getName());
//            int count = DBConnector.getStatement().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//            if (count == 1) {
//                ResultSet generatedKeys = DBConnector.getStatement().getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    role.setId(generatedKeys.getLong(1));
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public boolean update(Role role) {
//        try {
//            String sql = String.format(
//                    "UPDATE `roles` SET `role`='%s' " +
//                            "WHERE `id`='%d'",
//                    role.getName(),
//                    role.getId());
//            return 1 == DBConnector.getStatement().executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public boolean delete(Role role) {
//        try {
//            String sql = String.format(
//                    "DELETE FROM `roles` WHERE `id`='%d'",
//                    role.getId());
//
//            return 1 == DBConnector.getStatement().executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//    public Role read(long id) {
//        try {
//            String sql = String.format(
//                    "SELECT_ALL_SQL * FROM `roles` WHERE `id`='%d'",
//                    id);
//            ResultSet resultSet = DBConnector.getStatement().executeQuery(sql);
//            if (resultSet.next()) {
//                Role role = new Role();
//                role.setId(resultSet.getLong("id"));
//                role.setName(resultSet.getString("role"));
//                return role;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//

}
