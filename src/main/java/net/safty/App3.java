package net.safty;

import net.safty.business.BankAccountService;
import net.safty.business.BankAccountServiceImpl;
import net.safty.model.AccountStatus;
import net.safty.model.BankAccount;
import net.safty.utils.DataTransformation;

import java.util.List;

public class App3 {
    public static void main(String[] args) {
        BankAccountService bankAccountService=new BankAccountServiceImpl();

        //bankAccountService.addBankAccount(new CurrentAccount("MAD",500,100));
        //bankAccountService.addBankAccount(new SavingAccount("MAD",600,3.5));
        //BankAccount bankAccount3=new CurrentAccount("MAD",500,100);
        //bankAccount3.setAccountId("cc3");
        //bankAccountService.addBankAccount(bankAccount3);
        //List<BankAccount> accountList=bankAccountService.getAllAcount();

        /*for (BankAccount bankAccount : accountList) {
            System.out.println(bankAccount);
        }
        for (int i = 0; i <accountList.size() ; i++) {
            System.out.println(accountList.get(i));
        }
        //Les expressions lambda
        //fhalha fhal for wla foreach boucle dafichage  (ca c'est l'ancien syntaxe avant java 8)
        accountList.forEach(new Consumer<BankAccount>() {
            @Override
            public void accept(BankAccount bankAccount) {
                System.out.println(bankAccount.toString());
            }
        });

        //Les expressions lambda les plus utilisez
        accountList.forEach((account)->{
            System.out.println(account.toString());
        });
        // accountList.forEach(acc-> System.out.println(acc));//ikhtisar nta3 expressions lambda lowla
        // accountList.forEach(System.out::println);// hadi wli lfo9 kif kif ghir lktaba mbdla

        System.out.println("*************chercher un compte**************");
        try {
            BankAccount bankAccount=bankAccountService.getAcountById("CC3");
            System.out.println(bankAccount);
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
            //ex.printStackTrace();//la trace de l'exception
        }*/
        //System.out.println("***************** getSavingAccount **********************");
        bankAccountService.addRondomData(4);
       // bankAccountService.getSavingAccount().stream().map(DataTransformation::toJson).forEach(System.out::println);
       // System.out.println("***************** getCurrentAccount **********************");
       // bankAccountService.getCurrentAccount().stream().map(DataTransformation::toJson).forEach(System.out::println);

        //System.out.println("******** suite du programme *********");
        //System.out.println(" total balance "+bankAccountService.getTotalBalance());
        //System.out.println("***************** CurrentAccount **********************");
        //System.out.println(bankAccountService.getTotalBalanceCurrentAccount());
       // System.out.println("***************** SvingAccount **********************");
        //System.out.println(bankAccountService.getTotalBalanceSavingAccount());

        System.out.println("***************** search Account **********************");
        List<BankAccount> bankAccountList = bankAccountService.searchBankAccount(acc -> (acc.getStatus().equals(AccountStatus.BLOCKED)));
        bankAccountList.stream().map(DataTransformation::toJson).forEach(System.out::println);
        //System.out.println("***************** getAllAcount **********************");
       // bankAccountService.getAllAcount().stream().map(DataTransformation::toJson).forEach(System.out::println);

        System.out.println("***************** -Predicate- search Account **********************");
        List<BankAccount> bankAccountList1 = bankAccountService.searchBankAccount1(acc -> (acc.getStatus().equals(AccountStatus.BLOCKED)));
        bankAccountList.stream().map(DataTransformation::toJson).forEach(System.out::println);
        System.out.println("***************** getAllAcount **********************");
        bankAccountService.getAllAcount().stream().map(DataTransformation::toJson).forEach(System.out::println);
    }
}
