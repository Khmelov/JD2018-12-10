package by.it.zagurskaya.project.java.dao;


import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.Kassa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KassaDao extends AbstractDao implements Dao<Kassa> {

    @Override
    public boolean create(Kassa kassa) throws SQLException {
        String sql = String.format(
                "INSERT INTO `kassa`(`currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesNumber`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s' )",
                kassa.getId(), kassa.getReceived(), kassa.getComing(), kassa.getSpending(), kassa.getTransmitted(), kassa.getBalance(), kassa.getUserId(), kassa.getDate(), kassa.getDutiesNumber());
        kassa.setId(executeCreate(sql));
        return kassa.getId() > 0;
    }

    @Override
    public Kassa read(long id) throws SQLException {
        List<Kassa> kassa = getAll(" WHERE id=" + id);
         return kassa.size() == 0 ? null : kassa.get(0);
    }

    public Kassa readByUserNumber(int currencyId) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `kassa` WHERE `numberUser`='%d'",
                    currencyId);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Kassa kassa = new Kassa();
                kassa.setId(resultSet.getLong("id"));
                kassa.setCurrencyId(resultSet.getInt("currencyId"));
                kassa.setReceived(resultSet.getDouble("received"));
                kassa.setComing(resultSet.getDouble("coming"));
                kassa.setSpending(resultSet.getDouble("spending"));
                kassa.setTransmitted(resultSet.getDouble("transmitted"));
                kassa.setBalance(resultSet.getDouble("balance"));
                kassa.setUserId(resultSet.getLong("userId"));
                kassa.setDate(resultSet.getDate("date"));
                kassa.setDutiesNumber(resultSet.getInt("dutiesNumber"));
                return kassa;
            }
        }
        return null;
    }

    @Override
    public boolean update(Kassa kassa) throws SQLException {
        String sql = String.format(
                " UPDATE `kassa` SET `currencyId`='%d',`received`='%s', `coming`='%s', `spending`='%s', `transmitted`='%s', `balance`='%s', `userId`='%s', `date`='%s', `dutiesNumber`='%s' WHERE `id`='%d'",
                kassa.getCurrencyId(),kassa.getReceived(), kassa.getComing(),kassa.getSpending(),kassa.getTransmitted(),kassa.getBalance(), kassa.getUserId(), kassa.getDate(), kassa.getDutiesNumber(), kassa.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Kassa kassa) throws SQLException {
        String sql = String.format(
                "DELETE FROM `kassa` WHERE `id`='%d'",
                kassa.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Kassa> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Kassa> getAll(String where) throws SQLException {
        List<Kassa> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `kassa`" + where);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Kassa kassa = new Kassa();
                kassa.setId(resultSet.getLong("id"));
                kassa.setCurrencyId(resultSet.getInt("currencyId"));
                kassa.setReceived(resultSet.getDouble("received"));
                kassa.setComing(resultSet.getDouble("coming"));
                kassa.setSpending(resultSet.getDouble("spending"));
                kassa.setTransmitted(resultSet.getDouble("transmitted"));
                kassa.setBalance(resultSet.getDouble("balance"));
                kassa.setUserId(resultSet.getInt("userId"));
                kassa.setDate(resultSet.getDate("date"));
                kassa.setDutiesNumber(resultSet.getInt("dutiesNumber"));
                result.add(kassa);
            }
        }
        return result;
    }

}
