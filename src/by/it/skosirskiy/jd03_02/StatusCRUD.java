package by.it.skosirskiy.jd03_02;

import by.it.skosirskiy.jd03_02.beans.Status;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatusCRUD {


    boolean create(Status status) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `statuses`(`id`,`status`) " +
                            "VALUES ('%d','%s')",
                    status.getId(), status.getStatus());
            System.out.println(sql);
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    status.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Status read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `statuses` WHERE `id`='%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);


            if (resultSet.next()) {
                Status status= new Status();
                status.setId(resultSet.getLong("id"));
                status.setStatus(resultSet.getString("status"));
                return status;
            }

        }
        return null;
    }


    boolean update(Status status) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `statuses` " +
                            "SET `status`='%s'" +
                            "WHERE `id`='%d'",
                    status.getStatus(), status.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
    boolean delete(Status status) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `statuses` WHERE `id`='%d'",
                    status.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
