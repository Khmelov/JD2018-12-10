package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.Currency;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao extends AbstractDao implements Dao<Currency> {
    @Override
    public boolean create(Currency currency) throws SQLException {
        String sql = String.format(
                "INSERT INTO `currencies`(`id`, `iso`, `name`) VALUES ('%d','%s','%s')",
                currency.getId(), currency.getIso(), currency.getName());
//        System.out.println(sql);
        long result = executeCreate(sql);
        return result == 0;
    }

    @Override
    public Currency read(long id) throws SQLException {
        List<Currency> currency = getAll(" WHERE id=" + id);
        return currency.size() == 0 ? null : currency.get(0);
    }

    @Override
    public boolean update(Currency currency) throws SQLException {
          String sql = String.format(
                  "UPDATE `currencies` SET `iso`='%s', `name`='%s' WHERE `id`='%d'",
                  currency.getIso(), currency.getName(), currency.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Currency currency) throws SQLException {
        String sql = String.format(
                "DELETE FROM `currencies` WHERE `id`='%s'",
                currency.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Currency> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Currency> getAll(String where) throws SQLException {
        List<Currency> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `currencies` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Currency currency = new Currency();
                currency.setId(resultSet.getLong("id"));
                currency.setIso(resultSet.getString("iso"));
                currency.setName(resultSet.getString("name"));
                result.add(currency);
            }
        }
        return result;
    }

}
