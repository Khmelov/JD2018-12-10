package by.it.skosirskiy.jd03_02;



import by.it.skosirskiy.jd03_02.beans.Request;




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestCRUD {

    boolean create(Request request) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `requests`(`type`,`date_create`, `date_complete`,`user_id`,`status_id`,`address_id`) " +
                            "VALUES ('%s','%s','%s','%d','%d','%d')",
                    request.getType(), request.getDate_create(), request.getDate_complete(), request.getUser_id(), request.getStatus_id(), request.getAddress_id());
            System.out.println(sql);
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    request.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Request read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `requests` WHERE `id`='%d'", id);
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);


                if (resultSet.next()) {
                    Request request= new Request();
                    request.setId(resultSet.getLong("id"));
                    request.setType(resultSet.getString("type"));
                    request.setDate_create(resultSet.getTimestamp("date_create"));
                    request.setDate_complete(resultSet.getTimestamp("date_complete"));
                    request.setUser_id(resultSet.getInt("user_id"));
                    request.setStatus_id(resultSet.getInt("status_id"));
                    request.setAddress_id(resultSet.getInt("address_id"));
                    return request;
                }

        }
        return null;
    }


    boolean update(Request request) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `requests` " +
                            "SET `type`='%s',`date_create`='%s',`date_complete`='%s',`user_id`='%d' ,`status_id`='%d',`address_id`='%d'" +
                            "WHERE `id`='%d'",
                    request.getType(),  request.getDate_create(), request.getDate_complete(), request.getUser_id(),
                    request.getStatus_id(), request.getAddress_id(), request.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
    boolean delete(Request request) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `requests` WHERE `id`='%d'",
                    request.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }



}
