package by.it.naron.project.java.dao;

import by.it.naron.project.java.beans.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrdersDao  implements InterfaceDao<Orders> {
    @Override
    public boolean create(Orders orders) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `orders`" +
                        "(`amount`, `time_delivery`,  `date_orders`,`total_price`," +
                        " `users_id`, `ads_id`) " +
                        "VALUES ('%d','%d','%s','%f','%d','%d')",
                orders.getAmount(), orders.getTime_delivery(), orders.getDate_orders(),
                orders.getTotal_price(), orders.getUsers_id(), orders.getAd_id());
       long id = Dao.executeCreateAndGetId(sql);
        orders.setId(id);
        return orders.getId() > 0;
    }


    @Override
    public boolean update(Orders orders) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `orders` " +
                        "SET `amount`='%d',`time_delivery`='%d',`date_orders`='%s'," +
                        "`total_price`='%f',`users_id`='%d', `ads_id`='%d' " +
                        "WHERE `id`='%d'",
                orders.getAmount(), orders.getTime_delivery(), orders.getDate_orders(),
                orders.getTotal_price(), orders.getUsers_id(), orders.getAd_id(),
                orders.getId());
        return Dao.executeUpdate(sql);
    }

    @Override
    public boolean delete(Orders orders) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `orders` WHERE `id`='%d'",
                orders.getId());
        return Dao.executeUpdate(sql);

    }

    @Override
    public Orders read(long id) throws SQLException {
//////////////////////////////////////////////////////////////////////////////////////
        List<Orders> orders = getAll("  WHERE id=" + id);
//////////////////////////////////////////////////////////////////////////////////////
        return orders.size() == 0 ? null : orders.get(0);
    }

//    @Override
//    public List<Orders> getAll() throws SQLException {
//        return getAll("");
//    }

    @Override
    public List<Orders> getAll(String where) throws SQLException {
        List<Orders> result = new ArrayList<>();
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "SELECT * FROM `orders` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Orders orders = new Orders();
                orders.setId(resultSet.getLong("id"));
                orders.setAmount(resultSet.getLong("amount"));
                orders.setTime_delivery(resultSet.getLong("time_delivery"));
                orders.setDate_orders(resultSet.getTimestamp("date_orders"));
                orders.setTotal_price(resultSet.getDouble("total_price"));
                orders.setUsers_id(resultSet.getInt("users_id"));
                orders.setAd_id(resultSet.getInt("ads_id"));
                result.add(orders);
            }
        }
        return result;
    }
}