package Task2;

public class Receptionist extends User{

    public Receptionist(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return super.toString() + "\nRole: Receptionist";
    }
}
