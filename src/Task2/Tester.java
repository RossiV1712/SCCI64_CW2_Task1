package Task2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class Tester {

    private InputStreamReader streamReader = new InputStreamReader(System.in);
    private BufferedReader input = new BufferedReader(streamReader);

    public Tester() throws IOException {

        TicketSystem TSystem = new TicketSystem("System");

        Receptionist Ross = new Receptionist("Ross", "Pass");
        Ticket T = new Ticket("ABC", Ross);
        TSystem.addPeople(Ross);
        TSystem.addTickets(T);
        CLI Interface = new CLI(TSystem);
    }

//    public void Output() throws IOException {
//        boolean x = false;
//        while (!x) {
//            System.out.println("HELLO\n1. asd\n2. qwe\n3. zxc");
//            String Input = input.readLine();
//            switch (Input) {
//                case "1":
//                    System.out.println("ASD");
//                    x = true;
//                    break;
//                case "2":
//                    System.out.flush();
//                    break;
//                case "3":
//                    System.out.println("ZXC");
//                    x = true;
//                    break;
//                case "z":
//                    System.out.println("Logging Out");
//                    //Log out
//            }
//        }
//    }
}
