package net.safty.model;

//import java.util.Objects;
import java.util.UUID;

public abstract class BankAccount extends Object {

    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public  BankAccount(){
        this.accountId= UUID.randomUUID().toString();
        this.status=AccountStatus.CREATED;
    }
    public BankAccount(String currency,double initbalance){
        this();
        this.currency=currency;
        this.balance=initbalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return " " +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        BankAccount bankAccount=(BankAccount)obj;
        return this.accountId.equals(bankAccount.accountId);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(this.accountId)+Objects.hash(this.balance)
                +Objects.hash(this.currency)+Objects.hash(this.status);
    }*/

    public abstract String getType();

    public final void print(){
        System.out.println("-------------BANK--------------");
    }

}
