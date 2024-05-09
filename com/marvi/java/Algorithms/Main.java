package com.marvi.java.Algorithms;

public class Main {
    public static void main(String[] args) {
        // The array of numbers 
        int array[] = {9, 1, 8, 2, 7, 3, 6, 4, 5};

        bubbleSort(array);

        // Prints out each element in the array 
        for(int i : array){
            System.out.print(i);
                
        }
    }

    public static void bubbleSort(int array[]){
        // Iterates through the array
        for(int i = 0; i < array.length-1; i++){
            // Goes through the unsorted array
            for(int j = 0; j < array.length - i - 1; j++){
                // IF array[j] is greater than this array[j+ 1] switch them around
                if(array[j] > array[j+ 1]){
                    // A temporary place to put it while everything is being sorted
                    int temp = array[j];
                    // Moves the larger elements to the right 
                    array[j] = array[j + 1];
                    // Moves the lower numbers down to the 
                    array[j + 1] = temp;
                }
            }
        }
    }
}
