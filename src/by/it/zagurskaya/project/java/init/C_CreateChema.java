package by.it.zagurskaya.project.java.init;

//import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_CreateChema {

    public void reset(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
//            boolean b = true;
//            if (b) {
//                throw new SQLException("hello");
//            }
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zagurskaya` DEFAULT CHARACTER SET utf8 ;");
        }
    }
}
