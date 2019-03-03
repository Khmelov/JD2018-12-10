package by.it.zagurskaya.jd03_02;

import by.it.zagurskaya.jd03_02.beans.Role;
import by.it.zagurskaya.jd03_02.beans.User;
import by.it.zagurskaya.jd03_02.crud.RoleCRUD;
import by.it.zagurskaya.jd03_02.crud.UserCRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {

    public static void main(String[] args) throws SQLException {
//        ВАЖНО! В случае наличия \src\by\it\zagurskaya\jd03_02\Runner.java НЕ ЗАПУСКАТЬ!!!//
//        ВАЖНО! для инициализации БД вызвать \src\by\it\zagurskaya\jd03_01\Runner.java (2 РАЗА!!!!!!!!!!)
//        ВАЖНО! Далее поочередно \src\by\it\zagurskaya\jd03_02\TaskA.java -> TaskB.java -> TaskC.java




//        Поиск кода роли по имени роли
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
//           String searchRole = "admin";
            String searchRole = "kassir";
            String sql = String.format(
                    "SELECT * FROM `zagurskaya`.`roles` WHERE roleName ='%s'",
                    searchRole);
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.printf("%-11s%-11s%n", "idRole", "roleName");
            System.out.println("------------------");

            while (resultSet.next()) {
                String outidRole = resultSet.getString("idRole");
                String outroleName = resultSet.getString("roleName");
                System.out.printf("%-11s%-11s%n", outidRole, outroleName);

            }
            System.out.println();
        }
// Dao для пользователя
        RoleCRUD roleCRUD = new RoleCRUD();

        Role role = new Role(0, "TestRole");
        if (roleCRUD.create(role))
            System.out.println("CREATE OK: " + role);
        role = roleCRUD.read(role.getIdRole());
        if (role != null)
            System.out.println("READ   OK: " + role);
        System.out.println();

        UserCRUD userCRUD = new UserCRUD();

        User user = new User(0, "TestUser", "TestPassword", role.getIdRole());
        if (userCRUD.create(user))
            System.out.println("CREATE OK: " + user);
        user.setLogin("TestUserUpdate");
        if (userCRUD.update(user))
            System.out.println("UPDATE OK: " + user);
        user = userCRUD.read(user.getIdUser());
        if (user != null)
            System.out.println("READ   OK: " + user);
        if (userCRUD.delete(user))
            System.out.println("DELETE OK: " + user);


    }
}
