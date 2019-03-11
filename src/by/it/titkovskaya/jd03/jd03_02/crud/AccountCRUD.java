package by.it.titkovskaya.jd03.jd03_02.crud;

import by.it.titkovskaya.jd03.jd03_02.beans.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

class AccountCRUD {

    boolean create(Account account) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "INSERT INTO `accounts` (`number`," +
                            "`currency`,`users_id`,`account_status_id`,`unlock_request`) " +
                            "VALUES ('%d','%s','%d','%d','%d')",
                    account.getNumber(), account.getCurrency(), account.getUsers_id(),
                    account.getAccount_status_id(), account.getUnlock_request());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    account.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Account read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `accounts` " +
                    "WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setNumber(resultSet.getLong("number"));
                account.setCurrency(resultSet.getString("currency"));
                account.setUsers_id(resultSet.getLong("users_id"));
                account.setAccount_status_id(resultSet.getLong("account_status_id"));
                account.setUnlock_request(resultSet.getInt("unlock_request"));
                return account;
            }
        }
        return null;
    }

    boolean update(Account account) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "UPDATE `accounts` SET `number`='%d',`currency`='%s'," +
                            "`users_id`='%d',`account_status_id`='%d', `unlock_request`='%d' WHERE `id`='%d'",
                    account.getNumber(), account.getCurrency(), account.getUsers_id(),
                    account.getAccount_status_id(), account.getUnlock_request(), account.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(Account account) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `accounts` WHERE `id`='%d'", account.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
