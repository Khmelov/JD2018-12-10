package by.it.titkovskaya.jd03.jd03_02.crud;

import by.it.titkovskaya.jd03.jd03_02.beans.Replenishment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

class ReplenishmentCRUD {

    boolean create(Replenishment replenishment) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,"INSERT INTO `replenishments` " +
                            "(`date`, `amount`, `accounts_id`) " +
                        "VALUES ('%s','%f','%d')",
                        replenishment.getDate(), replenishment.getAmount(), replenishment.getAccounts_id());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    replenishment.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Replenishment read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `replenishments` " +
                    "WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Replenishment replenishment = new Replenishment();
                replenishment.setId(resultSet.getLong("id"));
                replenishment.setDate(resultSet.getTimestamp("date"));
                replenishment.setAmount(resultSet.getDouble("amount"));
                replenishment.setAccounts_id(resultSet.getLong("accounts_id"));
                return replenishment;
            }
        }
        return null;
    }

    boolean update(Replenishment replenishment) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "UPDATE `replenishments` " +
                            "SET `date`='%s', `amount`='%f', `accounts_id`='%d' WHERE `id`='%d'",
                    replenishment.getDate(), replenishment.getAmount(),
                    replenishment.getAccounts_id(), replenishment.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(Replenishment replenishment) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `replenishments` WHERE `id`='%d'", replenishment.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
