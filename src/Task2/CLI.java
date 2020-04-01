package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.DoubleSummaryStatistics;

public class CLI {

    private InputStreamReader streamReader = new InputStreamReader(System.in);
    private BufferedReader input = new BufferedReader(streamReader);
    private TicketSystem TSystem;
    private User LoggedInUser;
    private Receptionist LoggedInReceptionist;
    private Boolean ALoggedIn = false;

    public CLI(TicketSystem TSystem) throws IOException {
        this.TSystem = TSystem;
        Login();
    }

    public void Login() throws IOException {
        System.out.println("Welcome to " + TSystem.getSystemName() + " Helpdesk");
        System.out.println("------------- Log In -----------------" );
        System.out.print("Enter User ID: ");
        String userID = input.readLine();
        System.out.print("Enter Password: ");
        String password = input.readLine();

        if (CheckLogIn(userID, password)) {
            System.out.println("Logged In!");
            if (ALoggedIn) {
                AdminMainMenu();
            }
            else {
                MainMenu();
            }
        }
        else {
            System.out.println("Failed!");
        }
    }

    private boolean CheckLogIn(String userID, String password) {
        User User = TSystem.getUser(userID);
        if (User != null) {
            if (password.equals(User.getPassword())) {
                LoggedInUser = User;
                if (User.getRole() == Role.ADMIN) {
                    ALoggedIn = true;
                }
                else {
                    LoggedInReceptionist = TSystem.getReceptionist(userID);
                }
                return true;
            }
        }
        return false;
    }

    public void LogOut() {
        //Reset all instance variables
    }

    public void AdminMainMenu() {
        boolean LogOut = false;
        while (LogOut == false) {
            System.out.println("Loading Admin Menu\nPlease select what you would like to to: ");
        }
    }

    public void MainMenu() throws IOException {
        boolean LogOut = false;
        while (LogOut == false) {
            System.out.println("Loading Menu\nPlease select what you would like to do:");
            System.out.println("1. View To Do list\n2. View all tickets\n3. Search tickets\n0. Log Out");
            String Choice = input.readLine();
            switch (Choice) {
                case "1":
                    System.out.println("View To Do");
                    break;
                case "2":
                    DisplayTickets(TSystem.getTickets());
                    break;
                case "3":
                    SearchMenu();
                    break;
                case "0":
                    LogOut();
                    LogOut = true;
            }
        }
        Login();
    }

    public void ToDoList() throws IOException {
        
    }

    public void SearchMenu() throws IOException {
        boolean SearchMenu = true;
        String[] Parameters = new String[7];
        String[] Output = new String[7];
        while (SearchMenu == true) {
            System.out.println("Please enter the search terms");
            int Count = 0;
            for (String string : Parameters) {
                if (string != null && !string.equals("")) {
                    Output[Count] = " : " + string;
                }
                else {
                    Output[Count] = "";
                }
                Count++;
            }
            System.out.println("1. Ticket ID" + Output[0] + "\n2. Date Start" + Output[1] + "\n3. Date End" + Output[2] + "\n4. Added By" + Output[3] + "\n5. Status" + Output[4] + "\n6. Reported By" + Output[5] + "\n7. Equipment Effected" + Output[6] + "\n0. Back");
            String Choice = input.readLine();
                switch (Choice) {
                    case "":
                        DisplayTickets(TSystem.searchTickets(Parameters));
                        break;
                    case "1":
                        Parameters[0] = SearchSetParameter("Ticket ID");
                        break;
                    case "2":
                        Parameters[1] = SearchSetDate(1);
                        break;
                    case "3":
                        Parameters[2] = SearchSetDate(2);
                        break;
                    case "4":
                        Parameters[3] = SearchAddedBy();
                        break;
                    case "5":
                        Parameters[4] = SearchStatus();
                        break;
                    case "6":
                        Parameters[5] = SearchAddedBy();
                        break;
                    case "7":
                        Parameters[6] = SearchEquipment();
                        break;
                    case "0":
                        SearchMenu = false;
                        break;
                }
                int count = 0;
                for (String i:Parameters) {
                    System.out.println(Parameters[count]);
                    count++;
                }
        }

    }

    public String SearchSetParameter(String Parameter) throws IOException{
        System.out.print("\n-----------------------\n\nPlease enter the " + Parameter + ": ");
         return input.readLine();
    }

    public Boolean CheckDate(Date date, boolean x) {
        Date CurrentDate = new Date();
        if (x) {
            if (date.before(CurrentDate)) {
                return true;
            }
        }
        return false;
    }

    public String SearchSetDate(int x) throws IOException {
        Date Output;
        String OutputString = "a";
        System.out.println("Please enter the date for the start of the search");

        return OutputString;
    }

