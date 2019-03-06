package by.it.moroz.jd03.jd03_02;

import by.it.moroz.jd03.jd03_02.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class OrderCRUD {

    boolean createOrder(Order order) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String create = String.format("INSERT INTO `moroz`.`orders` (`menu_id`, `count`, `check`, `users_id`)" +
                    " VALUES ('%d', '%d', '%f', '%d')", order.getMenu_id(), order.getCount(),
                    order.getCheck(), order.getUsers_id());
            int i = statement.executeUpdate(create, Statement.RETURN_GENERATED_KEYS);
            if (i == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Order readOrder(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String read = String.format("SELECT * FROM `orders` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(read);
            if (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setMenu_id(resultSet.getLong("menu_id"));
                order.setCount(resultSet.getInt("count"));
                order.setCheck(resultSet.getDouble("check"));
                order.setUsers_id(resultSet.getLong("users_id"));
                return order;
            }
        }
        return null;
    }

    boolean updateOrder(Order order) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String update = String.format("UPDATE `orders` SET `menu_id`='%d', `count`='%d', " +
                            "`check`='%f', `users_id`='%d' WHERE `id`='%d'",
                    order.getMenu_id(), order.getCount(), order.getCheck(), order.getUsers_id(),
                    order.getId());
            return 1==statement.executeUpdate(update);
        }
    }

    boolean deleteOrder(Order order) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String delete = String.format("DELETE FROM `orders` WHERE `id`='%d'", order.getId());
            return 1==statement.executeUpdate(delete);
        }
    }
}
