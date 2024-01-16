package net.safty;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.safty.model.BankAccount;
import net.safty.model.CurrentAccount;
import net.safty.model.SavingAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {
    public static void main(String[] args) throws JsonProcessingException {
       /* BankAccount bankAccount[]=new BankAccount[4];
        bankAccount[0]=new BankAccount("usdt",10);
        bankAccount[1]=new BankAccount("dh",100);
        bankAccount[2]=new BankAccount("euro",9);
        bankAccount[3]=new BankAccount("dhi",25);

        for (int i = 0; i < bankAccount.length; i++) {
            System.out.println(bankAccount[i].toString());
        }
        System.out.println("***************foreach*****************");

        for (BankAccount ba : bankAccount) {
            System.out.println(ba.getBalance());
        }
        System.out.println("***************les listes**************");

        List<BankAccount> bankAccountList= new ArrayList<BankAccount>();
        bankAccountList.add(new BankAccount("usdt",10));
        bankAccountList.add(new BankAccount("euro",9));
        bankAccountList.add(new BankAccount("dhm",100));
        bankAccountList.add(new BankAccount("dhi",25));
        bankAccountList.add(new BankAccount("rs",20));
        for (BankAccount bankAccount1:bankAccountList) {
            System.out.println(bankAccount1.toString());
        }

        System.out.println("****************Map list*********************");

        Map<String, BankAccount> accountMap=new HashMap<String, BankAccount>();
        accountMap.put("cc1",new BankAccount("usdt",10));
        accountMap.put("cc2",new BankAccount("dh",100));
        accountMap.put("cc3",new BankAccount("euro",11));
        accountMap.put("cc4",new BankAccount("dh",101));

        BankAccount bankAccount1= accountMap.get("cc1");
        System.out.println(bankAccount1.toString());
        System.out.println(accountMap.get("cc2").toString());
        System.out.println(accountMap.get("cc3").getBalance());
        for (String key:accountMap.keySet()) {
            System.out.println(accountMap.get(key).getBalance());
        }
        for (BankAccount ba :accountMap.values()) {
            System.out.println(ba.toString());
        }
        System.out.println("*************forma json**************");
        for (BankAccount ba :accountMap.values()) {
            System.out.println(toJson(ba));
        }*/

        BankAccount bankAccount[]=new BankAccount[4];
        bankAccount[0]=new CurrentAccount("usdt",10,500);
        bankAccount[1]=new CurrentAccount("dh",100,300);
        bankAccount[2]=new SavingAccount("euro",9,4.2);
        bankAccount[3]=new SavingAccount("dh",9,4.3);

        for (int i = 0; i < bankAccount.length; i++) {
            System.out.println(bankAccount[i].toString());
        }
        System.out.println("***************foreach*****************");

        for (BankAccount ba : bankAccount) {
            /*if (ba instanceof CurrentAccount){
                System.out.println(((CurrentAccount)ba).getType());
            }else if (ba instanceof SavingAccount){
                System.out.println(((SavingAccount)ba).getType());
            }*/
            System.out.println(ba.getType());
            if (ba instanceof SavingAccount){
                System.out.println("Rate = "+((SavingAccount)ba).getInterestRate());
            }else if (ba instanceof CurrentAccount){
                System.out.println("Overdraft = "+((CurrentAccount)ba).getOverdDraft());
            }

        }
        System.out.println("***************les listes**************");

        List<BankAccount> bankAccountList= new ArrayList<BankAccount>();
        bankAccountList.add(new CurrentAccount("usdt",10,400));
        bankAccountList.add(new CurrentAccount("euro",9,600));
        bankAccountList.add(new SavingAccount("dhm",100,5.2));
        bankAccountList.add(new SavingAccount("dhi",25,5.2));
        bankAccountList.add(new CurrentAccount("rs",20,500));
        for (BankAccount bankAccount1:bankAccountList) {
            System.out.println(bankAccount1.toString());
        }

        System.out.println("****************Map list*********************");

        Map<String, BankAccount> accountMap=new HashMap<String, BankAccount>();
        accountMap.put("cc1",new CurrentAccount("USD",100,400));
        accountMap.put("cc2",new CurrentAccount("DH",200,600));
        accountMap.put("cc3",new SavingAccount("DHM",25,5.2));
        accountMap.put("cc4",new SavingAccount("EURO",250,5.6));
        accountMap.put("cc5",new CurrentAccount("DH",300,800));

        /*BankAccount bankAccount1= accountMap.get("cc1");
        System.out.println(bankAccount1.toString());
        System.out.println(accountMap.get("cc2").toString());
        System.out.println(accountMap.get("cc3").getBalance());*/
        System.out.println("*********************afficher par key******************");
        for (String key:accountMap.keySet()) {
            System.out.println(accountMap.get(key));
        }
        System.out.println("*********************afficher par value******************");
        for (BankAccount ba :accountMap.values()) {
            System.out.println(ba.toString());
        }

        System.out.println("*************forma json**************");

        for (BankAccount ba :accountMap.values()) {
            System.out.println(toJson(ba));
        }

    }

    public static String toJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

}
