package by.it.titkovskaya.project.java.beans;

public class Account {

    private long id;
    private long number;
    private String currency;
    private long users_id;
    private long account_status_id;
    private int unlock_request;

    public Account() {
    }

    public Account(long id, long number, String currency, long users_id, long account_status_id, int unlock_request) {
        this.id = id;
        this.number = number;
        this.currency = currency;
        this.users_id = users_id;
        this.account_status_id = account_status_id;
        this.unlock_request = unlock_request;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public long getAccount_status_id() {
        return account_status_id;
    }

    public void setAccount_status_id(long account_status_id) {
        this.account_status_id = account_status_id;
    }

    public int getUnlock_request() {
        return unlock_request;
    }

    public void setUnlock_request(int unlock_request) {
        this.unlock_request = unlock_request;
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "id=" + id +
                ", number=" + number +
                ", currency='" + currency + '\'' +
                ", users_id=" + users_id +
                ", account_status_id=" + account_status_id +
                ", unlock_request=" + unlock_request +
                '}';
    }
}
