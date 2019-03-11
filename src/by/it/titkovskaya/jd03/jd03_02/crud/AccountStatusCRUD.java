package by.it.titkovskaya.jd03.jd03_02.crud;

import by.it.titkovskaya.jd03.jd03_02.beans.AccountStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AccountStatusCRUD {

    boolean create(AccountStatus status) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `account status` (`status`) VALUES ('%s')",
                    status.getStatus());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    status.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    AccountStatus read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `account status` " +
                    "WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                AccountStatus status = new AccountStatus();
                status.setId(resultSet.getLong("id"));
                status.setStatus(resultSet.getString("status"));
                return status;
            }
        }
        return null;
    }

    boolean update(AccountStatus status) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `account status` " +
                            "SET `status`='%s' WHERE `id`='%d'",
                    status.getStatus(), status.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(AccountStatus status) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `account status` WHERE `id`='%d'", status.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
