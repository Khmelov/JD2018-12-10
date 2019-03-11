package by.it.titkovskaya.jd03.jd03_02.crud;

import by.it.titkovskaya.jd03.jd03_02.beans.Payment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

class PaymentCRUD {

    boolean create(Payment payment) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,"INSERT INTO `payments` (`date`, `amount`, `recipient`, `accounts_id`) " +
                    "VALUES ('%s','%f','%s','%d')",
                    payment.getDate(), payment.getAmount(), payment.getRecipient(), payment.getAccounts_id());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    payment.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Payment read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `payments` " +
                    "WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Payment payment = new Payment();
                payment.setId(resultSet.getLong("id"));
                payment.setDate(resultSet.getTimestamp("date"));
                payment.setRecipient(resultSet.getString("recipient"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setAccounts_id(resultSet.getLong("accounts_id"));
                return payment;
            }
        }
        return null;
    }

    boolean update(Payment payment) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "UPDATE `payments` " +
                            "SET `date`='%s', `amount`='%f', `recipient`='%s', " +
                            "`accounts_id`='%d' WHERE `id`='%d'",
                    payment.getDate(), payment.getAmount(), payment.getRecipient(),
                    payment.getAccounts_id(), payment.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(Payment payment) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `payments` WHERE `id`='%d'", payment.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}


