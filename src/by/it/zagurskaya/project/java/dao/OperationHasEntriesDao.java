package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.OperationHasEntries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperationHasEntriesDao extends AbstractDao implements Dao<OperationHasEntries> {
    @Override
    public boolean create(OperationHasEntries operationHasEntries) throws SQLException {
        String sql = String.format(
                "INSERT INTO `operationHasEntries`(`operationId`, `entryId`) VALUES ('%s','%s')",
                operationHasEntries.getOperationId(), operationHasEntries.getEntryId());
        operationHasEntries.setId(executeCreate(sql));
        return operationHasEntries.getId() > 0;
    }
    @Override
    public OperationHasEntries read(long id) throws SQLException {
        List<OperationHasEntries> operationHasEntries = getAll(" WHERE id=" + id);
        return operationHasEntries.size() == 0 ? null : operationHasEntries.get(0);
    }
//    public OperationHasEntries readOperationAndEntry(long operationId, long entryId) throws SQLException {
//        List<OperationHasEntries> operationHasEntries = getAll(" WHERE operationId=" + operationId+" AND "+"entryId="+entryId);
//        return operationHasEntries.size() == 0 ? null : operationHasEntries.get(0);
//    }

    @Override
    public boolean update(OperationHasEntries operationHasEntries) throws SQLException {
        String sql = String.format(
                "UPDATE `operationHasEntries` SET `operationId`='%d', `entryId`='%d', WHERE `id`='%d'",
                operationHasEntries.getOperationId(), operationHasEntries.getEntryId(), operationHasEntries.getId());
//        return executeUpdate(sql);
        return false;
    }
//    public boolean updateOperationAndEntry(OperationHasEntries operationHasEntries) throws SQLException {
//        String sql = String.format(
//                "UPDATE `operationHasEntries` SET `operationId`='%d', `idEntry`='%d', WHERE `operationId`='%d' AND `idEntry`='%d'",
//                operationHasEntries.getOperationId(), operationHasEntries.getEntryId(), operationHasEntries.getOperationId(), operationHasEntries.getEntryId());
//        return executeUpdate(sql);
//    }

    @Override
    public boolean delete(OperationHasEntries operationHasEntries) throws SQLException {
        String sql = String.format(
                "DELETE FROM `operationHasEntries` WHERE `id`='%d'",
                operationHasEntries.getId());
        return executeUpdate(sql);
    }
//    public boolean deleteOperationAndEntry(OperationHasEntries operationHasEntries) throws SQLException {
//        String sql = String.format(
//                "DELETE FROM `operationHasEntries` WHERE `operationId`='%d' AND `idEntry`='%d'",
//                operationHasEntries.getOperationId(),operationHasEntries.getEntryId());
//        return executeUpdate(sql);
//    }
    @Override
    public List<OperationHasEntries> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<OperationHasEntries> getAll(String where) throws SQLException {
        List<OperationHasEntries> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `operationHasEntries` " + where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                OperationHasEntries operationHasEntries = new OperationHasEntries();
                operationHasEntries.setId(resultSet.getLong("id"));
                operationHasEntries.setOperationId(resultSet.getLong("operationId"));
                operationHasEntries.setEntryId(resultSet.getLong("entryId"));
                result.add(operationHasEntries);
            }
        }
        return result;
    }

}
