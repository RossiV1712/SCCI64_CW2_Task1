package Task2;

public class Close extends Action {
    private String Details;

    public Close(User Receptionist, String details) {
        super(Receptionist);
        Details = details;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    @Override
    public String toString() {
        return "RESOLVED - " + super.toString() + "\nDetails: " + getDetails();
    }
}
