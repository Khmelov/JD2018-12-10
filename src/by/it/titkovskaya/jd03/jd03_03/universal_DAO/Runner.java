package by.it.titkovskaya.jd03.jd03_03.universal_DAO;

import by.it.titkovskaya.jd03.jd03_03.beans.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        UniversalDao<User> dao = new UniversalDao<>(User.class,"users");
        User user = new User(0,"TestLogin","00000","Test@email","Agent000",1);

        List<User> users = dao.getAll();
        if (users.size() > 0)
            System.out.println("\nREAD OK: " + users);
        if (dao.create(user))
            System.out.println("CREATEGOODSFLOWER OK: " + user);
        user.setEmail("test@user");
        if (dao.update(user))
            System.out.println("UPDATE OK: " + user);
        if (dao.delete(user))
            System.out.println("DELETE OK: " + users);

        UniversalDao<Role> daoRole = new UniversalDao<>(Role.class,"roles");

        Role role = new Role();
        List<Role> roles = daoRole.getAll();
        if (roles.size() > 0)
            System.out.println("\nREAD OK: " + roles);
        if (daoRole.create(role))
            System.out.println("CREATE OK: " + role);
        role.setRole("moderator");
        if (daoRole.update(role))
            System.out.println("UPDATE OK: " + role);
        if (daoRole.delete(role))
            System.out.println("DELETE OK: " + roles);

        UniversalDao<Account> daoAccount = new UniversalDao<>(Account.class,"accounts");

        Account account = new Account();
        List<Account> accounts = daoAccount.getAll();
        if (accounts.size() > 0)
            System.out.println("\nREAD OK: " + accounts);
        account.setUsers_id(3);
        account.setAccount_status_id(2);
        if (daoAccount.create(account))
            System.out.println("CREATE OK: " + account);
        account.setCurrency("BYN");
        if (daoAccount.update(account))
            System.out.println("UPDATE OK: " + account);
        if (daoAccount.delete(account))
            System.out.println("DELETE OK: " + accounts);

        UniversalDao<Replenishment> daoReplenishment = new UniversalDao<>(Replenishment.class,"replenishments");

        Replenishment replenishment = new Replenishment();
        List<Replenishment> replenishments = daoReplenishment.getAll();
        if (replenishments.size() > 0)
            System.out.println("\nREAD OK: " + replenishments);
        replenishment.setAccounts_id(3);
        replenishment.setDate(Timestamp.valueOf("2019-02-21 18:00:00"));
        if (daoReplenishment.create(replenishment))
            System.out.println("CREATE OK: " + replenishment);
        replenishment.setAmount(40000);
        if (daoReplenishment.update(replenishment))
            System.out.println("UPDATE OK: " + replenishment);
        if (daoReplenishment.delete(replenishment))
            System.out.println("DELETE OK: " + replenishments);

        UniversalDao<Payment> daoPayment = new UniversalDao<>(Payment.class,"payments");
        
        Payment payment = new Payment();
        List<Payment> payments = daoPayment.getAll();
        if (payments.size() > 0)
            System.out.println("\nREAD OK: " + payments);
        payment.setAccounts_id(3);
        com.sun.jmx.snmp.Timestamp timestamp = new com.sun.jmx.snmp.Timestamp();
        Timestamp payDate = new Timestamp(timestamp.getDateTime());
        payment.setDate(payDate);
        if (daoPayment.create(payment))
            System.out.println("CREATE OK: " + payment);
        payment.setAmount(35000);
        if (daoPayment.update(payment))
            System.out.println("UPDATE OK: " + payment);
        if (daoPayment.delete(payment))
            System.out.println("DELETE OK: " + payments);

        UniversalDao<AccountStatus> daoStatus = new UniversalDao<>(AccountStatus.class,"account status");
        
        AccountStatus status = new AccountStatus();
        List<AccountStatus> statuses = daoStatus.getAll();
        if (statuses.size() > 0)
            System.out.println("\nREAD OK: " + statuses);
        if (daoStatus.create(status))
            System.out.println("CREATE OK: " + status);
        status.setStatus("TESTstatus");
        if (daoStatus.update(status))
            System.out.println("UPDATE OK: " + status);
        if (daoStatus.delete(status))
            System.out.println("DELETE OK: " + statuses);

    }
}
