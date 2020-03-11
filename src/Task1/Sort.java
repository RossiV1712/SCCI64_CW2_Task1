package Task1;

import java.util.Arrays;

public class Sort {
    int[] StoredNum;

    public Sort(int[] InputArray) {
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
        int total = StoredNum.length;
        int temp = 0;

        for (int i = 0; i < total - 1; i++){
                if (StoredNum[i] > StoredNum[i + 1]) {
                    int j = i - 1;

                    temp = StoredNum[i + 1];
                    StoredNum[i + 1] = StoredNum[i];
//                    System.out.println(temp);
//                    System.out.println(StoredNum[0] + "," + StoredNum[1] + "," + StoredNum[2] + "," + StoredNum[3] + "," + StoredNum[4] + "," + StoredNum[5] + "," + StoredNum[6]);

                    while (j >= 0 && StoredNum[j] > temp) {
//                        System.out.println(j);
                        StoredNum[j + 1] = StoredNum[j];
//                        System.out.println(temp);
//                        System.out.println(StoredNum[0] + "," + StoredNum[1] + "," + StoredNum[2] + "," + StoredNum[3] + "," + StoredNum[4] + "," + StoredNum[5] + "," + StoredNum[6]);
                        j--;
                    }
                    StoredNum[j + 1] = temp;
                    System.out.println("End of Pass: " + StoredNum[0] + "," + StoredNum[1] + "," + StoredNum[2] + "," + StoredNum[3] + "," + StoredNum[4] + "," + StoredNum[5] + "," + StoredNum[6]);
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
