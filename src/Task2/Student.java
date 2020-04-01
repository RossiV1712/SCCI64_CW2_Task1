package Task2;

import java.util.Date;

public class Student extends Person{

    private Date DoB;

    public Student(String name, Date DoB) {
        super(name);
        this.DoB = new Date(1998, 12, 17);
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDoB: " + getDoB();
    }
}
