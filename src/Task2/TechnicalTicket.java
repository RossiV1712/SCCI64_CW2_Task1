package Task2;

public class TechnicalTicket extends Ticket {
    private Equipment EquipEffected;
    private Person ReportedBy;

    public TechnicalTicket(String details, Receptionist createdBy, Equipment equipEffected, Person reportedBy) {
        super(details, createdBy);
        EquipEffected = equipEffected;
        ReportedBy = reportedBy;
    }

    public Equipment getEquipEffected() {
        return EquipEffected;
    }

    public void setEquipEffected(Equipment equipEffected) {
        EquipEffected = equipEffected;
    }

    public Person getReportedBy() {
        return ReportedBy;
    }

    public void setReportedBy(Person reportedBy) {
        ReportedBy = reportedBy;
    }

    @Override
    public String toString() {
        return super.toString() + "\nReported By: " + ReportedBy + "\nEquipment: " + getEquipEffected();
    }
}
