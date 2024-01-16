package net.safty.business;

import net.safty.exception.AccountNotFoundException;
import net.safty.exception.BalanceNotSufficientException;
import net.safty.model.BankAccount;

import java.util.List;
import java.util.function.Predicate;


public interface BankAccountService {
    BankAccount addBankAccount(BankAccount bankAccount);
    List<BankAccount> getAllAcount();
    BankAccount getAcountById(String id) throws AccountNotFoundException;
    void addRondomData(int size);
    void cridet(String accountId,double amount) throws AccountNotFoundException;
    void debit(String accountId,double amount) throws AccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountSource,String accountDestination,double amount) throws AccountNotFoundException, BalanceNotSufficientException;
    List<BankAccount> getSavingAccount();
    List<BankAccount> getCurrentAccount();
    double getTotalBalance();
    double getTotalBalanceSavingAccount();
    double getTotalBalanceCurrentAccount();
    List<BankAccount> searchBankAccount(Condition<BankAccount> condition);
    List<BankAccount> searchBankAccount1(Predicate<BankAccount> filter);

}
