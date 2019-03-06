package by.it.moroz.jd03.jd03_03.dao;

import by.it.moroz.jd03.jd03_03.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class OrderDAO extends AbstractDAO implements InterfaceDAO<Order> {


    @Override
    public Order read(long id) throws SQLException {
        List<Order> orders = getAll("WHERE `id`=" + id);
        return orders.size()==0?null:orders.get(0);
    }

    @Override
    public boolean create(Order order) throws SQLException {
        String sql = String.format("INSERT INTO `orders` (`menu_id`, `count`, `check`, `users_id`)"+
                "VALUES ('%d','%d','%f','%d')", order.getMenu_id(),order.getCount(),
                order.getCheck(),order.getUsers_id());
        order.setId(executeCreate(sql));
        return order.getId()>0;
    }

    @Override
    public boolean update(Order order) throws SQLException {
        String sql = String.format("UPDATE `orders` SET `menu_id`='%d', `count`='%d', " +
                        "`check`='%f', `user_id`='%d' WHERE `id`='%d'",
                order.getMenu_id(), order.getCount(), order.getCheck(), order.getUsers_id(),
                order.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Order order) throws SQLException {
        String sql = String.format(
                "DELETE FROM `orders` WHERE `id`='%d'",
                order.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Order> getAll(String WHERE) throws SQLException {
        List<Order> result = new ArrayList<>();
            String sql = "SELECT * FROM `orders` "+WHERE;
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setMenu_id(resultSet.getLong("menu_id"));
                order.setCount(resultSet.getInt("count"));
                order.setCheck(resultSet.getDouble("check"));
                order.setUsers_id(resultSet.getLong("users_id"));
                result.add(order);
            }
        }
        return result;
    }
}
