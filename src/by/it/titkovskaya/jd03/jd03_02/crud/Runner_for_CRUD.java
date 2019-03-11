package by.it.titkovskaya.jd03.jd03_02.crud;

import by.it.titkovskaya.jd03.jd03_02.beans.*;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner_for_CRUD {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD = new UserCRUD();
        User user = new User(0, "testUser", "testPassword", "testEmail", "testName", 2);
        if (userCRUD.create(user))
            System.out.println("CREATE OK: " + user);
        user.setLogin("testUserUpdate");
        if (userCRUD.update(user))
            System.out.println("UPDATE OK: " + user);
        user = userCRUD.read(user.getId());
        if (user != null)
            System.out.println("READ OK: " + user);
        if (userCRUD.delete(user))
            System.out.println("DELETE OK: " + user);

        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role(0, "testRole");
        if (roleCRUD.create(role))
            System.out.println("CREATE OK: " + role);
        role.setRole("testRoleUpdate");
        if (roleCRUD.update(role))
            System.out.println("UPDATE OK: " + role);
        role = roleCRUD.read(role.getId());
        if (role != null)
            System.out.println("READ OK: " + role);
        if (roleCRUD.delete(role))
            System.out.println("DELETE OK: " + role);

        AccountStatusCRUD statusCRUD = new AccountStatusCRUD();
        AccountStatus status = new AccountStatus(0, "testStatus");
        if (statusCRUD.create(status))
            System.out.println("CREATE OK: " + status);
        status.setStatus("testStatusUpdate");
        if (statusCRUD.update(status))
            System.out.println("UPDATE OK: " + status);
        status = statusCRUD.read(status.getId());
        if (status != null)
            System.out.println("READ OK: " + status);
        if (statusCRUD.delete(status))
            System.out.println("DELETE OK: " + status);

        AccountCRUD accountCRUD = new AccountCRUD();
        Account account = new Account(0, 999999999, "testCurrency", 3, 2, 1);
        if (accountCRUD.create(account))
            System.out.println("CREATE OK: " + account);
        account.setAccount_status_id(2);
        if (accountCRUD.update(account))
            System.out.println("UPDATE OK: " + account);
        account = accountCRUD.read(account.getId());
        if (account != null)
            System.out.println("READ OK: " + account);
        if (accountCRUD.delete(account))
            System.out.println("DELETE OK: " + account);

        ReplenishmentCRUD replenishmentCRUD = new ReplenishmentCRUD();
        Timestamp date = new Timestamp(1550582031901L);
        Replenishment replenishment = new Replenishment(0, date, 10000, 3);
        if (replenishmentCRUD.create(replenishment))
            System.out.println("CREATE OK: " + replenishment);
        replenishment.setAmount(12000);
        if (replenishmentCRUD.update(replenishment))
            System.out.println("UPDATE OK: " + replenishment);
        replenishment = replenishmentCRUD.read(replenishment.getId());
        if (replenishment != null)
            System.out.println("READ OK: " + replenishment);
        if (replenishmentCRUD.delete(replenishment))
            System.out.println("DELETE OK: " + replenishment);

        PaymentCRUD paymentCRUD = new PaymentCRUD();
        Timestamp payDate = new Timestamp(1550585710494L);
        Payment payment = new Payment(0, payDate, 8000, "stock company XXX", 3);
        if (paymentCRUD.create(payment))
            System.out.println("CREATE OK: " + payment);
        payment.setAmount(12000);
        if (paymentCRUD.update(payment))
            System.out.println("UPDATE OK: " + payment);
        payment = paymentCRUD.read(payment.getId());
        if (payment != null)
            System.out.println("READ OK: " + payment);
        if (paymentCRUD.delete(payment))
            System.out.println("DELETE OK: " + payment);
    }
}
