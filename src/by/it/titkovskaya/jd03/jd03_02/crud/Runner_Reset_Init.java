package by.it.titkovskaya.jd03.jd03_02.crud;

import by.it.titkovskaya.jd03.jd03_02.beans.*;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner_Reset_Init {

    public static void main(String[] args) throws SQLException {

        C_Reset reset = new C_Reset();
        reset.reset();

        C_Init_Tables init = new C_Init_Tables();
        init.init();

        RoleCRUD roleCRUD = new RoleCRUD();
        Role role1 = new Role(0, "admin");
        Role role2 = new Role(0, "client");
        Role role3 = new Role(0, "guest");
        roleCRUD.create(role1);
        roleCRUD.create(role2);
        roleCRUD.create(role3);
        System.out.println("Created successfully:\n" + role1 + "\n" + role2 + "\n" + role3 + "\n");

        AccountStatusCRUD statusCRUD = new AccountStatusCRUD();
        AccountStatus status1 = new AccountStatus(0, "active");
        AccountStatus status2 = new AccountStatus(0, "locked");
        statusCRUD.create(status1);
        statusCRUD.create(status2);
        System.out.println("Created successfully:\n" + status1 + "\n" + status2 + "\n");

        UserCRUD userCRUD = new UserCRUD();
        User user1 = new User(0, "admin", "00000", "admin@it.by", "Samanta Jones", 1);
        User user2 = new User(0, "johnSMITH", "11111", "johnSMITH@it.by", "John Smith", 2);
        User user3 = new User(0, "janeDOUGH", "22222", "janeDOUGH@it.by", "Jane Dough", 2);
        userCRUD.create(user1);
        userCRUD.create(user2);
        userCRUD.create(user3);
        System.out.println("Created successfully:\n" + user1 + "\n" + user2 + "\n" + user3 + "\n");

        AccountCRUD accountCRUD = new AccountCRUD();
        Account account1 = new Account(0, 100000001, "USD", 2, 2, 0);
        Account account2 = new Account(0, 100000002, "BYN", 2, 1, 0);
        Account account3 = new Account(0, 100000003, "EUR", 3, 1, 0);
        accountCRUD.create(account1);
        accountCRUD.create(account2);
        accountCRUD.create(account3);
        System.out.println("Created successfully:\n" + account1 + "\n" + account2 + "\n" + account3 + "\n");

        PaymentCRUD paymentCRUD = new PaymentCRUD();
        Timestamp payDate1 = Timestamp.valueOf("2019-01-04 16:50:00");
        Timestamp payDate2 = Timestamp.valueOf("2019-01-25 12:00:00");
        Timestamp payDate3 = Timestamp.valueOf("2019-02-15 13:30:00");
        Payment payment1 = new Payment(0, payDate1, 2000, "Thales Group", 1);
        Payment payment2 = new Payment(0, payDate2, 10000, "BAE Systems", 2);
        Payment payment3 = new Payment(0, payDate3, 25000, "Thales Group", 3);
        paymentCRUD.create(payment1);
        paymentCRUD.create(payment2);
        paymentCRUD.create(payment3);
        System.out.println("Created successfully:\n" + payment1 + "\n" + payment2 + "\n" + payment3 + "\n");

        ReplenishmentCRUD replenishmentCRUD = new ReplenishmentCRUD();
        Timestamp date1 = Timestamp.valueOf("2019-01-04 15:25:00");
        Timestamp date2 = Timestamp.valueOf("2019-01-15 09:40:00");
        Timestamp date3 = Timestamp.valueOf("2019-02-02 11:30:00");
        Replenishment replenishment1 = new Replenishment(0, date1, 2000, 1);
        Replenishment replenishment2 = new Replenishment(0, date2, 30000, 2);
        Replenishment replenishment3 = new Replenishment(0, date3, 50000, 3);
        replenishmentCRUD.create(replenishment1);
        replenishmentCRUD.create(replenishment2);
        replenishmentCRUD.create(replenishment3);
        System.out.println("Created successfully:\n" + replenishment1 + "\n" + replenishment2 + "\n" + replenishment3 + "\n");
    }
}
