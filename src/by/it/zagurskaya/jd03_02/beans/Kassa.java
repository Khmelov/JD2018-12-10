package by.it.zagurskaya.jd03_02.beans;

import java.sql.Timestamp;

public class Kassa {
    private long idKassa;
    private int idCurrency;
    private double receivedCurrency;
    private double comingCurrency;
    private double spendingCurrency;
    private double hendedCurrency;
    private double balanceCurrency;
    private int numberUser;
    private Timestamp date;
    private int duties;

    public Kassa () {
    }

    public Kassa(long idKassa, int idCurrency, double receivedCurrency, double comingCurrency, double spendingCurrency, double hendedCurrency, double balanceCurrency, int numberUser, Timestamp date, int duties) {
        this.idKassa = idKassa;
        this.idCurrency = idCurrency;
        this.receivedCurrency = receivedCurrency;
        this.comingCurrency = comingCurrency;
        this.spendingCurrency = spendingCurrency;
        this.hendedCurrency = hendedCurrency;
        this.balanceCurrency = balanceCurrency;
        this.numberUser = numberUser;
        this.date = date;
        this.duties = duties;
    }

    public long getIdKassa() {
        return idKassa;
    }

    public void setIdKassa(long idKassa) {
        this.idKassa = idKassa;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public double getReceivedCurrency() {
        return receivedCurrency;
    }

    public void setReceivedCurrency(double receivedCurrency) {
        this.receivedCurrency = receivedCurrency;
    }

    public double getComingCurrency() {
        return comingCurrency;
    }

    public void setComingCurrency(double comingCurrency) {
        this.comingCurrency = comingCurrency;
    }

    public double getSpendingCurrency() {
        return spendingCurrency;
    }

    public void setSpendingCurrency(double spendingCurrency) {
        this.spendingCurrency = spendingCurrency;
    }

    public double getHendedCurrency() {
        return hendedCurrency;
    }

    public void setHendedCurrency(double hendedCurrency) {
        this.hendedCurrency = hendedCurrency;
    }

    public double getBalanceCurrency() {
        return balanceCurrency;
    }

    public void setBalanceCurrency(double balanceCurrency) {
        this.balanceCurrency = balanceCurrency;
    }

    public int getNumberUser() {
        return numberUser;
    }

    public void setNumberUser(int numberUser) {
        this.numberUser = numberUser;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getDuties() {
        return duties;
    }

    public void setDuties(int duties) {
        this.duties = duties;
    }

    @Override
    public String toString() {
        return "Kassa{" +
                "idKassa=" + idKassa +
                ", idCurrency=" + idCurrency +
                ", receivedCurrency=" + receivedCurrency +
                ", comingCurrency=" + comingCurrency +
                ", spendingCurrency=" + spendingCurrency +
                ", hendedCurrency=" + hendedCurrency +
                ", balanceCurrency=" + balanceCurrency +
                ", numberUser=" + numberUser +
                ", date=" + date +
                ", duties=" + duties +
                '}';
    }
}
