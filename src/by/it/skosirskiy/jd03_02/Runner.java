package by.it.skosirskiy.jd03_02;


import by.it.skosirskiy.jd03_02.beans.*;

import java.sql.SQLException;
import java.sql.Timestamp;



public class Runner {
    public static void main(String[] args) throws SQLException {

        UserCRUD userCRUD = new UserCRUD();

        User user = new User(0, "TestUser", "TestEmail", "TestPassword", 3);
        if (userCRUD.create(user))
            System.out.println("CREATEGOODSFLOWER OK: " + user);
        user.setLogin("TestUserUpdate");
        if (userCRUD.update(user))
            System.out.println("UPDATE OK: " + user);
        user = userCRUD.read(user.getId());
        if (user != null)
            System.out.println("READ OK: " + user);
        if (userCRUD.delete(user))
            System.out.println("DELETE OK: " + user);

        RoleCRUD roleCRUD = new RoleCRUD();

        Role role = new Role(0, "TestRole");
        if (roleCRUD.create(role))
            System.out.println("CREATEGOODSFLOWER OK: " + role);
        role.setRole("TestRoleUpdate");
        if (roleCRUD.update(role))
            System.out.println("UPDATE OK: " + role);
        role = roleCRUD.read(role.getId());
        if (role != null)
            System.out.println("READ OK: " + role);
        if (roleCRUD.delete(role))
            System.out.println("DELETE OK: " + role);

        Timestamp timestamp_create=Timestamp.valueOf("2019-02-11 11:45:00");
        Timestamp timestamp_complete=Timestamp.valueOf("2019-02-20 11:45:00");


        RequestCRUD requestCRUD = new RequestCRUD();
        Request request = new Request(0, "no water",  timestamp_create, timestamp_complete, 2,1,2);
        if (requestCRUD.create(request))
            System.out.println("CREATE OK: " + request);
        request.setType("TestType");
        if (requestCRUD.update(request))
            System.out.println("UPDATE OK: " + request);
        request = requestCRUD.read(request.getId());
        if (request != null)
            System.out.println("READ OK: " + request);
        if (requestCRUD.delete(request))
            System.out.println("DELETE OK: " + request);



        AddressCRUD addressCRUD = new AddressCRUD();
        Address address = new Address(0, "minsk", "sadovaya", "3A",12);
        if (addressCRUD.create(address))
            System.out.println("CREATE OK: " + address);
        address.setStreet("TestStreet");
        if (addressCRUD.update(address))
            System.out.println("UPDATE OK: " + address);
        address = addressCRUD.read(address.getId());
        if (address != null)
            System.out.println("READ OK: " + address);
        if (addressCRUD.delete(address))
            System.out.println("DELETE OK: " + address);

        StatusCRUD statusCRUD = new StatusCRUD();
        Status status = new Status(0, "TestStatus");
        if (statusCRUD.create(status))
            System.out.println("CREATE OK: " + status);
        status.setStatus("TestStreet");
        if (statusCRUD.update(status))
            System.out.println("UPDATE OK: " + status);
        status = statusCRUD.read(status.getId());
        if (status != null)
            System.out.println("READ OK: " + status);
        if (statusCRUD.delete(status))
            System.out.println("DELETE OK: " + status);


    }

}
