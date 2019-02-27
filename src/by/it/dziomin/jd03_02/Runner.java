package by.it.dziomin.jd03_02;

import by.it.dziomin.jd03_02.beans.Cars;
import by.it.dziomin.jd03_02.beans.Rents;
import by.it.dziomin.jd03_02.beans.Roles;
import by.it.dziomin.jd03_02.beans.Users;
import by.it.dziomin.jd03_02.crud.CarsCRUD;
import by.it.dziomin.jd03_02.crud.RentsCRUD;
import by.it.dziomin.jd03_02.crud.RolesCRUD;
import by.it.dziomin.jd03_02.crud.UsersCRUD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        new DBConnector();
        System.out.println("*****RolesCRUD***************");
        RolesCRUD roleCRUD = new RolesCRUD();
        Roles role = new Roles(0, "TestRole");
        if (roleCRUD.create(role)) {
            System.out.println("CREATEGOODSFLOWER OK: " + role);
        }
        role.setName("TestRoleUpdate");
        if (roleCRUD.update(role)) {
            System.out.println("UPDATE OK: " + role);
        }
        role = roleCRUD.read(role.getId());
        if (role != null)
            System.out.println("READ OK: " + role);
        if (roleCRUD.delete(role))
            System.out.println("DELETE OK: " + role);

        System.out.println("\n*****UsersCRUD***************");
        UsersCRUD usersCRUD = new UsersCRUD();
        Users user = new Users(0, "TestUser", "xx99999", "+37529994459235", 1);
        if (usersCRUD.create(user)) {
            System.out.println("CREATEGOODSFLOWER OK: " + user);
        }
        user.setPassport("pp989898");
        user.setPhone("+37529111111111");
        if (usersCRUD.update(user)) {
            System.out.println("UPDATE OK: " + user);
        }
        user = usersCRUD.read(user.getId());
        if (user != null)
            System.out.println("READ OK: " + user);
        if (usersCRUD.delete(user))
            System.out.println("DELETE OK: " + user);

        System.out.println("\n*****CarsCRUD***************");
        CarsCRUD carsCRUD = new CarsCRUD();
        Cars car = new Cars(0, "TestCar", "123456-7", "2.0", "manual");
        if (carsCRUD.create(car)) {
            System.out.println("CREATEGOODSFLOWER OK: " + car);
        }
        car.setName("TestCarUpdate");
        car.setTransmission("auto");
        if (carsCRUD.update(car)) {
            System.out.println("UPDATE OK: " + car);
        }
        car = carsCRUD.read(car.getId());
        if (car != null)
            System.out.println("READ OK: " + car);
        if (carsCRUD.delete(car))
            System.out.println("DELETE OK: " + car);

        System.out.println("\n*****RentsCRUD***************");
        RentsCRUD rentsCRUD = new RentsCRUD();
        Rents rent = new Rents(0, 999999999, 100.00, 1, 2,1);
        if (rentsCRUD.create(rent)) {
            System.out.println("CREATEGOODSFLOWER OK: " + rent);
        }
        rent.setPrice(20.52);
        rent.setIsOpen(0);
        if (rentsCRUD.update(rent)) {
            System.out.println("UPDATE OK: " + rent);
        }
        rent = rentsCRUD.read(rent.getId());
        if (rent != null)
            System.out.println("READ OK: " + rent);
        if (rentsCRUD.delete(rent))
            System.out.println("DELETE OK: " + rent);
               
        setCorrectDate();
               
    }
    
    public static void setCorrectDate() {
        try {
            DBConnector.getStatement().executeUpdate("UPDATE rent SET date = null WHERE 1;");
            DBConnector.getStatement().executeUpdate("alter table rent modify date date null;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
