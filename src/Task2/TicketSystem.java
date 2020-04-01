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

    public ArrayList<Ticket> searchTickets(String[] Values, Person ReportedBy, Receptionist AddedBy) {
        ArrayList<Ticket> Output = new ArrayList<Ticket>();
        for (Ticket t : Tickets) {
            Output.add(t);
        }
        return Output;
    }

    public void addTickets(Ticket ticket) {
        Tickets.add(ticket);
    }

    public ArrayList<Person> getPeople() {
        return People;
    }

    public ArrayList<Person> searchPeople(String personID, String Name) {
        ArrayList<Person> ChosenPeople = new ArrayList<Person>();
        for (Person person : People) {
            if (person.getPersonID().equals(personID) || person.getName().equals(Name)) {
                ChosenPeople.add(person);
            }
        }
        return ChosenPeople;
    }

    public void addPeople(Person person) {
        People.add(person);
    }

    public void removePerson(Person person) {
        People.remove(person);
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
