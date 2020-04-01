package Task2;

import java.util.ArrayList;

public class Receptionist extends User{

    private ArrayList<Ticket> ToDo;

    public Receptionist(String name, String password) {
        super(name, password, Role.RECEPTIONIST);
        ToDo = new ArrayList<Ticket>();
    }

    public ArrayList<Ticket> getToDo() {
        return ToDo;
    }

    public void AddToToDo(Ticket ticket) {
        ToDo.add(ticket);
    }

    public void RemoveFromToDo(Ticket ticket) {
        ToDo.remove(ticket);
    }

    @Override
    public String toString() {
        return super.toString() + "\nRole: Receptionist";
    }
}
