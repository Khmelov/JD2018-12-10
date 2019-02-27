package by.it.skosirskiy.jd03_02;

import by.it.skosirskiy.jd03_02.beans.*;

import java.sql.SQLException;
import java.sql.Timestamp;

public class TaskC {
    public static void main(String[] args) throws SQLException {
        Timestamp timestamp_create=Timestamp.valueOf("2019-02-11 11:45:00");
        Timestamp timestamp_complete=Timestamp.valueOf("2019-02-20 11:45:00");
        Role addRole = new Role(
                0,
                "guest");
        User addUser = new User(
                0,
                "edik",
                "edik",
                "edik@gmail.com",
                3);

        Request addRequest = new Request(
                0,
                "fix phone",
                timestamp_create,
                timestamp_complete,
                3,
                1,
                1);
        Status addStatus= new Status(
                0,
                "shifted"
        );
        Address addAddress= new Address(
                0,
                "minsk",
                "naberejnaya",
                "11B",
                4);

        RoleCRUD roleCRUD = new RoleCRUD();
        if (roleCRUD.create(addRole))
            System.out.println("CREATE OK: " + addRole);
        UserCRUD userCRUD = new UserCRUD();
        if (userCRUD.create(addUser))
            System.out.println("CREATE OK: " + addUser);

        RequestCRUD requestCRUD = new RequestCRUD();
        if (requestCRUD.create(addRequest))
            System.out.println("CREATE OK: " + addRequest);

        StatusCRUD statusCRUD = new StatusCRUD();
        if (statusCRUD.create(addStatus))
            System.out.println("CREATE OK: " + addStatus);

        AddressCRUD addressCRUD = new AddressCRUD();
        if (addressCRUD.create(addAddress))
            System.out.println("CREATE OK: " + addAddress);

    }
}
