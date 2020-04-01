package Task2;

import java.io.IOException;

public class Tester {
    public Tester() throws IOException {
        TicketSystem TSystem = new TicketSystem("System");
        Receptionist Ross = new Receptionist("Ross", "Pass");
        Admin Aaron = new Admin("Aaron", "Pass");
        Ticket T = new Ticket("ABC", Ross);
        Ticket T1 = new Ticket("ABC", Ross);
        Ticket T2 = new Ticket("ABC", Ross);
        Ticket T3 = new Ticket("ABC", Ross);
        Ticket T4 = new Ticket("ABC", Ross);
        Ticket T5 = new Ticket("ABC", Ross);
        Ticket T6 = new Ticket("ABC", Ross);
        Ticket T7 = new Ticket("ABC", Ross);
        Ticket T8 = new Ticket("ABC", Ross);
        Ticket T9 = new Ticket("ABC", Ross);
        Ticket T0 = new Ticket("ABC", Ross);
        Ticket Ta = new Ticket("ABC", Ross);
        Ticket Tb = new Ticket("ABC", Ross);
        Ticket Tc = new Ticket("ABC", Ross);
        Ticket Td = new Ticket("ABC", Ross);
        Ticket Te = new Ticket("ABC", Ross);
        Ticket Tf = new Ticket("ABC", Ross);
        Ticket Tg = new Ticket("ABC", Ross);
        Ticket Th = new Ticket("ABC", Ross);
        TechnicalTicket T2a = new TechnicalTicket("QWE", Ross, Equipment.COMPUTER, Aaron);
        TSystem.addPeople(Ross);
        TSystem.addPeople(Aaron);
        TSystem.addTickets(T);
        TSystem.addTickets(T1);
        TSystem.addTickets(T2);
        TSystem.addTickets(T3);
        TSystem.addTickets(T4);
        TSystem.addTickets(T5);
        TSystem.addTickets(T6);
        TSystem.addTickets(T7);
        TSystem.addTickets(T8);
        TSystem.addTickets(T9);
        TSystem.addTickets(T0);
        TSystem.addTickets(Ta);
        TSystem.addTickets(Tb);
        TSystem.addTickets(Tc);
        TSystem.addTickets(Td);
        TSystem.addTickets(Te);
        TSystem.addTickets(Tf);
        TSystem.addTickets(Tg);
        TSystem.addTickets(Th);
        TSystem.addTickets(T2a);
        CLI Interface = new CLI(TSystem);
    }
}