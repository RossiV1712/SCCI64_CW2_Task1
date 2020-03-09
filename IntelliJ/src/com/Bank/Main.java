package com.Bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        /*BankAccount P1 = new BankAccount(1234); // Create the object
        System.out.println("P1 - " + P1.getBalance()); // Display balance
        P1.deposit(13.5); // Deposit 13.5 into P1
        System.out.println("P1 - " + P1.getBalance()); // Display balance
        P1.withdraw(12.45); // Withdraw 12.45 from P1
        System.out.println("P1 - " + P1.getBalance()); // Display balance

        BankAccount P2 = new BankAccount(5678);
        P2.deposit(56.8); // Deposit 56.8 into P2
        System.out.println("P2 - " + P2.getBalance()); // Display balance
        P2.transfer(23.2, P1); // Transfer 23.2 from P2 to P1

        System.out.println("P2- " + P2.getBalance()); // Display balance
        System.out.println("P1- " + P1.getBalance()); // Display balance*/

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Customer C1 = new Customer("John", "Ingram", df.parse("14/03/1968"));
        Customer C2 = new Customer("Cristopher", "Roman", df.parse("28/9/1976"));
        Customer C3 = new Customer("Michael", "House", df.parse("04/11/1973"));

        Staff S1 = new Staff("Brian", "Montgomery", df.parse("23/4/1963"), Role.Manager);
        Staff S2 = new Staff("Steven", "Garza", df.parse("19/7/1984"), Role.Cashier);
        Staff S3 = new Staff("Kevin", "Mccall", df.parse("21/6/1987"), Role.Security);

        System.out.println(C1.toString());
        System.out.println(C2.toString());
        System.out.println(C3.toString());

        System.out.println(S1.toString());
        System.out.println(S2.toString());
        System.out.println(S3.toString());

        System.out.println(S2.getDoB());

        System.out.println(Customer.getCustomers());

        System.out.println(Staff.getStaff());

        Customer.removeCustomer(C2);

        System.out.println(Customer.getCustomers());

    }
}