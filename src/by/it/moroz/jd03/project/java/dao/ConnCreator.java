package by.it.moroz.jd03.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnCreator {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/moroz" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }
    
    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                synchronized (ConnCreator.class) {
                    if (connection == null || connection.isClosed()) {
                        connection = DriverManager.getConnection(
                                URL, USER, PASSWORD
                        );
                    }
                }

            }
        return connection;
    }
}
