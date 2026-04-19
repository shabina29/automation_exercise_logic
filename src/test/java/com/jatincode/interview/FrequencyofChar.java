package com.jatincode.interview;

import java.util.HashMap;

public class FrequencyofChar {

	public static void main(String[] args) {

		String input = "madam";
		// Declare input string

		HashMap<Character, Integer> frequencyMap = new HashMap<>();
		// Create HashMap to store character as key and count as value

		char[] inputArray = input.toCharArray();
		// Convert string to char array for easy iteration

		for (char character : inputArray) {
			// Update frequency of each character
			frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
		}

		for (char c : frequencyMap.keySet()) {
			// Print each character and its frequency
			System.out.println(c + " " + frequencyMap.get(c));
		}
	}
}

/*
 * 🔹 First Loop (Important समझो) for (char character : inputArray)
 * 
 * 👉 यहाँ क्या हो रहा है:
 * 
 * inputArray = पूरा character array (जैसे: m, a, d, a, m) character = हर बार
 * एक-एक character पकड़ता है
 * 
 * 👉 Loop का काम:
 * 
 * ✔ हर character उठाना ✔ HashMap में उसका count update करना
 * 
 * 👉 Example flow:
 * 
 * 'm' → map में नहीं है → add → 1 'a' → add → 1 'd' → add → 1 'a' → already है
 * → update → 2 'm' → already है → update → 2
 * 
 * 💡 Conclusion: 👉 First loop = data build/update करता है (HashMap fill करता
 * है)
 * 
 * 🔹 Second Loop for (char c : frequencyMap.keySet())
 * 
 * 👉 यहाँ क्या हो रहा है:
 * 
 * frequencyMap.keySet() = सारे unique characters (m, a, d) c = हर key
 * (character) एक-एक करके आएगा
 * 
 * 👉 Loop का काम:
 * 
 * ✔ हर character लेना ✔ उसका final count print करना
 * 
 * 👉 Example:
 * 
 * c = 'm' → print → 2 c = 'a' → print → 2 c = 'd' → print → 1
 * 
 * 💡 Conclusion: 👉 Second loop = sirf read + print करता है (कोई update नहीं)
 * 
 * 🔥 Final Clear Difference (याद रखने वाला) First loop → Map बनाता है (update
 * करता है) Second loop → Result print करता है 🎤 Interview Perfect Answer (तुम
 * ऐसे बोलना)
 * 
 * “In the first loop, I iterate over the character array and update the
 * frequency of each character in the HashMap. In the second loop, I iterate
 * over the keys of the HashMap and print each character along with its
 * frequency.”
 */