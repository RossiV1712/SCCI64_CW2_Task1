package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI {

    private InputStreamReader streamReader = new InputStreamReader(System.in);
    private BufferedReader input = new BufferedReader(streamReader);
    private TicketSystem TSystem;
    private Receptionist RLoggedIn;
    private Admin ALoggedIn;

    public CLI(TicketSystem TSystem) throws IOException {
        this.TSystem = TSystem;
        System.out.println(TSystem.getPeople());
        System.out.println(TSystem.getTickets());
        Login();
    }

    public void Login() throws IOException {
        System.out.println("Welcome to " + TSystem.getSystemName() + " Helpdesk" );
        System.out.println("------------- Log In -----------------" );
        System.out.print("Enter User ID: ");
        String userID = input.readLine();
        System.out.print("Enter Password: ");
        String password = input.readLine();

        if (CheckLogIn(userID, password)) {

        }
    }

    private boolean CheckLogIn(String userID, String password) {
        User receptionist = TSystem.getUser("a");
        return false;
    }
}
