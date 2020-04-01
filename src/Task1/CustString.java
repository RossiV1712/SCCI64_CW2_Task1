package Task1;

public class CustString {
    public char[] MyString = new char[50]; // Create the instance variable for the char Array set to the limit (will be shortened if needed line 14)
    private int Limit = 50; // Set the instance variable for the desired length limit of the Array

    public CustString(char[] InputString) { // Constructor
        if (getLength(InputString) > Limit) { // If the given array is longer than the limit
            for (int i = 0; i < Limit; i++) { // For each char until the limit
                this.MyString[i] = InputString[i]; // Store the given char into the same position in the instance variable char array
            }
        }
        else { // If the given array is not longer than the limit
            this.MyString = InputString; // Store the given char array as the instance variable
        }
    }

    public int returnLength() { // Return an int of the length of the instance variable MyString
        int StringLength = 0; // Set the initial counter to 0
        for (char c:MyString) { // For each character in the MyString array
            StringLength++; // Add 1 to StringLength for each iteration
        }
        return StringLength; // Return the total count
    }

    private int getLength(char[] InputString) { // Return an int of the length of the String
        int StringLength = 0; // Set the initial counter to 0
        for (char c:InputString) { // For each character in the given array run the statement
            StringLength++; // Add 1 to StringLength for each iteration
        }
        return StringLength; // Return the total count
    }

    public int getPosition(char Letter) { // Return the position of a char in the String
        for (int i = 0; i < returnLength(); i++) { // For each ranging from 0 to the array length (accommodates for all sizes)
            if (MyString[i] == Letter) { // If the stored char matches the input char
                return i + 1; // Return that int + 1 (to accommodate for arrays starting at 0)
            }
        }
        return 0; // if no results, return 0
    }

    public void addChar(int Pos, char Char) { // Set the char at the given position to the given char
        int Length = returnLength(); // Store the length of the instance variable MyString
        if (Pos <= Length && Pos > 0) { // If the given position is less than the length of the String
            if (Length < Limit){ // If the length is less than the limit
                Length++; // Add one on to accommodate the new char being added
            }
            char[] OutString = new char[Length]; // Create a new char array with the length stored above
            for (int i = 0; i < Length; i++) { // Run each time from 0 to one below the limit (the amount of times of the Length)
                if (i < Pos - 1) { // If the current iteration number (i) is less than 1 below the Pos given to the function (Before the position for the character to be input)
                    OutString[i] = MyString[i]; // Store the char at the current position in the MyString at the current position in the OutString
                }
                else if (i == Pos - 1) { // If the current iteration number (i) is the same as the Pos given to the function (The position for the character to be input)
                    OutString[i] = Char; // Store the given Char in the current position of the OutString
                }
                else { // Otherwise (If the current iteration number (i) is larger/after the Pos given to the function(After the position for the character to be input))
                    OutString[i] = MyString[i-1]; // Store the char at the previous position from MyString to the current position of OutString
                }
            }
            MyString = OutString; // Store OutString as MyString (Store new variable in the instance variable)
        }
    }

    @Override
    public String toString() { // Overwrite the .toString method
        return new String(MyString); // Return the stored char array as a newly created String
    }
}
