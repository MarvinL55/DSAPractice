package com.marvi.java.Algorithms;

public class SelectionSort {
    public static void main(String[] args) {
        // The array that holds the elements
       int array[] = {8, 7, 9, 2, 3, 1, 5, 4, 6}; 

       // Calling the method
       Selection(array);

       // For each loop that prints put each 
       for(int i : array){
            System.out.print(i);
       }
    }

    public static void Selection(int[] array){
        // Goes through the array once
        for(int i = 0; i < array.length - 1; i++){
            // the current minimum
            int min = i;
            // Goes through the unsorted array
            for(int j = i + 1; j < array.length; j++){
                // Checks if the minimum number is less than the j the current number the array is on
                if(array[min] > array[j]){
                    // Makes it equal to the j if j is less than the minimum 
                    min = j;
                }
            }
            // Temporary variable to store the value of the current element being swapped
            int temp = array[i];
            // Assigns the value of the minimum element to the current element being swapped
            array[i] = array[min];
            // Assigns the stored value from the temporary variable to the minimum element
            array[min] = temp;
        }
    }
}
