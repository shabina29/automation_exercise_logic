package com.live.interview.questions;

public class FindWordPosition_HumanCloud {
	
	public static void main(String[]args)
	{
		String input="I have a Car";
		
		 // Step 1: Declare and initialize a string variable input with value="I have a Car"
        // This string contains the sentence in which we want to find the word "car"

        int index = input.indexOf("car");  
        // Step 2: Use indexOf() method to find the starting position of substring "car"
        // indexOf() searches for the first occurrence of "car" in the string
        // If found → returns starting index (position)
        // If not found → returns -1
        

        if (index != -1) {  
            // Step 3: Check if the word "car" exists in the string
            // If index is not -1, it means the word is found

            System.out.println("Position of 'car' is: " + index);  
            // Step 4: Print the position of "car"
            // Example: Output will be 9 (index starts from 0)

        } else {  
            // Step 5: This block executes if "car" is not found

            System.out.println("'car' not found");  
            // Print message indicating substring is not present
        }
	}

}

/*Super Simple Flow (How it works)
You store → "I have a car"
Java searches → "car"
Finds at → index 9
Prints → "Position of 'car' is: 9"
🎯 Interview Explanation (Best Version)

You can say this confidently:

“In this program, I first declare a string input. 
Then I use the indexOf() method to find the starting index of the substring ‘car’. 
If the method returns a value other than -1, it means the substring is present, so I print its position. 
Otherwise, I print that the substring is not found.”

⚠️ Important Interview Point

👉 Index starts from 0, not 1
👉 "I have a car" → c is at index 9*/

//===============Other Approach ============================
/*public class FindWordPositionSplit {
    public static void main(String[] args) {

        String input = "I have a car";

        String[] words = input.split(" ");  
        // Step 1: Split string into words using space
        // words = ["I", "have", "a", "car"]

        for (int i = 0; i < words.length; i++) {  
            // Step 2: Loop through each word

            if (words[i].equals("car")) {  
                // Step 3: Compare each word with "car"

                System.out.println("Position of 'car' is: " + i);  
                // Step 4: Print index (word position)
            }
        }
    }
}*/

//===================================Explanation================
/*🔹 The Line
int index = input.indexOf("car");
✅ What This Line Does

👉 It searches for the word "car" inside the string
👉 And returns the starting position (index) where it is found

🔍 Step-by-Step Working
🔸 Step 1: Your Input
String input = "I have a car";

Internally, Java sees it like this:

Index	Character
0	I
1	(space)
2	h
3	a
4	v
5	e
6	(space)
7	a
8	(space)
9	c
10	a
11	r
🔸 Step 2: Searching "car"

Java internally checks:

Compare from index 0 → ❌
Compare from index 1 → ❌
…
At index 9 → ✅ "car" matches (c, a, r)
🔸 Step 3: Return Value

👉 It returns 9
👉 That is the starting index of "car"

⚠️ Important Behavior
✔ If found
int index = input.indexOf("car");  // 9
❌ If NOT found
int index = input.indexOf("bike");  // -1

👉 -1 means not present

🧠 Internal Logic (How Java Does It)

Java internally works similar to this:

for (int i = 0; i <= input.length() - 3; i++) {
    if (input.substring(i, i + 3).equals("car")) {
        return i;
    }
}
return -1;

👉 It checks every possible position until it finds a match

🎯 Interview Explanation (Perfect Answer)

“The indexOf() method searches for a substring inside a string and returns the starting index of its first occurrence. 
If the substring is not found, it returns -1. Internally, it compares characters sequentially until it finds a match.”

🔥 Pro Tip (Impress Interviewer)

You can add:

“indexOf() is efficient because it is implemented at the JVM level and avoids writing manual loops.”*/