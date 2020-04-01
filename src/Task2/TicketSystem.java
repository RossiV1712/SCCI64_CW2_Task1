package Task2;

import java.util.ArrayList;

public class TicketSystem {

    private ArrayList<Ticket> Tickets;
    private ArrayList<Person> People;
    private String SystemName;

    public TicketSystem(String systemName) {
        this.Tickets = new ArrayList<Ticket>();
        this.People = new ArrayList<Person>();
        SystemName = systemName;
    }

    public ArrayList<Ticket> getTickets() {
        return Tickets;
    }

    public ArrayList<Ticket> searchTickets(String[] Values) {
        ArrayList<Ticket> Output;
        for (Ticket t : Tickets) {

        }
        return Tickets;
    }

    public void addTickets(Ticket ticket) {
        Tickets.add(ticket);
    }

    public ArrayList<Person> getPeople() {
        return People;
    }

    public void addPeople(Person person) {
        People.add(person);
    }

    public String getSystemName() {
        return SystemName;
    }


    public Person searchPeople(String userID) {
        for (Person person : People) {
            if (person.getPersonID().equals(userID)) {
                return person;
            }
        }
        return null;
    }

    public User getUser(String userID) {
        Person person = searchPeople(userID);

        if (person instanceof User) {
            return (User) person;
        }
        return null;
    }

    public Receptionist getReceptionist(String userID) {
        Person person = searchPeople(userID);
        if (person instanceof Receptionist) {
            return (Receptionist) person;
        }
        return null;
    }

    public void setSystemName(String systemName) {
        SystemName = systemName;
    }
}
