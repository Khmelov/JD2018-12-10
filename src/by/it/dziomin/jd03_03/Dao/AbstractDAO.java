package by.it.dziomin.jd03_03.Dao;

import by.it.dziomin.jd03_03.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {

    protected abstract List<T> mapResultSet(ResultSet rs) throws SQLException;

    protected long executeUpdate(String sql, List<Object> params) {
        long result = -1;
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i+1, params.get(i));
            }
            result = statement.executeUpdate();
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    result = resultSet.getLong(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result + ":" + sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }

    protected List<T> executeSelect(String sql, List<Object> params) {
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            ResultSet rs = statement.executeQuery();
            return mapResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
