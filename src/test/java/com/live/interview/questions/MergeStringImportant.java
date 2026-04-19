package com.live.interview.questions;
// Package declaration → organizes class in proper folder structure

public class MergeStringImportant {  
    // Define a class named MergeStringImportant

    public static void main(String[] args) {
        // Entry point of Java program → execution starts from here

        String input1 = "abc";
        // First input string

        String input2 = "pqr";
        // Second input string
        
        StringBuilder result = new StringBuilder();
        // StringBuilder is used to store final result
        // Why StringBuilder?
        // ✔ String is immutable (slow for multiple concatenations)
        // ✔ StringBuilder is mutable (better performance)

        // Use a loop to pick characters from both strings
        for (int i = 0; i < input1.length() || i < input2.length(); i++) {
            // Loop runs until BOTH strings are fully traversed
            // Condition explanation:
            // i < input1.length() → checks first string
            // i < input2.length() → checks second string
            // || (OR) ensures loop continues even if one string ends earlier

            // Add char from first string if it exists
            if (i < input1.length()) {
                result.append(input1.charAt(i));
                // charAt(i) → gets character at index i
                // append() → adds character to result
            }

            // Add char from second string if it exists
            if (i < input2.length()) {
                result.append(input2.charAt(i));
                // Same logic for second string
            }
        }

        System.out.println("Final Output: " + result.toString());
        // Convert StringBuilder → String using toString()
        // Print final merged string
    }
}

/*
🧠 Step-by-Step Execution

🔹 Input
input1 = "abc"
input2 = "pqr"

🔹 Loop Execution
i    input1[i]    input2[i]    result
0    a            p            ap
1    b            q            apbq
2    c            r            apbqcr

🔹 Output
Final Output: apbqcr


⚠️ VERY IMPORTANT (Interview Point)

👉 Why use || (OR condition)?

i < input1.length() || i < input2.length()

👉 This ensures:
✔ Loop runs until both strings are fully processed
✔ Works even if strings have different lengths


🔥 Example (Unequal Length)

input1 = "abcd"
input2 = "pq"

👉 Output:
apbqcd

✔ Extra characters from longer string are still added


🎯 Interview Explanation (Perfect Answer)

“In this program, I merge two strings alternately by iterating through both strings using a loop. 
I use a StringBuilder for efficient string concatenation. The loop runs until both strings are 
fully traversed using an OR condition. Inside the loop, I check bounds for each string separately 
and append characters if they exist. This approach also handles unequal string lengths.”


🚀 Key Concepts Used

✔ StringBuilder (performance)
✔ charAt()
✔ Loop with OR condition
✔ Boundary checking
✔ Handling unequal length


🔥 Pro Tip (Say This to Impress)

“Time complexity is O(n), where n is the maximum length of the two strings.”
*/