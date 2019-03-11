package by.it.titkovskaya.jd03.jd03_01;

import java.sql.*;
import java.util.HashMap;

class B_ShowUsers {

    void showUsers(){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "");
             Statement statement = connection.createStatement())
        {
            HashMap<Integer, String> rolesMap = new HashMap<>();
            ResultSet rolesSet = statement.executeQuery("select * from titkovskaya.roles;");
            while (rolesSet.next()){
                rolesMap.put(rolesSet.getInt("id"), rolesSet.getString("role"));
            }
            ResultSet resultSet = statement.executeQuery("select * from titkovskaya.users;");
            while (resultSet.next()){
                int role = resultSet.getInt("roles_id");
                String result = resultSet.getString("name") + ": " + rolesMap.get(role);
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
