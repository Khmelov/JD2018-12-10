package by.it.titkovskaya.jd03.jd03_02.crud;

import by.it.titkovskaya.jd03.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class UserCRUD {

    boolean create(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `users` (`login`,`password`,`email`,`name`,`roles_id`)" +
                                        "VALUES ('%s','%s','%s','%s', '%d')",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getName(), user.getRoles_id());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    User read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `users` " +
                    "WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setRoles_id(resultSet.getLong("roles_id"));
                return user;
            }
        }
        return null;
    }

    boolean update(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `users` " +
                            "SET `login`='%s',`password`='%s',`email`='%s',`name`='%s',`roles_id`='%s' " +
                            "WHERE `id`='%d'",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getName(),
                    user.getRoles_id(), user.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `users` WHERE `id`='%d'", user.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

}
