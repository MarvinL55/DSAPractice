package com.marvi.java.Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    // Finds the larges number by concatenating given integers
    public static String largeNumber(int[] nums){
        // Converting integers to string
        String[] numsStr = new String[nums.length];
        for(int i= 0; i < nums.length; i++){
            numsStr[i] = String.valueOf(nums[i]);
        }

        //Sorts the strings in descending order based on the custom comparator
        Arrays.sort(numsStr, new Comparator<String>() {
            public int compare(String a, String b){
                String order1 = a + b; // Concatenate Strings to form two orders
                String order2 = b + a;
                return order2.compareTo(order1); // Sort in descending order
            }
        });

        // Concatenate the sorted strings
        StringBuilder result = new StringBuilder();
        for(String num : numsStr){
            result.append(num);
        }

        // Handle case where result start with zero
        if(result.charAt(0) == '0'){
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args){
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println("Largest number " + largeNumber(nums) );
    }
}
