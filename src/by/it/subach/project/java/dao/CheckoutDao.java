package by.it.subach.project.java.dao;


import by.it.subach.project.java.beans.Checkout;
import by.it.subach.project.java.dao.dbInit.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CheckoutDao extends AbstractDao implements InterfaceDao<Checkout> {

    @Override
    public boolean create(Checkout checkout) throws SQLException {
        String sql = String.format("INSERT INTO `checkout`(`checkout_status`, `order_id`) " +
                        "VALUES ('%d','%d')",
                checkout.getCheckoutStatus(),
                checkout.getOrder_id()
        );
        long id = executeCreate(sql);
        if (id > 0) {
            checkout.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public Checkout read(long id) throws SQLException {
        String sql = " WHERE id=" + id;
        List<Checkout> checkoutList = getAll(sql);
        if(checkoutList.size() == 1) {
            return checkoutList.get(0);
        }
        return null;
    }

    @Override
    public boolean update(Checkout checkout) throws SQLException {
        String sql = String.format("UPDATE `checkout` " +
                        "SET `checkout_status`='%d',`order_id`='%d' " +
                        "WHERE `id`='%d'",
                checkout.getCheckoutStatus(),
                checkout.getOrder_id(),
                checkout.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Checkout checkout) throws SQLException {
        String sql = String.format("DELETE FROM `checkout` WHERE `id`='%d'",
                checkout.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<Checkout> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Checkout> getAll(String where) throws SQLException {
        List<Checkout> checkoutList = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = "SELECT * FROM `checkout` " + where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Checkout checkout = new Checkout();
                checkout.setId(resultSet.getInt("id"));
                checkout.setCheckoutStatus(resultSet.getInt("checkout_status"));
                checkout.setOrder_id(resultSet.getInt("order_id"));
                checkoutList.add(checkout);
            }
        }
        return checkoutList;
    }

}
