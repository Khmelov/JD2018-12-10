package by.it.zagurskaya.project.java.beans;

import java.sql.Timestamp;

public class UserOperation implements Entity {
    private long id;
    private Timestamp timestamp;
    private double rate;
    private double sum;
    private long currencyId;
    private long userId;
    private long OperationId;
    private String specification;
    private String checkingAccount;

    public UserOperation() {
    }

    public UserOperation(long id, Timestamp timestamp, double rate, double sum, long currencyId, long userId, long operationId, String specification, String checkingAccount) {
        this.id = id;
        this.timestamp = timestamp;
        this.rate = rate;
        this.sum = sum;
        this.currencyId = currencyId;
        this.userId = userId;
        OperationId = operationId;
        this.specification = specification;
        this.checkingAccount = checkingAccount;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOperationId() {
        return OperationId;
    }

    public void setOperationId(long operationId) {
        OperationId = operationId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(String checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    @Override
    public String toString() {
        return "UserOperation{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", rate=" + rate +
                ", sum=" + sum +
                ", currencyId=" + currencyId +
                ", userId=" + userId +
                ", OperationId=" + OperationId +
                ", specification='" + specification + '\'' +
                ", checkingAccount='" + checkingAccount + '\'' +
                '}';
    }
}
