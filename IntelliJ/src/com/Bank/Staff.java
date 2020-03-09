package com.Bank;

import java.util.ArrayList;
import java.util.Date;

public class Staff extends Person {
    private int staffID;
    private static int numberOfStaff = 0;
    private Role role;
    private static ArrayList<Staff> staff = new ArrayList<Staff>();

    public Staff(String fName, String lName, Date DoB, Role role) {
        super(fName, lName, DoB);
        this.role = role;
        this.staffID = ++numberOfStaff;
        staff.add(this);
    }

    public static ArrayList<Staff> getStaff() {
        return staff;
    }

    public static void removeStaff(Staff staffMember) {
        staff.remove(staffMember);
    }

    public int getCustomerID() {
        return staffID;
    }

    public void setCustomerID(int customerID) {
        this.staffID = customerID;
    }

    public static int getNumberOfCustomers() {
        return numberOfStaff;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Name " + getfName() + " " + getlName() + " DoB " + df.format(getDoB()) + " ID " + staffID + " Role " + role.toString();
    }
}
