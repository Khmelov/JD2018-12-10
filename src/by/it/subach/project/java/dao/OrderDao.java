package by.it.subach.project.java.dao;


import by.it.subach.project.java.beans.Order;
import by.it.subach.project.java.dao.dbInit.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends AbstractDao implements InterfaceDao<Order> {

    public boolean create(Order order) throws SQLException {
        String sql = String.format("INSERT INTO `orders`(`user_id`, `product_id`) " +
                        "VALUES ('%d','%d')",
                order.getUser_id(),
                order.getProduct_id()
        );
        long id = executeCreate(sql);
        if (id > 0) {
            order.setId(id);
            return true;
        }
        return false;
    }

    public Order read(long id) throws SQLException {
        String sql = " WHERE id=" + id;
        List<Order> orderList = getAll(sql);
        if (orderList.size() == 1)
            return orderList.get(0);
        return null;
    }

    public boolean update(Order order) throws SQLException {
        String sql = String.format("UPDATE `orders` " +
                        "SET `user_id`='%d',`product_id`='%d' " +
                        "WHERE `id`='%d'",
                order.getUser_id(),
                order.getProduct_id(),
                order.getId()
        );
        return executeUpdate(sql);
    }

    public boolean delete(Order order) throws SQLException {
        String sql = String.format("DELETE FROM `orders` WHERE `id`='%d'",
                order.getId()
        );
        return executeUpdate(sql);

    }

    @Override
    public List<Order> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Order> getAll(String where) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = "SELECT * FROM `orders` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUser_id(resultSet.getLong("user_id"));
                order.setProduct_id(resultSet.getInt("product_id"));
                orderList.add(order);
            }
        }
        return orderList;
    }
}
