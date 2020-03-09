package com.Bank;

import java.util.Date;
import java.util.ArrayList;

public class Customer extends Person {
    private int customerID;
    private static int numberOfCustomers = 0;
    private static ArrayList<Customer> customers = new ArrayList<Customer>();

    public Customer(String fName, String lName, Date DoB) {
        super(fName, lName, DoB);
        this.customerID = ++numberOfCustomers;
        customers.add(this);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public static int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    @Override
    public String toString() {
        return "Name " + getfName() + " " + getlName() + " DoB " + df.format(getDoB()) + " ID " + customerID;
    }
}
