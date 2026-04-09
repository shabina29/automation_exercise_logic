package com.live.interview.questions;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
	
	public static void main(String[] args) {

	    String input = "programming";
	    // Input string → we need to find the first non-repeating character

	    Map<Character, Integer> map = new HashMap<>();
	    // Create a HashMap
	    // Key   → Character
	    // Value → Frequency (how many times character appears)


	    // ================= STEP 1: COUNT FREQUENCY =================
	    for (char ch : input.toCharArray()) {
	        // Convert string → character array
	        // Loop runs for each character one by one

	        map.put(ch, map.getOrDefault(ch, 0) + 1);
	        // map.getOrDefault(ch, 0)
	        // → If character exists → return its count
	        // → If not → return 0

	        // +1 → increase count

	        // map.put(ch, newCount)
	        // → store/update character count in map
	    }


	    // ================= STEP 2: FIND FIRST NON-REPEATING =================
	    for (char ch : input.toCharArray()) {
	        // Traverse the string again (IMPORTANT)
	        // This helps maintain original order of characters

	        if (map.get(ch) == 1) {
	            // Check if frequency of character is 1
	            // If yes → it means character appears only once

	            System.out.println("First non-repeating character: " + ch);
	            // Print first non-repeating character

	            break;
	            // Stop loop after finding first non-repeating character
	        }
	    }}}
	
	


	/*
	🧠 Simple Understanding

	Step 1:
	👉 Count frequency

	p → 1  
	r → 2  
	o → 1  
	g → 2  
	a → 1  
	m → 2  
	i → 1  
	n → 1  

	Step 2:
	👉 Traverse again
	👉 First char with count = 1 → ✅ answer


	🎯 Output

	First non-repeating character: p


	🎤 Interview Answer (Say This)

	“I use a HashMap to store frequency of each character. Then I iterate through the string again 
	and return the first character whose frequency is 1. This ensures O(n) time complexity.”


	🔥 Why 2 loops?

	👉 First loop → count frequency  
	👉 Second loop → maintain order (IMPORTANT)

	Reason:
	👉 HashMap does NOT maintain insertion order
	👉 So we iterate string again


	⚠️ Important Point

	👉 Map does NOT maintain order  
	👉 That’s why we loop string again


	🚀 Pro Tip (Impress Interviewer)

	“This approach avoids nested loops and gives O(n) time complexity.”


	🧠 One-Line Answer

	“I use a HashMap for frequency and a second pass to find the first character with count 1.”
	*/

