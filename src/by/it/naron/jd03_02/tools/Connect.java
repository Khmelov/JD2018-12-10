package by.it.naron.jd03_02.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect implements Config{

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(Config.DB_URL,Config.USER,Config.PASSWORD);
                }
            }
        }
        return connection;
    }
}
