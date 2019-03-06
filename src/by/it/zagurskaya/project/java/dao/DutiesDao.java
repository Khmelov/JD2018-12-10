package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.Duties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DutiesDao extends AbstractDao implements Dao<Duties> {
    @Override
    public boolean create(Duties duties) throws SQLException {
        String sql = String.format(
                "INSERT INTO `duties`(`userId`, `timestamp`, `number`, `isClose`) VALUES ('%s','%s','%s','%s')",
                duties.getUserId(), duties.getTimestamp(), duties.getNumber(), duties.getIsClose() ? 1 : 0);
//        System.out.println(sql);
        duties.setId(executeCreate(sql));
        return duties.getId() > 0;
    }

    @Override
    public Duties read(long id) throws SQLException {
        List<Duties> duties = getAll(" WHERE id=" + id);
        return duties.size() == 0 ? null : duties.get(0);
    }

    @Override
    public boolean update(Duties duties) throws SQLException {
          String sql = String.format(
                  "UPDATE `duties` SET `userId`='%s', `timestamp`='%s',`number`='%s' ,`isClose`='%s',`id`='%d'  WHERE `id`='%d'",
                  duties.getUserId(), duties.getTimestamp(), duties.getNumber(), duties.getIsClose() ? 1 : 0, duties.getId(), duties.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Duties duties) throws SQLException {
        String sql = String.format(
                "DELETE FROM `duties` WHERE `id`='%s'",
                duties.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Duties> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Duties> getAll(String where) throws SQLException {
        List<Duties> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `duties` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Duties duties = new Duties();
                duties.setId(resultSet.getLong("id"));
                duties.setUserId(resultSet.getLong("userId"));
                duties.setTimestamp(resultSet.getTimestamp("timestamp"));
                duties.setNumber(resultSet.getInt("number"));
                duties.setIsClose(resultSet.getBoolean("isClose"));
                result.add(duties);
            }
        }
        return result;
    }

}
