package Task2;

public abstract class Person {

    private static int IDCount = 1000;
    private String personID;
    private String name;

    public Person(String name) {
        int Length = 3;
        if (name.length() < 3) {
            Length = name.length();
        }
        personID = "";
        for (int i = 0; i < Length; i++) {
            this.personID += name.charAt(i);
        }
        this.personID += IDCount;
        this.name = name;
        IDCount++;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID() {
        int Length = 3;
        if (name.length() < 3) {
            Length = name.length();
        }
        personID = "";
        for (int i = 0; i < Length; i++) {
            this.personID += name.charAt(i);
        }
        this.personID += IDCount;
        IDCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + getPersonID() + "\nName: " + getName();
    }
}
