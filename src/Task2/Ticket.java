package Task2;

import java.util.Date;

public class Ticket {
    private Date CreatedOn;
    private String Details;
    private Receptionist CreatedBy;
    private Status Status;

    public Ticket(String details, Receptionist createdBy) {
        CreatedOn = new Date();
        Details = details;
        CreatedBy = createdBy;
        Status = Status.NEW;
    }
}
