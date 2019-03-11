package by.it.titkovskaya.jd03.jd03_03.custom_DAO;

import by.it.titkovskaya.jd03.jd03_03.beans.Payment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PaymentDao extends AbstractDao implements InterfaceDao<Payment> {

    @Override
    public Payment read(long id) throws SQLException {
        List<Payment> payments = getAll(" WHERE `id`=" + id);
        return payments.size() > 0 ? payments.get(0) : null;
    }

    @Override
    public boolean create(Payment payment) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `payments` (`date`, `amount`, `recipient`, `accounts_id`) " +
                        "VALUES ('%s','%f','%s','%d')",
                payment.getDate(), payment.getAmount(), payment.getRecipient(), payment.getAccounts_id());
        payment.setId(executeCreate(sql));
        return payment.getId() > 0;
    }

    @Override
    public boolean update(Payment payment) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `payments` " +
                        "SET `date`='%s', `amount`='%f', `recipient`='%s', " +
                        "`accounts_id`='%d' WHERE `id`='%d'",
                payment.getDate(), payment.getAmount(), payment.getRecipient(),
                payment.getAccounts_id(), payment.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Payment payment) throws SQLException {
        String sql = String.format(
                "DELETE FROM `payments` WHERE `id`='%d'", payment.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Payment> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Payment> getAll(String where) throws SQLException {
        List<Payment> payments = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `payments` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setId(resultSet.getLong("id"));
                payment.setDate(resultSet.getTimestamp("date"));
                payment.setRecipient(resultSet.getString("recipient"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setAccounts_id(resultSet.getLong("accounts_id"));
                payments.add(payment);
            }
        }
        return payments;
    }
}
