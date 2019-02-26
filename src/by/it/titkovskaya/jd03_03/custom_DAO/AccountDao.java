package by.it.titkovskaya.jd03_03.custom_DAO;

import by.it.titkovskaya.jd03_03.beans.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends AbstractDao implements InterfaceDao<Account> {

    @Override
    public Account read(long id) throws SQLException {
        List<Account> accounts = getAll(" WHERE `id`=" + id);
        return accounts.size() == 1 ? accounts.get(0) : null;
    }

    @Override
    public boolean create(Account account) throws SQLException {
        String sql = String.format("INSERT INTO `accounts` (`number`,`currency`,`users_id`,`account_status_id`) " +
                        "VALUES ('%d','%s','%s', '%d')",
                account.getNumber(), account.getCurrency(), account.getUsers_id(), account.getAccount_status_id());
        account.setId(executeCreate(sql));
        return account.getId() > 0;
    }

    @Override
    public boolean update(Account account) throws SQLException {
        String sql = String.format("UPDATE `accounts` " +
                        "SET `currency`='%s' WHERE `id`='%d'",
                account.getCurrency(), account.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Account account) throws SQLException {
        String sql = String.format(
                "DELETE FROM `accounts` WHERE `id`='%d'", account.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Account> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Account> getAll(String where) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `accounts` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setNumber(resultSet.getLong("number"));
                account.setCurrency(resultSet.getString("currency"));
                account.setUsers_id(resultSet.getLong("users_id"));
                account.setAccount_status_id(resultSet.getLong("account_status_id"));
                accounts.add(account);
            }
        }
        return accounts;
    }
}
