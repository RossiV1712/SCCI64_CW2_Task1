package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

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
        System.out.println("Welcome to " + TSystem.getSystemName() + " Helpdesk"); // Display the System Name
        System.out.println("------------- Log In -----------------" );
        System.out.print("Enter User ID: "); // Ask for user ID
        String userID = input.readLine(); // Store the input
        System.out.print("Enter Password: "); // Ask for password
        String password = input.readLine(); // Store the input

        if (CheckLogIn(userID, password)) { // Run the check log in function with given userID and password and run if statement if return true
            System.out.println("Logged In!");
            if (ALoggedIn) { // If ALoggedIn is true
                AdminMainMenu(); // Run the function so show the admin menu
            }
            else { // Otherwise
                MainMenu(); // Show the normal main menu by running the function
            }
        }
        else { // If log in failed
            System.out.println("Failed!"); // Display message
        }
    }

    private boolean CheckLogIn(String userID, String password) { // Function to check users credentials
        User User = TSystem.getUser(userID); // Get the user from the system
        if (User != null) {  // If the user exists in the system
            if (password.equals(User.getPassword())) { // Check their password using the User class method
                LoggedInUser = User; // Store that the user is logged in
                if (User.getRole() == Role.ADMIN) { // Check if the role of the logged in user is admin
                    ALoggedIn = true; // If so then set ALoggedIn to true
                }
                else { // Otherwise
                    LoggedInReceptionist = TSystem.getReceptionist(userID); //Get the Receptionist object and store it
                }
                return true; // Return true as log in success
            }
        }
        return false; // Return false as log in failure
    }

    public void AdminMainMenu() throws IOException { // Show admin main menu
        boolean LogOut = false; // Set the variable to false
        while (LogOut == false) { // Whilst false
            System.out.println("Loading Admin Menu\nPlease select what you would like to to: "); // Show Menu and options
            System.out.println("1. View Users\n2. Create User\n3. Search Users\n0. Log Out");
            String choice = input.readLine(); // Store the input
            switch (choice) { // Run switch on input // Run switch on input
                case "1": // If given case
                    DisplayUsers(TSystem.getPeople()); // Show all Persons in the system using DisplayUsers function and TSystem.getPeople to retrieve people
                    break; // end this switch statement
                case "2": // If given case
                    Role Chosen = SelectUser(); // Return a Role
                    if (Chosen != null) { // If there is a Role selected
                        CreateUser(Chosen); // Create the user using given Role
                    }
                    else {
                        System.out.println("No role chosen, please try again");
                    }
                    break; // end this switch statement
                case "3": // If given case
                    DisplayUsers(SearchUsers()); //Null check
                    break; // end this switch statement
                case "0": // If given case
                    LogOut = true; // Stop the while statement
                    break; // end this switch statement
            }
        }
    }

    public ArrayList<Person> SearchUsers() throws IOException {
        String NameInput = ""; // Initialise the variables to use in the function
        String UserIDInput = "";
        boolean Repeat = true; // Set to true
        while (Repeat) { // While true
            String Choice = ""; // Set Choice to "" each iteration
            System.out.println("What would you like to search:"); // Ask question and show responses
            System.out.println("Enter to search\n1. Name: " + NameInput + "\n2. User ID: " + UserIDInput + "\n0. Back");
            Choice = input.readLine(); // Store the input
            switch (Choice) { // Run switch on input
                case "": // If given case
                    return TSystem.searchPeople(UserIDInput, NameInput); // Return the arraylist from the TicketSystem searchPeople function using given variables
                case "1": // If given case
                    if (!NameInput.isEmpty()) { // As long as NameInput is not empty
                        System.out.println("0. To clear");
                    }
                    System.out.print("Please enter the name: ");
                    String NInput = input.readLine(); // Store the input
                    if (NInput.equals("0")) { // If input is 0
                        NameInput = ""; // Set to ""
                    }
                    else if (NInput.matches("^[a-zA-Z]+$")) { // Else if input is only letters
                        NameInput = NInput; // Store input
                    }
                    break; // end this switch statement
                case "2": // If given case
                    if (!UserIDInput.isEmpty()) { // As long as not empty
                        System.out.println("0. To clear");
                    }
                    System.out.print("Please enter the User ID: ");
                    UserIDInput = input.readLine(); // Store the input
                    if (UserIDInput.equals("0")) {
                        UserIDInput = "";
                    }
                    break; // end this switch statement
                case "0": // If given case
                    Repeat = false; // Stop the while statement
            }
        }
        return null;
    }

    public Role SelectUser() throws IOException {
        boolean Repeat = true;
        while (Repeat) {
            System.out.println("1. Student\n2. Staff\n3. Receptionist\n4. Admin\n0. Back");
            String Choice = input.readLine(); // Store the input
            switch (Choice) { // Run switch on input
                case "1": // If given case
                    return Role.STUDENT;
                case "2": // If given case
                    return Role.STAFF;
                case "3": // If given case
                    return Role.RECEPTIONIST;
                case "4": // If given case
                    return Role.ADMIN;
                case "0": // If given case
                    Repeat = false; // Stop the while statement
            }
            System.out.println("Input not recognised");
        }
        return null;
    }

    public void CreateUser(Role role) throws IOException {
        String NameInput = ""; // Intialise variables
        String Password = "";
        Date DoBInput = null;
        Department department = null;
        boolean Name = true; // Set variable to true
        while (Name) { // While true
            System.out.print("Please enter the persons name: ");
            NameInput = input.readLine(); // Store the input
            if (NameInput.matches("^[a-zA-Z]+$")) { // If input is only letters
                Name = false; // Stop the while statement
            }
        }
        if (role == Role.STUDENT) {
            boolean DoB = true; // Set variable to true
            while (DoB) { // While true
                System.out.print("Please enter the DoB: ");
                try {
                    DoBInput = new Date(input.readLine()); // Store the input
                    DoB = false; // Stop the while statement
                }
                catch (Exception e) {
                    System.out.println("Incorrect Date Format, Please Try Again!");
                }
            }
            TSystem.addPeople(new Student(NameInput, DoBInput)); // Add person to system
        }
        if (role == Role.STAFF) {
            boolean Repeat = true;
            while (Repeat) {
                System.out.println("1. " + Department.BUSINESS + "\n2. " + Department.ENGLISH + "\n3. " + Department.FOOD + "\n4. " + Department.IT + "\n5. " + Department.MATHS + "\n6. " + Department.SCIENCE + "\n0. Back");
                String Choice = input.readLine(); // Store the input
                switch (Choice) { // Run switch on input
                    case "1": // If given case
                        department = Department.BUSINESS; // Store chosen Department
                        Repeat = false; // Stop the while statement
                        break; // end this switch statement
                    case "2": // If given case
                        department = Department.ENGLISH; // Store chosen Department
                        Repeat = false; // Stop the while statement
                        break; // end this switch statement
                    case "3": // If given case
                        department = Department.FOOD; // Store chosen Department
                        Repeat = false; // Stop the while statement
                        break; // end this switch statement
                    case "4": // If given case
                        department = Department.IT; // Store chosen Department
                        Repeat = false; // Stop the while statement
                        break; // end this switch statement
                    case "5": // If given case
                        department = Department.MATHS; // Store chosen Department
                        Repeat = false; // Stop the while statement
                        break; // end this switch statement
                    case "6": // If given case
                        department = Department.SCIENCE; // Store chosen Department
                        Repeat = false; // Stop the while statement
                        break; // end this switch statement
                    case "0": // If given case
                        Repeat = false; // Stop the while statement
                }
            }
            TSystem.addPeople(new Staff(NameInput, department)); // Add person to system
        }
        if (role == Role.RECEPTIONIST) {
            boolean Pass = true;
            while (Pass) {
                System.out.print("Please enter the Receptionists password: ");
                Password = input.readLine(); // Store the input
                if (!Password.isEmpty()) {
                    Pass = false; // Stop the while statement
                }
            }
            TSystem.addPeople(new Receptionist(NameInput, Password)); // Add person to system
        }
        if (role == Role.ADMIN) {
            boolean Pass = true;
            while(Pass) {
                System.out.print("Please enter the Admins password: ");
                Password = input.readLine(); // Store the input
                if (!Password.isEmpty()) {
                    Pass = false; // Stop the while statement
                }
            }
            TSystem.addPeople(new Admin(NameInput, Password)); // Add person to system
        }

    }

    public void DisplayUsers(ArrayList<Person> Array) throws IOException {
        boolean y = true;
        int Page = 0;
        while (y) {
            System.out.println("-------------------");
            int Limit = Array.size() - 1 < (Page + 1) * 7 ? Array.size() - 1 : ((Page + 1) * 7) - 1; // Store limit as smallest out of array size or end of page
            int Count = 1; // Start count
            for (int i = (Page * 7); i <= Limit; i++) { // for each up to limit
                System.out.println(Count + ". "); // Show current count
                System.out.println(Array.get(i).toString()); // Show user in place
                Count++;
            }
            System.out.println("\nPlease select the number of the chosen Ticket or '8' for the previous page, '9' for the next page or '0' to go back");
            String Choice = input.readLine(); // Store the input
            switch(Choice) { // Run switch on input
                case "0": // If given case
                    y = false; // Stop the while statement
                    break; // end this switch statement
                case "1": // If given case
                    DisplayChosenUser(Array.get(Page * 7));
                    break; // end this switch statement
                case "2": // If given case
                    DisplayChosenUser(Array.get(Page * 7 + 1));
                    break; // end this switch statement
                case "3": // If given case
                    DisplayChosenUser(Array.get(Page * 7 + 2));
                    break; // end this switch statement
                case "4": // If given case
                    DisplayChosenUser(Array.get(Page * 7 + 3));
                    break; // end this switch statement
                case "5": // If given case
                    DisplayChosenUser(Array.get(Page * 7 + 4));
                    break; // end this switch statement
                case "6": // If given case
                    DisplayChosenUser(Array.get(Page * 7 + 5));
                    break; // end this switch statement
                case "7": // If given case
                    DisplayChosenUser(Array.get(Page * 7 + 6));
                    break; // end this switch statement
                case "8": // If given case
                    if (Page > 0) {
                        Page--;
                    }
                    else {
                        System.out.println("First page reached!");
                    }
                    break; // end this switch statement
                case "9": // If given case
                    if (Array.size() >= ((Page + 1) * 7)) {
                        Page++;
                    }
                    else {
                        System.out.println("Max page reached!");
                    }
                    break; // end this switch statement
            }
        }
    }

    public void DisplayChosenUser(Person person) throws IOException {
        boolean Display = true; // Set variable to true
        while (Display) { // While true
            System.out.println("---- Viewing Users ----");
            System.out.println(person.toString()); // Show chosen person
            System.out.println("-------------------------");
            System.out.println("Please Make your choice: ");
            System.out.println("1. Edit User\n2. Delete User\n0. Back"); // Show options
            String Choice = input.readLine(); // Store the input
            switch (Choice) { // Run switch on input
                case "1": // If given case
                    EditUser(person);
                    break; // end this switch statement
                case "2": // If given case
                    TSystem.removePerson(person);
                    break; // end this switch statement
                case "0": // If given case
                    Display = false; // Stop the while statement
                    break; // end this switch statement
            }
        }
    }

    public void EditUser(Person person) throws IOException {
        boolean Display = true; // Set variable to true
        while (Display) { // While true
            int count = 2;
            System.out.println("----Edit Person----");
            System.out.println(person.toString()); // Show Person
            System.out.println("--------------------");
            System.out.println("1. Change Name");
            if (person instanceof User) { // If person is user
                System.out.println(count + ". Change Password");
                count++; // Add 1 to count
            }
            if (person instanceof Student) { // If person is Student
                System.out.println(count + ". Change DoB");
                count++; // Add 1 to count
            }
            if (person instanceof Staff) { // If person is Staff
                System.out.println(count + ". Change Department");
                count++; // Add 1 to count
            }
            System.out.println("0. Back");
            String Choice = input.readLine(); // Store the input
            switch (Choice) { // Run switch on input
                case "1": // If given case
                    System.out.print("Please enter the new name: ");
                    person.setName(input.readLine()); // Store the input
                    person.setPersonID(); // Set person ID
                    break; // end this switch statement
                case "2": // If given case
                    if (person instanceof User) { // If person is User
                        ((User) person).setPassword(input.readLine()); // Store the input
                    }
                    else {
                        System.out.println("This person does not have a password stored");
                    }
                    break; // end this switch statement
                case "3": // If given case
                    if (person instanceof Student) { // If person is Student
                        ((Student) person).setDoB(ChangeDoB()); // Set DoB from returned variable
                    }
                    else {
                        System.out.println("This person does not have a DoB stored");
                    }
                    break; // end this switch statement
                case "4": // If given case
                    if (person instanceof Staff) { // If person is Staff
                        ((Staff) person).setDepartment(ChangeDepartment()); // Set department from returned variable
                    }
                    else {
                        System.out.println("This person does not have a Department stored");
                    }
                    break; // end this switch statement
                case "0": // If given case
                    Display = false; // Stop the while statement
                    break; // end this switch statement
            }
        }
    }

    public Department ChangeDepartment() throws IOException {
        boolean Repeat = true;
        while (Repeat) {
            System.out.println("1. " + Department.BUSINESS + "\n2. " + Department.ENGLISH + "\n3. " + Department.FOOD + "\n4. " + Department.IT + "\n5. " + Department.MATHS + "\n6. " + Department.SCIENCE + "\n0. Back");
            String Choice = input.readLine(); // Store the input
            switch (Choice) { // Run switch on input
                case "1": // If given case
                    return Department.BUSINESS; // Return Department
                case "2": // If given case
                    return Department.ENGLISH; // Return Department
                case "3": // If given case
                    return Department.FOOD; // Return Department
                case "4": // If given case
                    return Department.IT; // Return Department
                case "5": // If given case
                    return Department.MATHS; // Return Department
                case "6": // If given case
                    return Department.SCIENCE; // Return Department
                case "0": // If given case
                    Repeat = false; // Stop the while statement
            }
        }
        return null;
    }

    public Date ChangeDoB() throws IOException {
        boolean Repeat = true; // Set variable to true
        while (Repeat) { // While true
            System.out.println("Please enter the new DoB or 0 to go back");
            String Input = input.readLine(); // Store the input
            if (Input.equals("0")){ // If input is 0
                Repeat = false; // End while loop
            }
            else { // Otherwise
                try {
                    System.out.print("DoB: ");
                    Date date = new Date(Input); //Store date input
                    return date;
                } catch (Exception e) { // If exception
                    System.out.println("Incorrect Format, please try again"); //Explain error
                }
            }
        }
        return null;
    }

    public void MainMenu() throws IOException {
        boolean LogOut = false;
        while (LogOut == false) {
            System.out.println("Loading Menu\nPlease select what you would like to do:");
            System.out.println("1. View To Do list\n2. View all tickets\n3. Search tickets\n4. Create standard ticket\n5. Create technical ticket\n0. Log Out"); // Display options
            String Choice = input.readLine(); // Store the input
            switch (Choice) { // Run switch on input
                case "1": // If given case
                    ToDoList();
                    break; // end this switch statement
                case "2": // If given case
                    DisplayTickets(TSystem.getTickets());
                    break; // end this switch statement
                case "3": // If given case
                    SearchMenu();
                    break; // end this switch statement
                case "4": // If given case
                    CreateTicket();
                    break;
                case "5":
                    CreateTechTicket();
                    break;
                case "0": // If given case
                    LogOut = true; // Stop the while statement
            }
        }
        Login();
    }

    public void CreateTicket() throws IOException {
        boolean DetailsRepeat = true;
        while (DetailsRepeat) {
            System.out.println("Please input the details of the ticket: ");
            String Input = input.readLine();
            if (!Input.isEmpty()) {
                TSystem.addTickets(new Ticket(Input, LoggedInReceptionist));
                DetailsRepeat = false;
            }
        }
    }

    public void CreateTechTicket() throws IOException {
        String Details = "";
        Equipment EquipEffected = null;
        Person ReportedBy = null;
        boolean DetailsRepeat = true;
        while (DetailsRepeat) {
            System.out.println("Please input the details of the ticket: ");
            String Input = input.readLine();
            if (!Input.isEmpty()) {
                Details = Input;
                DetailsRepeat = false;
            }
        }
        boolean EquipRepeat = true;
        while (EquipRepeat) {
            int Count = 1;
            for (Equipment E : Equipment.values()) {
                System.out.println(Count + ". " + E);
                Count++;
            }
            String Input = input.readLine(); // Store the input
            switch (Input) {
                case "1":
                    EquipEffected = Equipment.LIGHTS;
                    EquipRepeat = false;
                    break;
                case "2":
                    EquipEffected = Equipment.DOOR;
                    EquipRepeat = false;
                    break;
                case "3":
                    EquipEffected = Equipment.BATHROOM;
                    EquipRepeat = false;
                    break;
                case "4":
                    EquipEffected = Equipment.COMPUTER;
                    EquipRepeat = false;
                    break;
                case "5":
                    EquipEffected = Equipment.PERIPHERAL;
                    EquipRepeat = false;
                    break;
                case "6":
                    EquipEffected = Equipment.OTHER;
                    EquipRepeat = false;
                    break;
            }
        }
        boolean ReportedByRepeat = true;
        while (ReportedByRepeat) {
            System.out.println("Please input the person who reported the ticket: ");
            String Input = input.readLine();
            Person Report = TSystem.searchPeople(Input);
            if (!Report.getName().equals("") && !(Report instanceof User)) {
                ReportedBy = Report;
                ReportedByRepeat = false;
            }
        }
        TSystem.addTickets(new TechnicalTicket(Details, LoggedInReceptionist, EquipEffected, ReportedBy));
    }

    public void ToDoList() throws IOException {
        System.out.println("-------Loading To Do List--------");
        DisplayTickets(LoggedInReceptionist.getToDo()); // Display all items from ToDO list using DisplayTickets function
    }

    public void SearchMenu() throws IOException {
        boolean SearchMenu = true; // Set to true
        String[] Parameters = new String[7];
        String[] Output = new String[7];
        Person ReportedBy = null;
        Receptionist AddedBy = null;
        Equipment EquipEffect = null;
        while (SearchMenu) { // While true
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
            System.out.println("1. Ticket ID" + Output[0] + "\n2. Added By" + Output[1] + "\n3. Status" + Output[2] + "\n4. Reported By" + Output[3] + "\n5. Equipment Effected" + EquipEffect + "\n0. Back"); // Show options
            String Choice = input.readLine(); // Store the input
                switch (Choice) { // Run switch on input
                    case "": // If given case
                        if (EquipEffect != null) {
                            DisplayTickets(TSystem.searchTickets(Parameters, ReportedBy, AddedBy, EquipEffect));
                        }
                        else {
                            DisplayTickets(TSystem.searchTickets(Parameters, ReportedBy, AddedBy));
                        }
                        break; // end this switch statement
                    case "1": // If given case
                        String ID = SearchSetParameter("Ticket ID"); // Store the ID returned from the function
                        if (!ID.equals("REMOVE")) { // As long as ID is not "REMOVE"
                            Parameters[0] = ID; // Store ID as parameter[0]
                        }
                        else {
                            Parameters[0] = "";
                        }
                        break; // end this switch statement
                    case "2": // If given case
                        String Add = SearchSetParameter("Added By"); // Store As String
                        if (!Add.equals("REMOVE")) { // As long as Add in not "REMOVE"
                            AddedBy = TSystem.getReceptionist(Add); // Store Receptionist as Addedby
                            try {
                                Parameters[1] = AddedBy.getName(); // Store Name
                            }
                            catch (NullPointerException e) { // On Exception
                                System.out.println("No Receptionist Found!"); // Display Text
                            }
                        }
                        else {
                            Parameters[1] = "";
                            AddedBy = null;
                        }
                        break; // end this switch statement
                    case "3": // If given case
                        Parameters[2] = SearchStatus();
                        break; // end this switch statement
                    case "4": // If given case
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
                        break; // end this switch statement
                    case "5": // If given case
                        EquipEffect = SearchEquipment();
                        break; // end this switch statement
                    case "0": // If given case
                        SearchMenu = false; // Stop the while statement
                        break; // end this switch statement
                }
        }

    }

    public String SearchSetParameter(String Parameter) throws IOException{
        System.out.print("\n-----------------------\n\nPlease enter the " + Parameter + ", 0 to clear: ");
        String choice = input.readLine(); // Store the input
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
            String choice = input.readLine(); // Store the input
            switch (choice) { // Run switch on input
                case "1": // If given case
                    return Status.NEW.toString();
                case "2": // If given case
                    return Status.RESPONDED.toString();
                case "3": // If given case
                    return Status.CLOSED.toString();
                case "0": // If given case
                    Repeat = false; // Stop the while statement
                    break; // end this switch statement
            }

        }
        return "";
    }

    public Equipment SearchEquipment() throws IOException {
        boolean EquipRepeat = true;
        while (EquipRepeat) {
            int Count = 1;
            for (Equipment E : Equipment.values()) {
                System.out.println(Count + ". " + E);
                Count++;
            }
            String Input = input.readLine(); // Store the input
            switch (Input) {
                case "1":
                    return Equipment.LIGHTS;
                case "2":
                    return Equipment.DOOR;
                case "3":
                    return Equipment.BATHROOM;
                case "4":
                    return Equipment.COMPUTER;
                case "5":
                    return Equipment.PERIPHERAL;
                case "6":
                    return Equipment.OTHER;
            }
        }
        return null;
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
            String Choice = input.readLine(); // Store the input
            switch(Choice) { // Run switch on input
                case "0": // If given case
                    y = false; // Stop the while statement
                    break; // end this switch statement
                case "1": // If given case
                    DisplayChosenTicket(Array.get(Page * 7));
                    break; // end this switch statement
                case "2": // If given case
                    DisplayChosenTicket(Array.get(Page * 7 + 1));
                    break; // end this switch statement
                case "3": // If given case
                    DisplayChosenTicket(Array.get(Page * 7 + 2));
                    break; // end this switch statement
                case "4": // If given case
                    DisplayChosenTicket(Array.get(Page * 7 + 3));
                    break; // end this switch statement
                case "5": // If given case
                    DisplayChosenTicket(Array.get(Page * 7 + 4));
                    break; // end this switch statement
                case "6": // If given case
                    DisplayChosenTicket(Array.get(Page * 7 + 5));
                    break; // end this switch statement
                case "7": // If given case
                    DisplayChosenTicket(Array.get(Page * 7 + 6));
                    break; // end this switch statement
                case "8": // If given case
                    if (Page > 0) { // As long as not page 0
                        Page--; // Go back one page
                    }
                    else {
                        System.out.println("First page reached!");
                    }
                    break; // end this switch statement
                case "9": // If given case
                    if (Array.size() >= ((Page + 1) * 7)) { // if array size is larger than end of page
                        Page++; // Add one to Page
                    }
                    else {
                        System.out.println("Max page reached!");
                    }
                    break; // end this switch statement
            }
        }
    }

    public void DisplayChosenTicket(Ticket ticket) throws IOException {
        boolean Display = true; // Set to true
        String ToDoString; // Initialise variables
        boolean ToDo = false;
        while (Display) { // While true
            System.out.println(LoggedInReceptionist.getToDo());
            if (LoggedInReceptionist.getToDo().contains(ticket)) { // If ticket on ToDo list
                ToDoString = "Remove from To Do list"; // Set String
                ToDo = false; // Set ToDo to false
            }
            else { // Otherwise
                ToDoString = "Add to To Do list"; // Set String
                ToDo = true; // Set ToDo to true
            }
            System.out.println("---- Viewing Ticket ----"); //Show what is going on
            System.out.println(ticket.Display()); // Display current ticket
            System.out.println("-------------------------");
            System.out.println("Please Make your choice: ");
            System.out.println("1. Update Ticket\n2. Close Ticket\n3. " + ToDoString + "\n0. Back"); // Show options
            String Choice = input.readLine(); // Store the input
            switch (Choice) { // Run switch on input
                case "1": // If given case
                    UpdateAction(ticket); // Run the function to add update action to ticket
                    break; // end this switch statement
                case "2": // If given case
                    CloseAction(ticket); // Run the function to add close action to ticket
                    break; // end this switch statement
                case "3": // If given case
                    if (ToDo) { // If not added to ToDo
                        LoggedInReceptionist.AddToToDo(ticket); // Add to ToDo
                    }
                    else { // If added to ToDo
                        LoggedInReceptionist.RemoveFromToDo(ticket); // Remove from ToDo
                    }
                    break; // end this switch statement
                case "0": // If given case
                    Display = false; // Stop the while statement
                    break; // end this switch statement
            }
        }
    }

    public void UpdateAction(Ticket ticket) throws IOException {
        Boolean Repeat = true; // Set variable to true
        while (Repeat) { // While true
            System.out.println("---- Adding Action ----"); // Show what is going on
            System.out.println(ticket.Display()); // Display current ticket
            System.out.println("Please enter the comment and press enter to submit, enter 0 to go back"); // Display options
            String Input = input.readLine(); // Store the input
            if (Input.equals("0")) { // If input is 0
                Repeat = false; // Stop the while statement
            }
            else if (!Input.isEmpty()) { // If input is not empty
                ticket.addAction(new Update(LoggedInUser, Input)); // Add action to ticket form of Update using logged on user and comment
                ticket.setCurrentStatus(Status.RESPONDED); // Set the Status of the ticket to Responded
                Repeat = false; // Stop the while statement
            } else {
                System.out.println("Error occurred, please check input"); // Display on error
            }
        }
    }

    public void CloseAction(Ticket ticket) throws IOException {
        Boolean Repeat = true; // Set the value to true
        while (Repeat) { // Whilst true
            System.out.println("---- Adding Resolution ----"); // Show what is going on
            System.out.println(ticket.Display()); // Display the current ticket
            System.out.println("Please enter the comment and press enter to submit and close the ticket, enter 0 to go back"); // Show what is going on
            String Input = input.readLine(); // Store the input
            if (Input.equals("0")) { // If the input is 0
                Repeat = false; // Stop the while statement
            }
            else if (!Input.isEmpty()) { // If the input is not empty
                ticket.addAction(new Close(LoggedInUser, Input)); // addAction function in Ticket to add close Action by the logged in user with comment
                ticket.setCurrentStatus(Status.CLOSED); // Set the Status to closed for this ticket
                Repeat = false; // Stop the while statement
            }
            else {
                System.out.println("Error occurred, please check input"); // Explain any error
            }
        }
    }

}
