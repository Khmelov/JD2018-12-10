package by.it.subach.project.java.dao;

import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.dbInit.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDao<User> {
    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users`(`login`, `password`, `email`, `role_id`) " +
                        "VALUES ('%s','%s','%s','%d')",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRole_id());
        long id = executeCreate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        }
        return false;
    }


    @Override
    public User read(long id) throws SQLException {
        String sql = " WHERE id=" +
                id;
        List<User> userList = getAll(sql);
        if (userList.size() == 1) {
            return userList.get(0);

        }
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
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
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE `id`='%d'",
                user.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> usersList = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = "SELECT * FROM `users` " +
                    where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRole_id(resultSet.getInt("role_id"));
                usersList.add(user);

            }
        }
        return usersList;
    }
}
