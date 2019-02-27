package by.it.zagurskaya.project.java.beans;

public class SprEntries implements Entity {
    private long id;
    private String name;
    private long currencyId;
    private String accountDebit;
    private String accountCredit;
    private boolean isSpending;
    private double rate;

    public SprEntries() {
    }

    public SprEntries(long id, String name, long currencyId, String accountDebit, String accountCredit, boolean isSpending, double rate) {
        this.id = id;
        this.name = name;
        this.currencyId = currencyId;
        this.accountDebit = accountDebit;
        this.accountCredit = accountCredit;
        this.isSpending = isSpending;
        this.rate = rate;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public String getAccountDebit() {
        return accountDebit;
    }

    public void setAccountDebit(String accountDebit) {
        this.accountDebit = accountDebit;
    }

    public String getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(String accountCredit) {
        this.accountCredit = accountCredit;
    }

    public boolean getIsSpending() {
        return isSpending;
    }

    public void setIsSpending(boolean isSpending) {
        this.isSpending = isSpending;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "SprEntries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currencyId=" + currencyId +
                ", accountDebit='" + accountDebit + '\'' +
                ", accountCredit='" + accountCredit + '\'' +
                ", isSpending=" + isSpending +
                ", rate=" + rate +
                '}';
    }
}
