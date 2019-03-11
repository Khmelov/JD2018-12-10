package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

class AccBalance {

    static HashMap<Long, Double> getAccBalances(List<Account> accounts) throws SQLException {
        HashMap<Long,Double> balances = new HashMap<>();
        for (Account account : accounts) {
            long id = account.getId();
            double balance = getAccBalance(account);
            balances.put(id,balance);
        }
        return balances;
    }

    static double getAccBalance(Account account) throws SQLException {
        long id = account.getId();
        Dao dao = Dao.getDao();
        double replenByAcc = dao.replenishment.getTotalReplenishmentForAccount(id);
        double paymentByAcc = dao.payment.getTotalPaymentForAccount(id);
        return replenByAcc - paymentByAcc;
    }

}
