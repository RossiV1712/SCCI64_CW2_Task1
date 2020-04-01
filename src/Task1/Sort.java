package Task1;

import java.lang.Integer;

public class Sort {
    Integer[] StoredNum; // Create the instance variable array to store the list of Integers

    public Sort(Integer[] InputArray) { // The constructor to create the Sort object
        StoredNum = InputArray; // Store the given array as the instance variable
    }

    public int getLength() { // Return the length of the instance variable StoredNum
        Integer Count = 0; // Set the initial value for the counter to 0
        for (Integer i:StoredNum) { // For each Integer in StoredNum
            Count++; // Add 1 to the counter
        }
        return Count; // Return the total count
    }

    public void bubbleSort() { // A function to use the bubble sort algorithm
        boolean F = true; // Set flag to true initially
        while (F == true) { // While the flag is true
            F = false; // Set the flag to false
            for (int i = 0; i < getLength() - 1; i++) { // For each value in the array apart from the last (accommodating for starting from 0 with the "- 1")
                if (StoredNum[i] > StoredNum[i + 1]) { // if the selected number is larger than the one to the right
                    Integer temp = StoredNum[i]; // Store the selected number in a temp variable
                    StoredNum[i] = StoredNum[i + 1]; // Move the other int to the initial position (one to the right)
                    StoredNum[i + 1] = temp; // Store the temp variable in the new position in the array
                    F = true; // There has been a swap, so set the flag to true
                }
            }
        }
    }

    public void quickSort() {
        Integer temp = 0; // Create and set the temp variable to 0 initially
        for (int i = 0; i < getLength() - 1; i++){ // For each between 0 and 1 less than the length of the array.
            if (StoredNum[i] > StoredNum[i + 1]) { // If the selected number is larger than that on the right
                int j = i - 1; // Set j to check the next on the left
                temp = StoredNum[i + 1]; // Store the smaller (on the right) number in a temporary variable
                StoredNum[i + 1] = StoredNum[i]; // Set the larger number to one position to the right (in the place of the smaller number)
                while (j >= 0 && StoredNum[j] > temp) { // While J is 0 or larger and the checked number is larger than the stored one
                    StoredNum[j + 1] = StoredNum[j]; // Set the larger number to one position to the right (in the place of the smaller number)
                    j--; // Minus one from j to allow the loop to end and iterate through the required variables
                }
                StoredNum[j + 1] = temp; // Set the value from the temporary variable to its new position
            }
        }
    }

    @Override
    public String toString() {
        String Output = ""; // Create the String to return
        int Count = 0; // Create the Count variable starting at 0
        for (Integer x:StoredNum) { // For each Integer in StoredNum
            Count++; // Add one to the Count on each iteration (so that the first is 1)
            Output += x; // Add the Integer to the end of the Output String
            if (Count < getLength()) { // As long as the current Count is not the last
                Output += ", "; // Add a comma and space onto the end of the Output String
            }
        }
        return Output; // Return the Output String
    }
}
