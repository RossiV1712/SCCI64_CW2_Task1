package Task2;

public abstract class User extends Person {
    private String Password;

    public User(String name, String password) {
        super(name);
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPassword: " + getPassword();
    }
}
