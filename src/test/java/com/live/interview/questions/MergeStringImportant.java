package com.live.interview.questions;

public class MergeStringImportant {  
    // Define a class named MergeStrings

    public static void main(String[] args) {  
        // Main method → program execution starts here

        String input1 = "abc";  
        // First input string

        String input2 = "pqr";  
        // Second input string

        StringBuilder result = new StringBuilder();  
        // Create StringBuilder to store final result
        // StringBuilder is used because it is faster than String (mutable)

        int maxLength = Math.max(input1.length(), input2.length());  
        // Find maximum length between both strings
        // This ensures loop runs enough times even if lengths are unequal

        for (int i = 0; i < maxLength; i++) {  
            // Loop from index 0 to maxLength - 1
            // Each iteration picks characters from both strings

            if (i < input1.length()) {  
                // Check: is index valid for input1?
                // Prevents IndexOutOfBoundsException

                result.append(input1.charAt(i));  
                // Take character from input1 at position i
                // Append it to result
            }

            if (i < input2.length()) {  
                // Check: is index valid for input2?

                result.append(input2.charAt(i));  
                // Take character from input2 at position i
                // Append it to result
            }
        }

        System.out.println(result.toString());  
        // Convert StringBuilder to String and print final result
    }
}

/*🧠 Step-by-Step Execution
🔹 Input
input1 = "abc"
input2 = "pqr"
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
🔹 maxLength
maxLength = 3
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
🔹 Loop Execution
i	input1[i]	input2[i]	result
0	a	p	ap
1	b	q	apbq
2	c	r	apbqcr
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
🔹 Final Output
apbqcr
⚠️ Very Important Logic (Interview Focus)
👉 Why we use this condition:
if (i < input1.length())
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

👉 To avoid error:

IndexOutOfBoundsException
🔥 Example (Unequal Length)
input1 = "abcd"
input2 = "pq"

👉 Without if → program crashes ❌
👉 With if → safe execution ✅
🎯 Interview Explanation (Best Answer)

::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

“In this program, I use a StringBuilder to efficiently build the result string. 
I calculate the maximum length of both input strings to ensure full traversal.
 Then, I iterate through the strings and append characters alternately,
  using boundary checks to handle unequal lengths and avoid index errors.”
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

🚀 Key Concepts You Used

✔ StringBuilder (performance optimization)
✔ Math.max()
✔ charAt()
✔ Looping logic
✔ Boundary checking

🔥 Pro Tip (Say This in Interview)

“Using StringBuilder improves performance because String concatenation creates new objects every time.”*/