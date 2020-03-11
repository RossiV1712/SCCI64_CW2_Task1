package Task1;

public class CustString {
    char[] MyString = new char[50]; // Create the variable for the char Array
    int StringLength = 0; // Create the variable for the length of the Array

    public CustString(char[] InputString) { // Constructor
        int Limit = 50; // Set the limit to the desired
        int InputStringLength = 0; // Set the initial string length to 0
        for (char c:InputString) { // For each character in the input string
            InputStringLength++; // Count once for each iteration
        }
        if (InputStringLength > Limit) { // If the given array is longer than the limit
            StringLength = Limit; // Store the limit as the String length
            for (int i = 0; i < Limit; i++) { // For each char until the limit
                this.MyString[i] = InputString[i]; // Store the given char into the same position in the local char array
            }
        }
        else { // If the given array is not longer than the limit
            for (char c:InputString) { // For each character in the input string
                StringLength++; // Count once for each iteration
            }
            this.MyString = InputString; // Store the given char array as the local one
        }
    }

    public int getLength() { // Return an int of the length of the String
        StringLength = 0;
        for (char c:MyString) {
            StringLength++;
        }
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

    public void setChar(int Pos, char Char) { // Set the char at the given position to the given char
        if (Pos <= StringLength) { // If the given position is less than the length of the String
            MyString[Pos - 1] = Char; // Set the char to the given value, accommodating for the Array starting at 0
        }
    }

    public void ammendChar(char Char) { // Add a char to the end of the String
        StringLength++; // Add one to the total length
        char[] CharArray = new char[StringLength]; // Create a new, temporary array to store the chars in with the new length
        int i = 0; // Set the counter to 0
        for (char c:MyString) { // For each char in the current array
            CharArray[i] = MyString[i]; // Store in the new array
            i++; // Add one to the count each iteration
        }
        CharArray[StringLength - 1] = Char; // Add the new char to the end
        MyString = CharArray; // Store the temporary array as the current one
    }

    public void appendChar(char Char) { // Add a char to the beginning of the array
        StringLength++; // Add one to the total length of the array
        char[] CharArray = new char[StringLength]; // Create a new, temporary array to store the chars in with the new length
        int i = 1; // Set the counter to one
        CharArray[0] = Char; // Store the char at the beginning of the array
        for (char c:MyString) { // For each char in the current array
            CharArray[i] = MyString[i - 1]; // Store in the new array, one further on
            i++; // Add one to the count each iteration
        }
        MyString = CharArray; // Store the temporary array as the current one
    }

    @Override
    public String toString() { // Overwrite the .toString method
        return new String(MyString); // Return the stored char array as a newly created String
    }
}
