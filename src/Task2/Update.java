package Task2;

public class Update extends Action {
    private String Comment;

    public Update(User Receptionist, String comment) {
        super(Receptionist);
        Comment = comment;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nComment: " + getComment();
    }
}
