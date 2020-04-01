package Task2;

import jdk.jshell.spi.SPIResolutionException;

import javax.print.DocFlavor;
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

    public void AdminMainMenu() throws IOException {
        boolean LogOut = false;
        while (LogOut == false) {
            System.out.println("Loading Admin Menu\nPlease select what you would like to to: ");
            System.out.println("1. View Users\n2. Create User\n3. Search Users\n0. Log Out");
            String choice = input.readLine();
            switch (choice) {
                case "1":
                    DisplayUsers(TSystem.getPeople());
                    break;
                case "2":
                    Role Chosen = SelectUser();
                    if (Chosen != null) {
                        CreateUser(Chosen);
                    }
                    else {
                        System.out.println("No role chosen, please try again");
                    }
                    break;
                case "3":
                    DisplayUsers(SearchUsers()); //Null check
                    break;
                case "0":
                    LogOut = true;
                    break;
            }
        }
    }

    public ArrayList<Person> SearchUsers() throws IOException {
        String NameInput = "";
        String UserIDInput = "";
        boolean Repeat = true;
        while (Repeat) {
            String Choice = "";
            System.out.println("What would you like to search:");
            System.out.println("Enter to search\n1. Name: " + NameInput + "\n2. User ID: " + UserIDInput + "\n0. Back");
            Choice = input.readLine();
            switch (Choice) {
                case "":
                    return TSystem.searchPeople(UserIDInput, NameInput);
                case "1":
                    if (!NameInput.isEmpty()) {
                        System.out.println("0. To clear");
                    }
                    System.out.print("Please enter the name: ");
                    String NInput = input.readLine();
                    if (NInput.equals("0")) {
                        NameInput = "";
                    }
                    else if (NInput.matches("^[a-zA-Z]+$")) {
                        NameInput = NInput;
                    }
                    break;
                case "2":
                    if (!UserIDInput.isEmpty()) {
                        System.out.println("0. To clear");
                    }
                    System.out.print("Please enter the User ID: ");
                    UserIDInput = input.readLine();
                    if (UserIDInput.equals("0")) {
                        UserIDInput = "";
                    }
                    break;
                case "0":
                    Repeat = false;
            }
        }
        return null;
    }

    public Role SelectUser() throws IOException {
        boolean Repeat = true;
        while (Repeat) {
            System.out.println("1. Student\n2. Staff\n3. Receptionist\n4. Admin\n0. Back");
            String Choice = input.readLine();
            switch (Choice) {
                case "1":
                    return Role.STUDENT;
                case "2":
                    return Role.STAFF;
                case "3":
                    return Role.RECEPTIONIST;
                case "4":
                    return Role.ADMIN;
                case "0":
                    Repeat = false;
            }
            System.out.println("Input not recognised");
        }
        return null;
    }

    public void CreateUser(Role role) throws IOException {
        String NameInput = "";
        String Password = "";
        Date DoBInput = null;
        Department department = null;
        boolean Name = true;
        while (Name) {
            System.out.print("Please enter the persons name: ");
            NameInput = input.readLine();
            if (NameInput.matches("^[a-zA-Z]+$")) {
                Name = false;
            }
        }
        if (role == Role.STUDENT) {
            boolean DoB = true;
            while (DoB) {
                System.out.print("Please enter the DoB: ");
                try {
                    DoBInput = new Date(input.readLine());
                    DoB = false;
                }
                catch (Exception e) {
                    System.out.println("Incorrect Date Format, Please Try Again!");
                }
            }
            TSystem.addPeople(new Student(NameInput, DoBInput));
        }
        if (role == Role.STAFF) {
            boolean Repeat = true;
            while (Repeat) {
                System.out.println("1. " + Department.BUSINESS + "\n2. " + Department.ENGLISH + "\n3. " + Department.FOOD + "\n4. " + Department.IT + "\n5. " + Department.MATHS + "\n6. " + Department.SCIENCE + "\n0. Back");
                String Choice = input.readLine();
                switch (Choice) {
                    case "1":
                        department = Department.BUSINESS;
                        Repeat = false;
                        break;
                    case "2":
                        department = Department.ENGLISH;
                        Repeat = false;
                        break;
                    case "3":
                        department = Department.FOOD;
                        Repeat = false;
                        break;
                    case "4":
                        department = Department.IT;
                        Repeat = false;
                        break;
                    case "5":
                        department = Department.MATHS;
                        Repeat = false;
                        break;
                    case "6":
                        department = Department.SCIENCE;
                        Repeat = false;
                        break;
                    case "0":
                        Repeat = false;
                }
            }
            TSystem.addPeople(new Staff(NameInput, department));
        }
        if (role == Role.RECEPTIONIST) {
            boolean Pass = true;
            while (Pass) {
                System.out.print("Please enter the Receptionists password: ");
                Password = input.readLine();
                if (!Password.isEmpty()) {
                    Pass = false;
                }
            }
            TSystem.addPeople(new Receptionist(NameInput, Password));
        }
        if (role == Role.ADMIN) {
            boolean Pass = true;
            while(Pass) {
                System.out.print("Please enter the Admins password: ");
                Password = input.readLine();
                if (!Password.isEmpty()) {
                    Pass = false;
                }
            }
            TSystem.addPeople(new Admin(NameInput, Password));
        }

    }

    public void DisplayUsers(ArrayList<Person> Array) throws IOException {
        boolean y = true;
        int Page = 0;
        while (y) {
            System.out.println("-------------------");
            int Limit = Array.size() - 1 < (Page + 1) * 7 ? Array.size() - 1 : ((Page + 1) * 7) - 1;
            int Count = 1;
            for (int i = (Page * 7); i <= Limit; i++) {
                System.out.println(Count + ". ");
                System.out.println(Array.get(i).toString());
                Count++;
            }
            System.out.println("\nPlease select the number of the chosen Ticket or '8' for the previous page, '9' for the next page or '0' to go back");
            String Choice = input.readLine();
            switch(Choice) {
                case "0":
                    y = false;
                    break;
                case "1":
                    DisplayChosenUser(Array.get(Page * 7));
                    break;
                case "2":
                    DisplayChosenUser(Array.get(Page * 7 + 1));
                    break;
                case "3":
                    DisplayChosenUser(Array.get(Page * 7 + 2));
                    break;
                case "4":
                    DisplayChosenUser(Array.get(Page * 7 + 3));
                    break;
                case "5":
                    DisplayChosenUser(Array.get(Page * 7 + 4));
                    break;
                case "6":
                    DisplayChosenUser(Array.get(Page * 7 + 5));
                    break;
                case "7":
                    DisplayChosenUser(Array.get(Page * 7 + 6));
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

    public void DisplayChosenUser(Person person) throws IOException {
        boolean Display = true;
        while (Display) {
            System.out.println("---- Viewing Users ----");
            System.out.println(person.toString());
            System.out.println("-------------------------");
            System.out.println("Please Make your choice: ");
            System.out.println("1. Edit User\n2. Delete User\n0. Back");
            String Choice = input.readLine();
            switch (Choice) {
                case "1":
                    EditUser(person);
                    break;
                case "2":
                    TSystem.removePerson(person);
                    break;
                case "0":
                    Display = false;
                    break;
            }
        }
    }

    public void EditUser(Person person) throws IOException {
        boolean Display = true;
        while (Display) {
            int count = 2;
            System.out.println("----Edit Person----");
            System.out.println(person.toString());
            System.out.println("--------------------");
            System.out.println("1. Change Name");
            if (person instanceof User) {
                System.out.println(count + ". Change Password");
                count++;
            }
            if (person instanceof Student) {
                System.out.println(count + ". Change DoB");
                count++;
            }
            if (person instanceof Staff) {
                System.out.println(count + ". Change Department");
                count++;
            }
            System.out.println("0. Back");
            String Choice = input.readLine();
            switch (Choice) {
                case "1":
                    System.out.print("Please enter the new name: ");
                    person.setName(input.readLine());
                    person.setPersonID();
                    break;
                case "2":
                    if (person instanceof User) {
                        ((User) person).setPassword(input.readLine());
                    }
                    else {
                        System.out.println("This person does not have a password stored");
                    }
                    break;
                case "3":
                    if (person instanceof Student) {
                        ((Student) person).setDoB(ChangeDoB());
                    }
                    else {
                        System.out.println("This person does not have a DoB stored");
                    }
                    break;
                case "4":
                    if (person instanceof Staff) {
                        ((Staff) person).setDepartment(ChangeDepartment());
                    }
                    else {
                        System.out.println("This person does not have a Department stored");
                    }
                    break;
                case "0":
                    Display = false;
                    break;
            }
        }
    }

    public Department ChangeDepartment() throws IOException {
        boolean Repeat = true;
        while (Repeat) {
            System.out.println("1. " + Department.BUSINESS + "\n2. " + Department.ENGLISH + "\n3. " + Department.FOOD + "\n4. " + Department.IT + "\n5. " + Department.MATHS + "\n6. " + Department.SCIENCE + "\n0. Back");
            String Choice = input.readLine();
            switch (Choice) {
                case "1":
                    return Department.BUSINESS;
                case "2":
                    return Department.ENGLISH;
                case "3":
                    return Department.FOOD;
                case "4":
                    return Department.IT;
                case "5":
                    return Department.MATHS;
                case "6":
                    return Department.SCIENCE;
                case "0":
                    Repeat = false;
            }
        }
        return null;
    }

    public Date ChangeDoB() throws IOException {
        boolean Repeat = true;
        while (Repeat) {
            System.out.println("Please enter the new DoB or 0 to go back");
            String Input = input.readLine();
            if (Input.equals("0")){
                Repeat = false;
            }
            else {
                try {
                    System.out.print("DoB: ");
                    Date date = new Date(Input);
                    return date;
                } catch (Exception e) {
                    System.out.println("Incorrect Format, please try again");
                }
            }
        }
        return null;
    }

    public void MainMenu() throws IOException {
        boolean LogOut = false;
        while (LogOut == false) {
            System.out.println("Loading Menu\nPlease select what you would like to do:");
            System.out.println("1. View To Do list\n2. View all tickets\n3. Search tickets\n0. Log Out");
            String Choice = input.readLine();
            switch (Choice) {
                case "1":
                    ToDoList();
                    break;
                case "2":
                    DisplayTickets(TSystem.getTickets());
                    break;
                case "3":
                    SearchMenu();
                    break;
                case "0":
                    LogOut = true;
            }
        }
        Login();
    }

    public void ToDoList() throws IOException {
        System.out.println("-------Loading To Do List--------");
        DisplayTickets(LoggedInReceptionist.getToDo());
    }

    public void SearchMenu() throws IOException {
        boolean SearchMenu = true;
        String[] Parameters = new String[7];
        String[] Output = new String[7];
        Person ReportedBy = null;
        Receptionist AddedBy = null;
        while (SearchMenu) {
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
            System.out.println("1. Ticket ID" + Output[0] + "\n2. Added By" + Output[1] + "\n3. Status" + Output[2] + "\n4. Reported By" + Output[3] + "\n5. Equipment Effected" + Output[4] + "\n0. Back");
            String Choice = input.readLine();
                switch (Choice) {
                    case "":
                        DisplayTickets(TSystem.searchTickets(Parameters, ReportedBy, AddedBy));
                        break;
                    case "1":
                        String ID = SearchSetParameter("Ticket ID");
                        if (!ID.equals("REMOVE")) {
                            Parameters[0] = ID;
                        }
                        else {
                            Parameters[0] = "";
                        }
                        break;
                    case "2":
                        String Add = SearchSetParameter("Added By");
                        if (!Add.equals("REMOVE")) {
                            AddedBy = TSystem.getReceptionist(Add);
                            try {
                                Parameters[1] = AddedBy.getName();
                            }
                            catch (NullPointerException e) {
                                System.out.println("No Receptionist Found!");
                            }
                        }
                        else {
                            Parameters[1] = "";
                            AddedBy = null;
                        }
                        break;
                    case "3":
                        Parameters[2] = SearchStatus();
                        break;
                    case "4":
                        String By = SearchSetParameter("Reported By");
                        if (!By.equals("REMOVE")) {
                            ReportedBy = TSystem.getUser(By);
                            try {
                                Parameters[3] = ReportedBy.getName();
                            }
                            catch (NullPointerException e) {
                                System.out.println("No user Found!");
                            }
                        }
                        else {
                            Parameters[3] = "";
                            ReportedBy = null;
                        }
                        break;
                    case "5":
                        Parameters[4] = SearchEquipment();
                        break;
                    case "0":
                        SearchMenu = false;
                        break;
                }
        }

    }

    public String SearchSetParameter(String Parameter) throws IOException{
        System.out.print("\n-----------------------\n\nPlease enter the " + Parameter + ", 0 to clear: ");
        String choice = input.readLine();
        if (choice.equals("0")) {
            return "REMOVE";
        }
        else {
            return choice;
        }
    }

    public String SearchStatus() throws IOException {
        boolean Repeat = true;
        while (Repeat) {
            System.out.println("Please select the Status");
            System.out.println("1. New\n2. Responded\n3. Closed\n0. Back");
            String choice = input.readLine();
            switch (choice) {
                case "1":
                    return Status.NEW.toString();
                case "2":
                    return Status.RESPONDED.toString();
                case "3":
                    return Status.CLOSED.toString();
                case "0":
                    Repeat = false;
                    break;
            }

        }
        return "";
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
            for (int i = (Page * 7); i <= Limit; i++) {
                System.out.println(Count + ". ");
                System.out.println(Array.get(i).Display());
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
