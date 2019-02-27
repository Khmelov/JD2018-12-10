package by.it.zagurskaya.project.java.init;

//import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    public void reset(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
//            boolean b = true;
//            if (b) {
//                throw new SQLException("hello");
//            }
               statement.executeUpdate("DROP SCHEMA IF EXISTS `zagurskaya` ;");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`usersEntrys`;");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`kassa`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`duties`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`usersOperations`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`operation_has_entrys`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`sprOperations`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`sprEntrys`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`rateCB`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`rateNB`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`accaunts`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`currencys`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`users`");
//            statement.executeUpdate("DROP TABLE `zagurskaya`.`roles`");
        }
    }
}
