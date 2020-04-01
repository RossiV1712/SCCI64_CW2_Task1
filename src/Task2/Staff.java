package Task2;

public class Staff extends Person {
    private Department Department;

    public Staff(String name, Department department) {
        super(name);
        Department = department;
    }

    public Task2.Department getDepartment() {
        return Department;
    }

    public void setDepartment(Department department) {
        Department = department;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + getDepartment();
    }
}
