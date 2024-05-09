package com.marvi.java.Algorithms;

public class Merge {
    public static void main(String[] args) {
        int array[] = {3, 7, 8, 5, 4, 2, 6, 1};

        // Splits the array in half and creates two sub arrays 
        mergeSort(array);

        //Prints out the unsorted array
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        if(length <= 1)
            return;

        // Finds and splits the index down at the middle 
        int middle = length /2;
        // Make sub array for the left and right side
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];

        int i = 0; // Index for the left side of the array

        int j = 0; // Index for the right  side of the array 

        // For loop that goes over and split each part of the element form the middle 
        for(; i < length; i++){
            // If the index is less than the middle, put it to the left side
            if(i < middle){
                leftArray[i] = array[i];
            }else{
                // If the index is less than the middle, put it to the right side
                rightArray[j] = array[i];
                j++;
            }
        }

        // Recursively sorts the left and right side
        mergeSort(leftArray);
        mergeSort(rightArray);
        // Merges the sorted left and right sub array
        merges(leftArray, rightArray, array);
    }

    private static void merges(int[] leftArray, int[] rightArray, int[] array){

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; // Variables to keep track of positions in arrays

        // Merges the left and right sub arrays while comparing the elements
        while(l < leftSize && r < rightSize){
            // Comparing the elements from the left and the right sub array and merges them.
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        // Copy the remaining elements from the left sub array into the main array
        while(l < leftSize){
            // Copy the element from the left sub array to the main array
            array[i] = leftArray[l];
            // Moves to the next position in the main array
            i++;
            l++;
        }

        // Copy the remaining elements from the right sub array into the main array
        while(r < rightSize){
             // Copy the element from the left sub array to the main array
            array[i] = rightArray[r];
             // Move to the next position in the main array
            i++;
            // Move to the next element in the right sub array
            r++;
        }
    }
}
