package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.SprEntries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SprEntriesDao extends AbstractDao implements Dao<SprEntries> {
    @Override
    public boolean create(SprEntries sprEntries) throws SQLException {
        String sql = String.format(
                "INSERT INTO `sprEntries`(`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')",
                sprEntries.getId(), sprEntries.getName(), sprEntries.getCurrencyId(), sprEntries.getSprOperationsId() ,sprEntries.getAccountDebit(), sprEntries.getAccountCredit(), sprEntries.getIsSpending() ? 1 : 0, sprEntries.getRate());
//        System.out.println(sql);
        long result = executeCreate(sql);
        return result == 0;
    }

    @Override
    public SprEntries read(long id) throws SQLException {
        List<SprEntries> sprEntries = getAll(" WHERE id=" + id);
        return sprEntries.size() == 0 ? null : sprEntries.get(0);
    }

    @Override
    public boolean update(SprEntries sprEntries) throws SQLException {
          String sql = String.format(
                  "UPDATE `sprEntries` SET `name`='%s', `currencyId`='%s', `sprOperationsId`='%s' ,`accountDebit`='%s' ,`accountCredit`='%s', `isSpending`='%s',`rate`='%s',`id`='%d'  WHERE `id`='%d'",
                  sprEntries.getName(), sprEntries.getCurrencyId(), sprEntries.getSprOperationsId(), sprEntries.getAccountDebit(), sprEntries.getAccountCredit(), sprEntries.getIsSpending()? 1 : 0, sprEntries.getRate(), sprEntries.getId(), sprEntries.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(SprEntries sprEntries) throws SQLException {
        String sql = String.format(
                "DELETE FROM `sprEntries` WHERE `id`='%s'",
                sprEntries.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<SprEntries> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<SprEntries> getAll(String where) throws SQLException {
        List<SprEntries> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `sprEntries` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SprEntries sprEntries = new SprEntries();
                sprEntries.setId(resultSet.getLong("id"));
                sprEntries.setName(resultSet.getString("name"));
                sprEntries.setCurrencyId(resultSet.getLong("currencyId"));
                sprEntries.setSprOperationsId(resultSet.getLong("sprOperationsId"));
                sprEntries.setAccountDebit(resultSet.getString("accountDebit"));
                sprEntries.setAccountCredit(resultSet.getString("accountCredit"));
                sprEntries.setIsSpending(resultSet.getBoolean("isSpending"));
                sprEntries.setRate(resultSet.getDouble("rate"));
                result.add(sprEntries);
            }
        }
        return result;
    }

}
