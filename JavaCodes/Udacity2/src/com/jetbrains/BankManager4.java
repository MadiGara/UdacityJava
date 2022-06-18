package com.jetbrains;

public class BankManager4 {

    static class BankAccount {
        String account;
        double balance;
    }

    static class CheckingAccount extends BankAccount {
        double limit;
    }

    static class SavingsAccount extends BankAccount {
        int transfers;
    }

    static class COD extends BankAccount {
        String expiry;
    }

    public static void main (String [] args){
        BankAccount myAccount = new BankAccount();
        myAccount.account = "3145690AB";
        myAccount.balance = 56023.00;
        System.out.println("Account number: " + myAccount.account);
        System.out.println("Account balance: " + myAccount.balance);

        CheckingAccount checkLimit = new CheckingAccount();
        checkLimit.limit = 10000.00;
        SavingsAccount numberOfTransfers = new SavingsAccount();
        numberOfTransfers.transfers = 3;
        COD expiryDate = new COD();
        expiryDate.expiry = "09/02/2024";
    }
}
