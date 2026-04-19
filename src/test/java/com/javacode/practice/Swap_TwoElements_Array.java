package com.javacode.practice;

public class Swap_TwoElements_Array {

	public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40}; // Here I have an array with multiple elements

        int i = 1; // Index of first element to swap (20)
        int j = 3; // Index of second element to swap (40)

        // To swap elements, I use a temporary variable to avoid losing data

        int temp = arr[i]; // Store value of arr[i] (20) into temp

        arr[i] = arr[j];   // Assign value of arr[j] (40) to arr[i]

        arr[j] = temp;     // Assign stored value (20) to arr[j]

        // Now elements at index 1 and 3 are swapped

        System.out.println("After swapping:"); 
     // Ye line sirf ek message print kar rahi hai screen par 
     // taaki user ko pata chale ki ab swapped array print hone wala hai

     for (int k = 0; k < arr.length; k++) { 
     // Ye ek loop hai jo array ke har element par chalega
     // k = 0 → starting index (array ka first element)
     // k < arr.length → jab tak last element tak nahi pahunchte
     // k++ → har baar index 1 se increase hoga (0,1,2,3...)

         System.out.print(arr[k] + " ");    
         // Ye current index ka element print kar raha hai
         // arr[k] → array ka value at index k
         // " " → space dene ke liye taaki output same line me clean lage
     }
    }
}
/*
 * “Here I have an array, and I want to swap two elements at specific indexes.”
 * 
 * “First, I store one element in a temporary variable temp to avoid losing its
 * value.”
 * 
 * “Then, I assign the second element to the first position.”
 * 
 * “Finally, I assign the stored value back to the second position.”
 * 
 * “This way, both elements are successfully swapped.”
 */