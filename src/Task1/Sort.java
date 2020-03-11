package Task1;

import java.util.Arrays;

public class Sort {
    int[] StoredNum;

    public Sort(int[] InputArray) { // The constructor to create the Sort object
        StoredNum = InputArray;
    }

    public void bubbleSort() { // A function to use the bubble sort algorithm
        boolean F = true; // Set flag to true initially
        while (F == true) { // While the flag is true
            F = false; // Set the flag to false
            for (int i = 0; i < 6; i++) { // For each value in the array apart from the last
                if (StoredNum[i] > StoredNum[i + 1]) { // if the selected number is larger than the one to the right
                    int temp = StoredNum[i]; // Store the selected number in a temp variable
                    StoredNum[i] = StoredNum[i + 1]; // Move the other int to the initial position (one to the right)
                    StoredNum[i + 1] = temp; // Store the temp variable in the new position in the array
                    F = true; // There has been a swap, so set the flag to true
                }
            }
        }
    }

    public void quickSort() {
        int total = StoredNum.length; // Store the length of the array
        int temp = 0; // Create and set the temp variable to 0 initially

        for (int i = 0; i < total - 1; i++){ // For each between 0 and 1 less than the length of the array.
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
        String Output = "";

        for (int x:StoredNum) {
            Output += x + ", ";
        }

        return Output;
    }
}
