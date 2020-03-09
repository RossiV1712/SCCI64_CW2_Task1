package com.Bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {

    private String fName, lName;
    private Date DoB;
    private static String pattern = "dd-MM-yyyy";
    SimpleDateFormat df = new SimpleDateFormat(pattern);

    public Person(String fName, String lName, Date DoB) {
        this.fName = fName;
        this.lName = lName;
        this.DoB = DoB;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getName() {
        return fName + " " + lName;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }

    @Override
    public String toString() {
        return "Name " + fName + " " + lName + " DoB " + df.format(DoB);
    }
}
