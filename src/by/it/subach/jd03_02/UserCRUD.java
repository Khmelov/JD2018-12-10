package by.it.subach.jd03_02;

import by.it.subach.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

//    CREATEGOODSFLOWER
    boolean create(User user) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `users`(`login`, `password`, `email`, `role_id`) " +
                            "VALUES ('%s','%s','%s','%d')",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRole_id());
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

//        READ
        User read ( long id) throws SQLException {
            try (
                    Connection connection = ConnCreator.getConnection();
                    Statement statement = connection.createStatement()
            ) {
                String sql = String.format("SELECT * FROM `users` WHERE `id`='%d'",
                        id);
                ResultSet resultSet = statement.executeQuery(sql);
                if(resultSet.next()){
                    User user = new User();
                    user.setId(resultSet.getLong(1));
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    user.setEmail(resultSet.getString("email"));
                    user.setRole_id(resultSet.getInt("role_id"));
                    return user;
                }
            }
            return null;
        }

//        UPDATE
        boolean update (User user) throws SQLException {
            try (
                    Connection connection = ConnCreator.getConnection();
                    Statement statement = connection.createStatement()
            ) {
                String sql = String.format(
                                "UPDATE `users` " +
                                "SET `login`='%s',`password`='%s',`email`='%s',`role_id`='%d' " +
                                "WHERE `id`='%d'",
                        user.getLogin(),
                        user.getPassword(),
                        user.getEmail(),
                        user.getRole_id(),
                        user.getId()
                );
                return 1 == statement.executeUpdate(sql);
            }
        }

//        DELETE
        boolean delete (User user) throws SQLException {
            try (
                    Connection connection = ConnCreator.getConnection();
                    Statement statement = connection.createStatement()
            ) {
                String sql = String.format("DELETE FROM `users` WHERE `id`='%d'",
                        user.getId()
                );
                return 1 == statement.executeUpdate(sql);
            }
        }
    }
