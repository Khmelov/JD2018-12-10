package by.it.skosirskiy.jd03_02;

import java.sql.Connection;
;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    public static void main(String[] args) throws SQLException {
        deleteTables();
    }

     static void deleteTables() throws SQLException {

            try (Connection connection = ConnCreator.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("DROP TABLE IF EXISTS `skosirskiy`.`requests`;");
                statement.executeUpdate("DROP TABLE IF EXISTS `skosirskiy`.`requests`;");
                statement.executeUpdate("DROP TABLE IF EXISTS `skosirskiy`.`users`;");
                statement.executeUpdate("DROP TABLE IF EXISTS `skosirskiy`.`roles`;");
                statement.executeUpdate("DROP TABLE IF EXISTS `skosirskiy`.`statuses`;");
                statement.executeUpdate("DROP TABLE IF EXISTS `skosirskiy`.`address`;");
            }






    }
}
