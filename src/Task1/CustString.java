package Task1;

public class CustString {
    char[] MyString = new char[50]; // Create the variable for the char Array
    int StringLength = 0;

    public CustString(char[] InputString) { // Constructor
        int Limit = 5;
        if (InputString.length > Limit) { // If the given array is longer than the limit
            StringLength = Limit;
            System.out.println("The given String is too long. The String has been cut short");
            for (int i = 0; i < Limit; i++) { // For each char until the limit
                this.MyString[i] = InputString[i]; // Store the given char into the same position in the local char array
            }
        }
        else { // If the given array is not longer than the limit
            for (char c:InputString) {
                StringLength++;
            }
            this.MyString = InputString; // Store the given char array as the local one
        }
    }

    public int getLength() { // Return an int of the length of the String
        return StringLength; // Return the stored variable set in the constructor
    }

    public int getPosition(char Letter) { // Return the position of a char in the String
        for (int i = 0; i < StringLength; i++) { // For each ranging from 0 to the array length (accommodates for all sizes)
            if (MyString[i] == Letter) { // If the stored char matches the input char
                return i + 1; // Return that int + 1 (to accommodate for arrays starting at 0)
            }
        }
        return 0; // if no results, return 0
    }

    @Override
    public String toString() { // Overwrite the .toString method
        return new String(MyString); // Return the stored char array as a newly created String
    }
}
