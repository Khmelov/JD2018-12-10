package by.it.titkovskaya.jd03.jd03_03.custom_DAO;

import by.it.titkovskaya.jd03.jd03_03.beans.AccountStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountStatusDao extends AbstractDao implements InterfaceDao<AccountStatus> {

    @Override
    public AccountStatus read(long id) throws SQLException {
        List<AccountStatus> statuses = getAll(" WHERE `id`=" + id);
        return statuses.size() == 1 ? statuses.get(0) : null;
    }

    @Override
    public boolean create(AccountStatus status) throws SQLException {
        String sql = String.format("INSERT INTO `account status` (`status`) VALUES ('%s')",
                status.getStatus());
        status.setId(executeCreate(sql));
        return status.getId() > 0;
    }

    @Override
    public boolean update(AccountStatus status) throws SQLException {
        String sql = String.format("UPDATE `account status` " +
                        "SET `status`='%s' WHERE `id`='%d'",
                status.getStatus(), status.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(AccountStatus status) throws SQLException {
        String sql = String.format(
                "DELETE FROM `account status` WHERE `id`='%d'", status.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<AccountStatus> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<AccountStatus> getAll(String where) throws SQLException {
        List<AccountStatus> statuses = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `account status` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                AccountStatus status = new AccountStatus();
                status.setId(resultSet.getLong("id"));
                status.setStatus(resultSet.getString("status"));
                statuses.add(status);
            }
        }
        return statuses;
    }
}
