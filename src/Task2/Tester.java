package Task2;

import java.io.IOException;
import java.util.Date;

public class Tester {
    public Tester() throws IOException {
        TicketSystem TSystem = new TicketSystem("System");
        Receptionist Max = new Receptionist("Max", "Pass");
        Receptionist Ross = new Receptionist("Ross", "Pass");
        Admin Aaron = new Admin("Aaron", "Pass");
        Admin Luke = new Admin("Luke", "Pass");
        TSystem.addPeople(Max);
        TSystem.addPeople(Ross);
        TSystem.addPeople(Aaron);
        TSystem.addPeople(Luke);
        TSystem.addPeople(new Student("James", new Date("05/04/1999")));
        TSystem.addTickets(new Ticket("ABC", Ross));
        TSystem.addTickets(new Ticket("CDE", Max));
        TSystem.addTickets(new Ticket("QWE", Ross));
        TSystem.addTickets(new Ticket("ASD", Ross));
        TSystem.addTickets(new Ticket("KLM", Max));
        TSystem.addTickets(new Ticket("BJK", Max));
        TSystem.addTickets(new Ticket("IOS", Ross));
        TSystem.addTickets(new Ticket("WND", Ross));
        TSystem.addTickets(new Ticket("CMK", Max));
        TSystem.addTickets(new Ticket("MCS", Max));
        TSystem.addTickets(new Ticket("LFW", Ross));
        TSystem.addTickets(new Ticket("FGE", Max));
        TSystem.addTickets(new Ticket("CXS", Ross));
        TSystem.addTickets(new Ticket("QWS", Ross));
        TSystem.addTickets(new Ticket("VDG", Max));
        TSystem.addTickets(new Ticket("BEF", Ross));
        TSystem.addTickets(new Ticket("MEC", Ross));
        TSystem.addTickets(new Ticket("WGU", Max));
        TSystem.addTickets(new Ticket("HEH", Ross));
        TSystem.addTickets(new TechnicalTicket("QWE", Ross, Equipment.COMPUTER, Aaron));
        TSystem.addTickets(new TechnicalTicket("QWE", Max, Equipment.COMPUTER, Luke));
        CLI Interface = new CLI(TSystem);
    }
}