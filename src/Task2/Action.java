package Task2;

import java.util.Date;

public class Action {
    private Date DateAdded;
    private User AddedBy;

    public Action(User Receptionist) {
        DateAdded = new Date();
        AddedBy = Receptionist;
    }

    public Date getDateAdded() {
        return DateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        DateAdded = dateAdded;
    }

    public User getAddedBy() {
        return AddedBy;
    }

    public void setAddedBy(User addedBy) {
        AddedBy = addedBy;
    }

    @Override
    public String toString() {
        return "Date Added: " + getDateAdded() + ", Added By: " + AddedBy.DisplayDetails();
    }
}
