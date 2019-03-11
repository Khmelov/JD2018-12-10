package by.it.titkovskaya.jd03.jd03_03.custom_DAO;

import by.it.titkovskaya.jd03.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDao<User> {

    @Override
    public User read(long id) throws SQLException {
        List<User> users = getAll(" WHERE `id`=" + id);
        return users.size() == 1 ? users.get(0) : null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users` (`login`,`password`,`email`,`name`,`roles_id`)" +
                        "VALUES ('%s','%s','%s','%s','%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getName(), user.getRoles_id());
        user.setId(executeCreate(sql));
        return user.getId() > 0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format("UPDATE `users` " +
                        "SET `login`='%s',`password`='%s',`email`='%s',`name`='%s',`roles_id`='%s' " +
                        "WHERE `id`='%d'",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getName(),
                user.getRoles_id(), user.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `id`='%d'", user.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `users` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setRoles_id(resultSet.getLong("roles_id"));
                users.add(user);
            }
        }
        return users;
    }
}