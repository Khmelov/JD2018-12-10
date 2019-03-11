package by.it.titkovskaya.jd03.jd03_03.custom_DAO;

import by.it.titkovskaya.jd03.jd03_03.beans.Replenishment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReplenishmentDao extends AbstractDao implements InterfaceDao<Replenishment> {

    @Override
    public Replenishment read(long id) throws SQLException {
        List<Replenishment> replenishments = getAll("WHERE `id`=" +id);
        return replenishments.size() > 0 ? replenishments.get(0) : null;
    }

    @Override
    public boolean create(Replenishment replenishment) throws SQLException {
        String sql = String.format(Locale.ENGLISH,"INSERT INTO `replenishments` (`date`, `amount`, `accounts_id`) " +
                        "VALUES ('%s','%f','%d')",
                replenishment.getDate(), replenishment.getAmount(), replenishment.getAccounts_id());
        replenishment.setId(executeCreate(sql));
        return replenishment.getId() > 0;
    }

    @Override
    public boolean update(Replenishment replenishment) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `replenishments` " +
                        "SET `date`='%s', `amount`='%f', `accounts_id`='%d' WHERE `id`='%d'",
                replenishment.getDate(), replenishment.getAmount(),
                replenishment.getAccounts_id(), replenishment.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Replenishment replenishment) throws SQLException {
        String sql = String.format(
                "DELETE FROM `replenishments` WHERE `id`='%d'", replenishment.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Replenishment> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Replenishment> getAll(String where) throws SQLException {
        List<Replenishment> replenishments = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `replenishments` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Replenishment replenishment = new Replenishment();
                replenishment.setId(resultSet.getLong("id"));
                replenishment.setDate(resultSet.getTimestamp("date"));
                replenishment.setAmount(resultSet.getDouble("amount"));
                replenishment.setAccounts_id(resultSet.getLong("accounts_id"));
                replenishments.add(replenishment);
            }
        }
        return replenishments;
    }
}
