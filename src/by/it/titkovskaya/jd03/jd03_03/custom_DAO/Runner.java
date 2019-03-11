package by.it.titkovskaya.jd03.jd03_03.custom_DAO;

import by.it.titkovskaya.jd03.jd03_03.beans.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();

        User user = new User();
        List<User> users = dao.user.getAll();
        if (users.size() > 0)
            System.out.println("\nREAD OK: " + users);
        user.setRoles_id(3);
        if (dao.user.create(user))
            System.out.println("CREATE OK: " + user);
        user.setEmail("test@user");
        if (dao.user.update(user))
            System.out.println("UPDATE OK: " + user);
        if (dao.user.delete(user))
            System.out.println("DELETE OK: " + users);

        Role role = new Role();
        List<Role> roles = dao.role.getAll();
        if (roles.size() > 0)
            System.out.println("\nREAD OK: " + roles);
        if (dao.role.create(role))
            System.out.println("CREATE OK: " + role);
        role.setRole("moderator");
        if (dao.role.update(role))
            System.out.println("UPDATE OK: " + role);
        if (dao.role.delete(role))
            System.out.println("DELETE OK: " + roles);

        Account account = new Account();
        List<Account> accounts = dao.account.getAll();
        if (accounts.size() > 0)
            System.out.println("\nREAD OK: " + accounts);
        account.setUsers_id(3);
        account.setAccount_status_id(2);
        if (dao.account.create(account))
            System.out.println("CREATE OK: " + account);
        account.setAccount_status_id(2);
        if (dao.account.update(account))
            System.out.println("UPDATE OK: " + account);
        if (dao.account.delete(account))
            System.out.println("DELETE OK: " + accounts);

        Replenishment replenishment = new Replenishment();
        List<Replenishment> replenishments = dao.replenishment.getAll();
        if (replenishments.size() > 0)
            System.out.println("\nREAD OK: " + replenishments);
        replenishment.setAccounts_id(3);
        replenishment.setDate(Timestamp.valueOf("2019-02-21 18:00:00"));
        if (dao.replenishment.create(replenishment))
            System.out.println("CREATE OK: " + replenishment);
        replenishment.setAmount(40000);
        if (dao.replenishment.update(replenishment))
            System.out.println("UPDATE OK: " + replenishment);
        if (dao.replenishment.delete(replenishment))
            System.out.println("DELETE OK: " + replenishments);

        Payment payment = new Payment();
        List<Payment> payments = dao.payment.getAll();
        if (payments.size() > 0)
            System.out.println("\nREAD OK: " + payments);
        payment.setAccounts_id(3);
        com.sun.jmx.snmp.Timestamp timestamp = new com.sun.jmx.snmp.Timestamp();
        Timestamp payDate = new Timestamp(timestamp.getDateTime());
        payment.setDate(payDate);
        if (dao.payment.create(payment))
            System.out.println("CREATE OK: " + payment);
        payment.setAmount(35000);
        if (dao.payment.update(payment))
            System.out.println("UPDATE OK: " + payment);
        if (dao.payment.delete(payment))
            System.out.println("DELETE OK: " + payments);

        AccountStatus status = new AccountStatus();
        List<AccountStatus> statuses = dao.status.getAll();
        if (statuses.size() > 0)
            System.out.println("\nREAD OK: " + statuses);
        if (dao.status.create(status))
            System.out.println("CREATE OK: " + status);
        status.setStatus("TESTstatus");
        if (dao.status.update(status))
            System.out.println("UPDATE OK: " + status);
        if (dao.status.delete(status))
            System.out.println("DELETE OK: " + statuses);
    }
}

