package by.it.moroz.jd03.jd03_03.dao;

import by.it.moroz.jd03.jd03_03.beans.Order;

 public class OrderDAO extends UniversalDAO<Order> {

      OrderDAO() {
        super(Order.class, "orders");
    }


    /*@Override
    public Order read(long id) throws SQLException {
        List<Order> orders = getAll("WHERE `id`=" + id);
        return orders.size()==0?null:orders.get(0);
    }

    @Override
    public boolean create(Order order) throws SQLException {
        String sql = String.format("INSERT INTO `orders` (`name`, `count`, `price`, `check`, `users_id`)"+
                "VALUES ('%s','%d','%f','%f','%d')", order.getName(),order.getCount(),order.getPrice(),
                order.getCheck(),order.getUser_id());
        order.setId(executeCreate(sql));
        return order.getId()>0;
    }

    @Override
    public boolean update(Order order) throws SQLException {
        String sql = String.format("UPDATE `orders` SET `name`='%s', `count`='%d', `price`='%f', " +
                        "`check`='%f', `user_id`='%d' WHERE `id`='%d'",
                order.getName(), order.getCount(), order.getPrice(), order.getCheck(), order.getUser_id(),
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
            ResultSet resultSet = executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setName(resultSet.getString("name"));
                order.setCount(resultSet.getInt("count"));
                order.setPrice(resultSet.getDouble("price"));
                order.setCheck(resultSet.getDouble("check"));
                order.setUser_id(resultSet.getLong("users_id"));
                result.add(order);
            }
        return result;
    }*/
}
