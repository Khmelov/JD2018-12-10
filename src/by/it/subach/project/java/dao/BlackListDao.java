package by.it.subach.project.java.dao;


import by.it.subach.project.java.beans.BlackList;
import by.it.subach.project.java.dao.dbInit.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlackListDao extends AbstractDao implements InterfaceDao<BlackList> {

    @Override
    public boolean create(BlackList blackList) throws SQLException {
        String sql = String.format("INSERT INTO `blacklist`(`user_id`) VALUES ('%d')",
                blackList.getUser_id()
        );
        long id = executeCreate(sql);
        if (id > 0) {
            blackList.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public BlackList read(long id) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `blacklist` WHERE `id`='%d'",
                    id
            );
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                BlackList blackList = new BlackList();
                blackList.setId(resultSet.getInt("id"));
                blackList.setUser_id(resultSet.getLong("user_id"));
                return blackList;
            }
        }
        return null;
    }


    public boolean update(BlackList blackList) throws SQLException {
        String sql = String.format("UPDATE `blacklist` " +
                        "SET `user_id`='%d' WHERE `id`='%d'",
                blackList.getUser_id(),
                blackList.getId()
        );
        return executeUpdate(sql);


    }

    public boolean delete(BlackList blackList) throws SQLException {
        String sql = String.format("DELETE FROM `blacklist` WHERE `id`='%d'",
                blackList.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<BlackList> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<BlackList> getAll(String where) throws SQLException {
        List<BlackList> blackListList = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = "SELECT * FROM `blacklist` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                BlackList blackList = new BlackList();
                blackList.setId(resultSet.getInt("id"));
                blackList.setUser_id(resultSet.getLong("user_id"));
                blackListList.add(blackList);
            }
        }
        return blackListList;
    }
}
