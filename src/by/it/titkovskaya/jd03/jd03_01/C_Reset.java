package by.it.titkovskaya.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {

    void reset(){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "");
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate("DROP TABLE IF EXISTS `titkovskaya`.`replenishments` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `titkovskaya`.`payments` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `titkovskaya`.`accounts` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `titkovskaya`.`account status` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `titkovskaya`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `titkovskaya`.`roles` ;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `titkovskaya` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
