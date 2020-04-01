package Task2;

public abstract class User extends Person {
    private String Password;
    private Role Role;

    public User(String name, String password, Role role) {
        super(name);
        Role = role;
        Password = password;
    }

    public String DisplayDetails() {
        return "ID: " + getPersonID() + ", Name: " + getName() + ", Role: " + getRole();
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPassword: " + getPassword();
    }
}
