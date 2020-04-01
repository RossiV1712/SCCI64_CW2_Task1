package Task2;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    private static int TicketCounter = 10000000;
    private Date CreatedOn;
    private String Details;
    private Receptionist CreatedBy;
    private Status CurrentStatus;
    private int TicketID;
    private ArrayList<Action> Actions;

    public Ticket(String details, Receptionist createdBy) {
        CreatedOn = new Date();
        Details = details;
        CreatedBy = createdBy;
        CurrentStatus = Status.NEW;
        TicketID = TicketCounter;
        TicketCounter++;
        Actions = new ArrayList<Action>();
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public Status getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        CurrentStatus = currentStatus;
    }

    public Receptionist getCreatedBy() {
        return CreatedBy;
    }

    public int getTicketID() {
        return TicketID;
    }

    public ArrayList<Action> getActions() {
        return Actions;
    }

    public void addAction(Action action) {
        Actions.add(action);
    }
    public String Display() {
        String OutputString = "Current Status: " + getCurrentStatus() + "\nTicket ID: " + getTicketID() + "\nDetails: " + getDetails() + "\nCreatedOn: " + getCreatedOn() + "\nCreatedBy: " + CreatedBy.DisplayDetails();
        if (!Actions.isEmpty()) {
            OutputString += "\nACTIONS: ";
        }
        for (Action Action : Actions) {
            OutputString += "\n" + Action.toString();
        }
        return OutputString;
    }

    @Override
    public String toString() {
        return "CreatedOn: " + getCreatedOn() +" Details: " + getDetails() + " CreatedBy: " + getCreatedBy() + " CurrentStatus: " + getCurrentStatus() + " TicketID: " + getTicketID() + " Actions: " + getActions();
    }
}
