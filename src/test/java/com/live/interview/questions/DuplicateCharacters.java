package com.live.interview.questions;
import java.util.HashSet;
// Import HashSet class
// HashSet is a collection that stores unique elements (no duplicates allowed)

import java.util.Set;
// Import Set interface
// Set defines behavior like add(), remove(), contains()

class DuplicateCharacters {
    public static void main(String[] args) {
        
        String input = "programming";
        // Input string in which we want to find duplicate characters
        
        Set<Character> set = new HashSet<>();
        // Create a Set to store unique characters
        // This will help us track characters we have already seen
        
        Set<Character> duplicates = new HashSet<>();
        // Create another Set to store duplicate characters
        // Set is used so duplicates are stored only once (no repetition)

        for (char ch : input.toCharArray()) {
            // Convert string into character array
            // Loop will run for each character one by one
            
            if (!set.add(ch)) {
                // set.add(ch) → tries to add character to set
                
                // If character is NEW:
                // add() returns true → !true = false → if block NOT executed
                
                // If character is DUPLICATE:
                // add() returns false → !false = true → if block executed
                
                // So this condition means:
                // "If character is already present → it is duplicate"
                
                duplicates.add(ch);
                // Add duplicate character into duplicates set
                // Set ensures no repeated duplicates (e.g., 'm' only once)
            }
        }

        for (char ch : duplicates) {
            // Loop through all duplicate characters
            
            System.out.print(ch + " ");
            // Print each duplicate character
        }
    }
}