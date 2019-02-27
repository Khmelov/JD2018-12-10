package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends AbstractDao implements Dao<Account> {
    @Override
    public boolean create(Account account) throws SQLException {
        String sql = String.format(
                "INSERT INTO `accounts`(`mask`, `subMask`, `currencyId`, `fullAccount`) VALUES ('%s','%s','%s','%s')",
                account.getMask(), account.getSubMask(), account.getCurrencyId(), account.getFullAccount());
//        System.out.println(sql);
        account.setId(executeCreate(sql));
        return account.getId() > 0;
    }

    @Override
    public Account read(long id) throws SQLException {
        List<Account> account = getAll(" WHERE id=" + id);
        return account.size() == 0 ? null : account.get(0);
    }

    @Override
    public boolean update(Account account) throws SQLException {
          String sql = String.format(
                  "UPDATE `accounts` SET `mask`='%s', `subMask`='%s',`currencyId`='%s' ,`fullAccount`='%s',`id`='%d'  WHERE `id`='%d'",
                  account.getMask(), account.getSubMask(), account.getCurrencyId(), account.getFullAccount(), account.getId(), account.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Account account) throws SQLException {
        String sql = String.format(
                "DELETE FROM `accounts` WHERE `idAccount`='%s'",
                account.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Account> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Account> getAll(String where) throws SQLException {
        List<Account> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `accounts` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setMask(resultSet.getString("mask"));
                account.setSubMask(resultSet.getString("subMask"));
                account.setCurrencyId(resultSet.getLong("currencyId"));
                account.setFullAccount(resultSet.getString("fullAccount"));
                result.add(account);
            }
        }
        return result;
    }

}
