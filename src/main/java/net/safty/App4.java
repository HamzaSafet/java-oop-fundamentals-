package net.safty;

import net.safty.business.BankAccountService;
import net.safty.business.BankAccountServiceImpl;
import net.safty.exception.AccountNotFoundException;
import net.safty.exception.BalanceNotSufficientException;
import net.safty.model.BankAccount;
import net.safty.model.CurrentAccount;
import net.safty.model.SavingAccount;
import net.safty.utils.DataTransformation;

public class App4 {
    public static void main(String[] args) {
        DataTransformation transformation = new DataTransformation();
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        /*
        bankAccountService.addRondomData(5);

        bankAccountService.getAllAcount().forEach(System.out::println);

        System.out.println("***********************************************");
        bankAccountService.getAllAcount().forEach(bankAccount -> {
            System.out.println(transformation.toJson(bankAccount));
         });

        System.out.println("***************** stream ****************************");
        bankAccountService.getAllAcount()
                .stream()
                .map(account -> transformation.toJson(account))
                .forEach(System.out::println);

        System.out.println("***************** stream ****************************");
        bankAccountService.getAllAcount()
                .stream()
                .map(transformation::toJson)
                .forEach(System.out::println);
        */
        System.out.println("******************* add acount ***********************");
        BankAccount bankAccount1 = new CurrentAccount("MAD", 500, 100);
        bankAccount1.setAccountId("cc1");

        BankAccount bankAccount2 = new SavingAccount("MAD", 800, 4.8);
        bankAccount2.setAccountId("cc2");

        bankAccountService.addBankAccount(bankAccount1);
        bankAccountService.addBankAccount(bankAccount2);
        /*
        System.out.println("******************* git acount by id ******************");
        try {
            BankAccount bankAccount = bankAccountService.getAcountById("cc3");
            System.out.println(transformation.toJson(bankAccount));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
           // e.printStackTrace();
        }
        System.out.println("********************* debit **********************");
        try {
            bankAccountService.debit("cc1",501);
            BankAccount bankAccount = bankAccountService.getAcountById("cc3");
            System.out.println(transformation.toJson(bankAccount));
        } catch (AccountNotFoundException | BalanceNotSufficientException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("********************* cridet **********************");
        try {
            bankAccountService.cridet("cc1",200);
            BankAccount bankAccount = bankAccountService.getAcountById("cc3");
            System.out.println(transformation.toJson(bankAccount));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        */
        System.out.println("********************* Operation Transfer **********************");
        BankAccount account1 = null;
        BankAccount account2 = null;
        try {
            account1 = bankAccountService.getAcountById("cc1");
            account2 = bankAccountService.getAcountById("cc2");
            System.out.println("**************** Compte 1 **************");
            System.out.println(transformation.toJson(account1));
            System.out.println("**************** Compte 2 **************");
            System.out.println(transformation.toJson(account2));
            System.out.println("**************** Transfer Compte1 Ver Compte 2 **************");
            bankAccountService.transfer("cc1", "cc3", 200);
            System.out.println(transformation.toJson(account1));
            System.out.println(transformation.toJson(account2));
        } catch (AccountNotFoundException | BalanceNotSufficientException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(transformation.toJson(account1));
        System.out.println(transformation.toJson(account2));

    }
}
