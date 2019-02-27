package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.SprOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SprOperationsDao extends AbstractDao implements Dao<SprOperations> {
    @Override
    public boolean create(SprOperations sprOperations) throws SQLException {
        String sql = String.format(
                "INSERT INTO `sprOperations`(`id`, `name`, `printForm`, `screenForm`, `specification`) VALUES ('%s','%s','%s','%s','%s')",
                sprOperations.getId(), sprOperations.getName(), sprOperations.getPrintForm(), sprOperations.getScreenForm(), sprOperations.getSpecification());
//        System.out.println(sql);
        long result = executeCreate(sql);
        return result == 0;
    }

    @Override
    public SprOperations read(long id) throws SQLException {
        List<SprOperations> sprOperations = getAll(" WHERE id=" + id);
        return sprOperations.size() == 0 ? null : sprOperations.get(0);
    }

    @Override
    public boolean update(SprOperations sprOperations) throws SQLException {
          String sql = String.format(
                  "UPDATE `sprOperations` SET `name`='%s', `printForm`='%s',`screenForm`='%s' ,`specification`='%s',`id`='%d'  WHERE `id`='%d'",
                  sprOperations.getName(), sprOperations.getPrintForm(), sprOperations.getScreenForm(), sprOperations.getSpecification(), sprOperations.getId(), sprOperations.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(SprOperations sprOperations) throws SQLException {
        String sql = String.format(
                "DELETE FROM `sprOperations` WHERE `id`='%s'",
                sprOperations.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<SprOperations> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<SprOperations> getAll(String where) throws SQLException {
        List<SprOperations> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `sprOperations` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SprOperations sprOperations = new SprOperations();
                sprOperations.setId(resultSet.getLong("id"));
                sprOperations.setName(resultSet.getString("name"));
                sprOperations.setPrintForm(resultSet.getString("printForm"));
                sprOperations.setScreenForm(resultSet.getString("screenForm"));
                sprOperations.setSpecification(resultSet.getString("specification"));
                result.add(sprOperations);
            }
        }
        return result;
    }

}
