package Task1;

public class Tester {

    public Tester() {
        System.out.println("----------------CustString Class----------------"); // The output for all CustString class testing
        System.out.println("----Long String----"); // The output for testing a string created with more than the limit of characters
        CustString LongString = new CustString(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}); // Create the instance with 52 characters
        System.out.println("Created!"); // Declare success in creation
        System.out.println("String: " + LongString.toString()); // Output the CustString using the toString overwrite function
        System.out.println("Length: " + LongString.returnLength()); // Output the length of the CustString using the custom returnLength function
        System.out.println("Letter 'q' at: " + LongString.getPosition('q')); // Get and output the position of a character that is in the CustString
        System.out.println("Symbol '!' at: " + LongString.getPosition('!')); // Get and output the position of a character that is not in the CustString
        System.out.println("Add '!' at positions 0, 5, 50, 55"); // Declare what will be added and the positions
        LongString.addChar(0, '!'); // Add '!' to the CustString at position 0 (Should not succeed)
        LongString.addChar(5, '!'); // Add '!' to the CustString at position 5 (Should succeed)
        LongString.addChar(50, '!'); // Add '!' to the CustString at position 50 (Should succeed)
        LongString.addChar(55, '!'); // Add '!' to the CustString at position 55 (Should not succeed)
        System.out.println(LongString.toString()); // Output the final result using the toString overwrite function

        System.out.println("----Short String----");
        CustString ShortString = new CustString(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'}); // Create the instance with 7 characters
        System.out.println("Created!"); // Declare success in creation
        System.out.println("String: " + ShortString.toString()); // Output the CustString using the toString overwrite function
        System.out.println("Length: " + ShortString.returnLength()); // Output the length of the CustString using the custom returnLength function
        System.out.println("Letter 'b' at: " + ShortString.getPosition('b')); // Get and output the position of a character that is in the CustString
        System.out.println("Letter 'h' at: " + ShortString.getPosition('h')); // Get and output the position of a character that is not in the CustString
        System.out.println("Add '!' at positions 0, 5, 7, 10"); // Declare what will be added and the positions
        ShortString.addChar(0, '!'); // Add '!' to the CustString at position 0 (Should not succeed)
        ShortString.addChar(5, '!'); // Add '!' to the CustString at position 5 (Should succeed)
        ShortString.addChar(7, '!'); // Add '!' to the CustString at position 7 (Should succeed)
        ShortString.addChar(10, '!'); // Add '!' to the CustString at position 10 (Should not succeed)
        System.out.println(ShortString.toString()); // Output the final result using the toString overwrite function

        System.out.println("----Limit String----");
        CustString LimitString = new CustString(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x'}); // Create the instance with 50 characters
        System.out.println("Created!"); // Declare success in creation
        System.out.println("String: " + LimitString.toString()); // Output the CustString using the toString overwrite function
        System.out.println("Length: " + LimitString.returnLength()); // Output the length of the CustString using the custom returnLength function
        // Since the Long String is cut down to the same size, it will give the same results from now on and would be indistinguishable from this instance, therefore no further testing needed

        System.out.println("----------------Sort Class----------------");
        System.out.println("----Bubble Default----");
        Sort BubbleSortTest = new Sort(new Integer[]{33, 14, 6, 21, 1, 18, 14}); // Create an instance of Sort for testing the bubbleSort method with some simple numbers
        System.out.println("Bubble Initial: " + BubbleSortTest.toString()); // Output the initial value using the overwritten toString
        BubbleSortTest.bubbleSort(); // Sort using the bubbleSort method
        System.out.println("Bubble Sorted: " + BubbleSortTest.toString()); // Output the value using the overwritten toString after it is sorted using bubbleSort()
        System.out.println("----Bubble Different----");
        Sort CompBubbleSortTest = new Sort(new Integer[]{1, -2, 3000, 0, 5, -6, 700}); // Create an instance of Sort for testing the bubbleSort method with negative numbers, 0 and much larger numbers
        System.out.println("Bubble Initial: " + CompBubbleSortTest.toString()); // Output the initial value using the overwritten toString
        CompBubbleSortTest.bubbleSort(); // Sort using the bubbleSort method
        System.out.println("Bubble Sorted: " + CompBubbleSortTest.toString()); // Output the value using the overwritten toString after it is sorted using bubbleSort()
        System.out.println("----Quick Default----");
        Sort QuickSortTest = new Sort(new Integer[]{33, 14, 6, 21, 1, 18, 14}); // Create an instance of Sort for testing the quickSort method with some simple numbers
        System.out.println("Quick Initial: " + QuickSortTest.toString()); // Output the initial value using the overwritten toString
        QuickSortTest.quickSort(); // Sort using the quickSort method
        System.out.println("Quick Sorted: " + QuickSortTest.toString()); // Output the value using the overwritten toString after it is sorted using quickSort()
        System.out.println("----Quick Different----");
        Sort CompQuickSortTest = new Sort(new Integer[]{1, -2, 3000, 0, 5, -6, 700}); // Create an instance of Sort for testing the quickSort method with negative numbers, 0 and much larger numbers
        System.out.println("Quick Initial: " + CompQuickSortTest.toString()); // Output the initial value using the overwritten toString
        CompQuickSortTest.quickSort(); // Sort using the quickSort method
        System.out.println("Quick Sorted: " + CompQuickSortTest.toString()); // Output the value using the overwritten toString after it is sorted using quickSort()
    }

}
