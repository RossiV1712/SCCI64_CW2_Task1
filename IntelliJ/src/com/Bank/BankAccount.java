package com.Bank;

public class BankAccount {
    private long accountNumber; // Create the Instance or State variables
    private double amount;

    public BankAccount(long accountNumber){ // Constructor with formal parameter list
        this.accountNumber = accountNumber;
        this.amount = 0.00; // Set amount to 0 by default
    }

    public void deposit(double amount){ // A method to deposit money in the account
        this.amount += amount;
    }

    public void withdraw(double amount){ // A method to withdraw money from the account
        if (amount <= this.amount){ // If there is enough money in the account
            this.amount -= amount;
        }
    }

    public double getBalance(){ // A method to return the current balance of the account
        return this.amount;
    }

    public void transfer(double amount, BankAccount targetAccount){ // A method to tranfer money to another account, importing the whole other object
        if(targetAccount.getBalance() >= amount) { // If there is enough money in the account
            targetAccount.deposit(amount); // Deposit into new account
            this.withdraw(amount); // Withdraw from current account
        }
    }
}