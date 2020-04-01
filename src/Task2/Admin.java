package Task2;

public class Admin extends User{

    public Admin(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return super.toString() + "\nRole: Administrator";
    }
}
