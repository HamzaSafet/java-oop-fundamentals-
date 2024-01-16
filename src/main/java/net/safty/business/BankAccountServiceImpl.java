package net.safty.business;

import net.safty.exception.AccountNotFoundException;
import net.safty.exception.BalanceNotSufficientException;
import net.safty.model.AccountStatus;
import net.safty.model.BankAccount;
import net.safty.model.CurrentAccount;
import net.safty.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankAccountServiceImpl implements BankAccountService{
    private List<BankAccount> accountList=new ArrayList<>();
    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {
        accountList.add(bankAccount);
        return bankAccount;

    }

    @Override
    public List<BankAccount> getAllAcount() {
        return accountList;
    }

    @Override
    public BankAccount getAcountById(String id) throws AccountNotFoundException {

        //declarative approche
        return accountList
                .stream()
                .filter(acc -> acc.getAccountId().equals(id))
                .findFirst()
                .orElseThrow(()->new AccountNotFoundException(String.format("account %s not found",id)));

        /*
         //inperative approch
        for (BankAccount account:accountList) {
                if (account.getAccountId().equals(id)){
                    return account;
                }
            }
            throw new AccountNotFoundException("Account Not Found");

         */
    }

    @Override
    public void addRondomData(int size) {
        AccountStatus accountStatus[]=AccountStatus.values();
        Random random=new Random();
        for (int i = 0; i < size; i++) {
            BankAccount bankAccount;
            if (Math.random()>0.5){
                //Katsma expression ternaire (Math.random()>0.5?"MAD":"USD")
                 bankAccount=new CurrentAccount(Math.random()>0.5?"MAD":"USD",
                              Math.random()*1000000,Math.random()*500000);
                 bankAccount.setStatus(accountStatus[random.nextInt(accountStatus.length)]);
            }else {
                 bankAccount=new SavingAccount(Math.random()>0.5?"MAD":"USD",
                              Math.random()*1000000,4+Math.random()*5);
                bankAccount.setStatus(accountStatus[random.nextInt(accountStatus.length)]);
            }
            accountList.add(bankAccount);

        }

    }

    @Override
    public void cridet(String accountId, double amount) throws AccountNotFoundException {
        BankAccount acountById = getAcountById(accountId);
        acountById.setBalance(acountById.getBalance() + amount);

    }

    @Override
    public void debit(String accountId, double amount)
            throws AccountNotFoundException, BalanceNotSufficientException {

        BankAccount acountById = getAcountById(accountId);
        if (acountById.getBalance()>=amount){
            acountById.setBalance(acountById.getBalance() - amount);
        }else throw new BalanceNotSufficientException("Balance Not Sufficient");

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount)
            throws AccountNotFoundException, BalanceNotSufficientException {

        debit(accountSource,amount);
        cridet(accountDestination,amount);
    }

    @Override
    public List<BankAccount> getSavingAccount() {
        //approche déclarative
        List<BankAccount> collect = accountList
                .stream()
                .filter(acc -> acc instanceof SavingAccount)
                .collect(Collectors.toList());
        return collect;

        //approche impérative
       /* List<BankAccount> savingAccount=new ArrayList<>();
        for(BankAccount acc:accountList){
           if (acc instanceof SavingAccount){//if(acc.getType.equal("SAVING_ACCOUNT"))
               savingAccount.add(acc);
           }
        }
        return savingAccount;*/
    }

    @Override
    public List<BankAccount> getCurrentAccount() {
        List<BankAccount> collect = accountList
                .stream()
                .filter(acc -> acc.getType().equals("CURRENT_ACCOUNT"))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public double getTotalBalance() {
         return accountList.stream()
                           .map(acc->acc.getBalance())
                           .reduce(0.0,(a,v)->a+v);
      /*
        double sumBalance=0;
        for (BankAccount acc:accountList) {
            sumBalance=sumBalance+ acc.getBalance();
        }
        return sumBalance;*/
    }

    @Override
    public double getTotalBalanceSavingAccount() {
        double sumSavingBalance=0;
        for (BankAccount acc:getSavingAccount()) {
            sumSavingBalance=sumSavingBalance+ acc.getBalance();
        }
        return sumSavingBalance;
    }

    @Override
    public double getTotalBalanceCurrentAccount() {
        double sumCurrentBalance=0;
        for (BankAccount acc:getCurrentAccount()) {
            sumCurrentBalance=sumCurrentBalance+ acc.getBalance();
        }
        return sumCurrentBalance;
    }

    @Override
    public List<BankAccount> searchBankAccount(Condition<BankAccount> condition) {
        List<BankAccount> listAccount=new ArrayList<>();
        for (BankAccount acc:accountList) {
            if (condition.test(acc)){
                listAccount.add(acc);
            }
        }
        return listAccount;
    }

    @Override
    public List<BankAccount> searchBankAccount1(Predicate<BankAccount> filter) {
        List<BankAccount> listAccount=new ArrayList<>();
        for (BankAccount acc:accountList) {
            if (filter.test(acc)){
                listAccount.add(acc);
            }
        }
        return listAccount;
    }
}
