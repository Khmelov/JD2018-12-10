package by.it.naron.jd03_02;

import by.it.naron.jd03_02.tools.Connect;
import by.it.naron.jd03_02.beans.*;
import by.it.naron.jd03_02.crudOperations.*;

import java.sql.*;
import java.util.Scanner;

public class TaskC {
    private static void deleteTables() {
        try (Statement statement = Connect.getConnection().createStatement()) {
            statement.executeUpdate("DROP DATABASE IF EXISTS `naron` ;");

//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`orders`;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`goods_flower`;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`users`;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`roles` ;");
            System.out.println("tables deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables() {
        try (Statement statement = Connect.getConnection().createStatement()) {
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `naron` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`roles` (" +
                    "  `id` int(15) NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`users` (\n" +
                    "  `id` int(15) NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(50) NULL,\n" +
                    "  `password` VARCHAR(50) NULL,\n" +
                    "  `e-mail` VARCHAR(50) NULL,\n" +
                    "  `roles_id` int(15) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `naron`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT \n" +
                    "    ON UPDATE RESTRICT )\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`goods_flower` (\n" +
                    "  `id` int(15) NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(60) NULL,\n" +
                    "  `colour` VARCHAR(45) NULL,\n" +
                    "  `size` int(15) NULL,\n" +
                    "  `price` double NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`orders` (\n" +
                    "  `id` int(15) NOT NULL AUTO_INCREMENT,\n" +
                    "  `amount` int(15) NULL,\n" +
                    "  `time_delivery` int(15) NULL,\n" +
                    "  `date_orders` timestamp NULL,\n" +
                    "  `total_price` double NULL,\n" +
                    "  `users_id` int(15) NOT NULL,\n" +
                    "  `goods_flower_id` int(15) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_orders_users1_idx` (`users_id` ASC),\n" +
                    "  INDEX `fk_orders_goods_flower1_idx` (`goods_flower_id` ASC),\n" +
                    "  CONSTRAINT `fk_orders_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `naron`.`users` (`id`)\n" +
                    "    ON DELETE cascade \n" +
                    "    ON UPDATE cascade ,\n" +
                    "  CONSTRAINT `fk_orders_goods_flower1`\n" +
                    "    FOREIGN KEY (`goods_flower_id`)\n" +
                    "    REFERENCES `naron`.`goods_flower` (`id`)\n" +
                    "    ON DELETE restrict \n" +
                    "    ON UPDATE restrict )\n" +
                    "ENGINE = InnoDB;");
            System.out.println("tables created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillTables() throws SQLException {
//
//        private static volatile Connection connection1;
//
//        if (connection1 == null || connection1.isClosed()) {
//            synchronized (Connect.class) {
//                if (connection1 == null || connection1.isClosed()) {
//                    connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/"+
//                            "?useUnicode=true&characterEncoding=UTF-8",
//                            "root","");
//                }
//            }
//        }









        /////////////////////////////////////////////
            Roles role1 = new Roles(1, "admin");
            Roles role2 = new Roles(2, "user");
            Roles role3 = new Roles(3, "guest");
            Goods_flower goodsFlower1 = new Goods_flower(1,"ros","re",5,5);
            Goods_flower goodsFlower2 = new Goods_flower(2,"ros","re",5,5);
            Goods_flower goodsFlower3 = new Goods_flower(3,"ros","re",5,5);
            Users user1 = new Users(1,"ivan","pivan","ivan@it.by",2);
            Users user2 = new Users(2, "Petr Petrovich Petrov", "petya", "petya@yandex.ru",1);
            Users user3 = new Users(3, "Василий Васильевич Васильев", "vasya", "vasya@gmail.com",3);
        Timestamp date = new Timestamp(1550582031901L);

        Orders orders1 = new Orders(1,2,4,date,2,1,5);
            Orders orders2 = new Orders(2,2,4,date,5,2,1);
            Orders orders3 = new Orders(3,2,4,date,5,2,1);

//
//            Car car1 = new Car(1, "Range Rover Sport", "black", 2012, 1);
//            Car car2 = new Car(2, "BMW X5", "white", 2015, 1);
//            Car car3 = new Car(3, "Audi A4", "blue", 2018, 2);

            UsersCrud userCRUD = new UsersCrud();
            RolesCrud rolesCrud = new RolesCrud();
            OrdersCrud ordersCrud = new OrdersCrud();
            Goods_flowerCrud goods_flowerCrud = new Goods_flowerCrud();
            rolesCrud.create(role1);
            rolesCrud.create(role2);
            rolesCrud.create(role3);
            userCRUD.create(user1);
            userCRUD.create(user2);
            userCRUD.create(user3);
            ordersCrud.create(orders1);
            ordersCrud.create(orders2);
            ordersCrud.create(orders3);
            goods_flowerCrud.create(goodsFlower1);
            goods_flowerCrud.create(goodsFlower2);
            goods_flowerCrud.create(goodsFlower3);
//            carCRUD.create(car1);
//            carCRUD.create(car2);
//            carCRUD.create(car3);
            System.out.println("tables filled");

    }

    public static void main(String[] args) throws SQLException {
//        String[] str=new String[]{"for","chek"};
//        C_Reset.main(str);
//        try (Statement statement = Connect.getConnection().createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM roles");
//            System.out.println("tables created");
//        } catch (SQLException e) {
//            System.err.println("no table");
//        }
        try {


            Scanner sc = new Scanner(System.in);
            String in;
            System.out.println("1 - delete tables\n2 - create  tables\n"
                    //             "3 - fill tables\n"
            );
            in = sc.nextLine();
            int op = Integer.parseInt(in);
            switch (op) {
                case 1:
                    deleteTables();
                    break;
                case 2:
                    createTables();
                    break;
//            case 3:
//                fillTables();
//                break;
                default:
                    System.out.println("wrong command");
            }
        }catch (Exception e){
            System.out.println("not actions");
        }

    }
}
