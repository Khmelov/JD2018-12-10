package by.it.zagurskaya.project.java.beans;

public class Account implements Entity{
    private long id;
    private String mask;
    private String subMask;
    private long currencyId;
    private String fullAccount;


    public Account() {
    }

    public Account(long id, String mask, String subMask, long currencyId, String fullAccount) {
        this.id = id;
        this.mask = mask;
        this.subMask = subMask;
        this.currencyId = currencyId;
        this.fullAccount = fullAccount;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getSubMask() {
        return subMask;
    }

    public void setSubMask(String subMask) {
        this.subMask = subMask;
    }

    public long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public String getFullAccount() {
        return fullAccount;
    }

    public void setFullAccount(String fullAccount) {
        this.fullAccount = fullAccount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", mask='" + mask + '\'' +
                ", subMask='" + subMask + '\'' +
                ", currencyId=" + currencyId +
                ", fullAccount='" + fullAccount + '\'' +
                '}';
    }
}