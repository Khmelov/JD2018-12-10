package by.it.skosirskiy.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class C_Reset {


     void deleteTables() {
        try (
                Connection connection=
                        DriverManager.getConnection
                                (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                Statement statement=connection.createStatement()) {
            //вставляем пользователей


            statement.executeUpdate("DROP TABLE `skosirskiy`.`requests`;");
            statement.executeUpdate("DROP TABLE `skosirskiy`.`users`;");
            statement.executeUpdate("DROP TABLE `skosirskiy`.`roles`;");
            statement.executeUpdate("DROP TABLE `skosirskiy`.`statuses`;");
            statement.executeUpdate("DROP TABLE `skosirskiy`.`address`;");
            statement.executeUpdate("DROP DATABASE IF EXISTS `skosirskiy`;");


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