    public String SearchAddedBy() throws IOException {
        return input.readLine();
    }

    public String SearchStatus() throws IOException {
        return input.readLine();
    }

    public String SearchEquipment() throws IOException {
        int Count = 1;
        for (Equipment E : Equipment.values()) {
            System.out.println(Count + ". " + E);
            Count++;
        }
        return input.readLine();
    }

    public void DisplayTickets(ArrayList<Ticket> Array) throws IOException {
        boolean y = true;
        int Page = 0;
        while (y) {
            System.out.println("-------------------");
            int Limit = Array.size() - 1 < (Page + 1) * 7 ? Array.size() - 1 : ((Page + 1) * 7) - 1;
            int Count = 1;
            for (int i = (Page * 7); i <= Limit; i++) { // for i
                System.out.println(Count + ". ");
                System.out.println(Array.get(i).Display()); // Display from Array.get(i)
                Count++;
            }
            System.out.println("\nPlease select the number of the chosen Ticket or '8' for the previous page, '9' for the next page or '0' to go back");
            String Choice = input.readLine();
            switch(Choice) {
                case "0":
                    y = false;
                    break;
                case "1":
                    DisplayChosenTicket(Array.get(Page * 7));
                    break;
                case "2":
                    DisplayChosenTicket(Array.get(Page * 7 + 1));
                    break;
                case "3":
                    DisplayChosenTicket(Array.get(Page * 7 + 2));
                    break;
                case "4":
                    DisplayChosenTicket(Array.get(Page * 7 + 3));
                    break;
                case "5":
                    DisplayChosenTicket(Array.get(Page * 7 + 4));
                    break;
                case "6":
                    DisplayChosenTicket(Array.get(Page * 7 + 5));
                    break;
                case "7":
                    DisplayChosenTicket(Array.get(Page * 7 + 6));
                    break;
                case "8":
                    if (Page > 0) {
                        Page--;
                    }
                    else {
                        System.out.println("First page reached!");
                    }
                    break;
                case "9":
                    if (Array.size() >= ((Page + 1) * 7)) {
                        Page++;
                    }
                    else {
                        System.out.println("Max page reached!");
                    }
                    break;
            }
        }
    }

    public void DisplayChosenTicket(Ticket ticket) throws IOException {
        boolean Display = true;
        String ToDoString;
        boolean ToDo = false;
        while (Display) {
            System.out.println(LoggedInReceptionist.getToDo());
            if (LoggedInReceptionist.getToDo().contains(ticket)) {
                ToDoString = "Remove from To Do list";
                ToDo = false;
            }
            else {
                ToDoString = "Add to To Do list";
                ToDo = true;
            }
            System.out.println("---- Viewing Ticket ----");
            System.out.println(ticket.Display());
            System.out.println("-------------------------");
            System.out.println("Please Make your choice: ");
            System.out.println("1. Update Ticket\n2. Close Ticket\n3. " + ToDoString + "\n0. Back");
            String Choice = input.readLine();
            switch (Choice) {
                case "1":
                    UpdateAction(ticket);
                    break;
                case "2":
                    CloseAction(ticket);
                    break;
                case "3":
                    if (ToDo) {
                        LoggedInReceptionist.AddToToDo(ticket);
                    }
                    else {
                        LoggedInReceptionist.RemoveFromToDo(ticket);
                    }
                    break;
                case "0":
                    Display = false;
                    break;
            }
        }
    }

   public void UpdateAction(Ticket ticket) throws IOException {
        Boolean Repeat = true;
        while (Repeat) {
            System.out.println("---- Adding Action ----");
            System.out.println(ticket.Display());
            System.out.println("Please enter the comment and press enter to submit, enter 0 to go back");
            String Input = input.readLine();
            if (Input.equals("0")) {
                Repeat = false;
            }
            else if (!Input.isEmpty()) {
                ticket.addAction(new Update(LoggedInUser, Input));
                ticket.setCurrentStatus(Status.RESPONDED);
                Repeat = false;
            } else {
                System.out.println("Error occurred, please check input");
            }
        }
    }

    public void CloseAction(Ticket ticket) throws IOException {
        Boolean Repeat = true;
        while (Repeat) {
            System.out.println("---- Adding Resolution ----");
            System.out.println(ticket.Display());
            System.out.println("Please enter the comment and press enter to submit and close the ticket, enter 0 to go back");
            String Input = input.readLine();
            if (Input.equals("0")) {
                Repeat = false;
            }
            else if (!Input.isEmpty()) {
                ticket.addAction(new Close(LoggedInUser, Input));
                ticket.setCurrentStatus(Status.CLOSED);
                Repeat = false;
            }
            else {
                System.out.println("Error occurred, please check input");
            }
        }
    }

}
