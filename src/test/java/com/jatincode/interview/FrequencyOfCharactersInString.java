package com.jatincode.interview;

import java.util.HashMap;

public class FrequencyOfCharactersInString {

	public static void main(String[] args) {

		String input = "madam";
		HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();

		// How to convert a String to a char array
		char inputArray[] = input.toCharArray();

		// traverse this char array??
		for (char character : inputArray) {
			frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
		}

		for (char c : frequencyMap.keySet()) { // yaad rkhna keySet k alawa interview me aur kya puchhta h

			System.out.println(c + " " + frequencyMap.get(c));
			/*
			 * 🔹 Important समझो 💡
			 * 
			 * 👉 character और c:
			 * 
			 * दोनों same type (char) हैं दोनों temporary variables हैं नाम कुछ भी रख सकते
			 * हो
			 * 
			 * ✔ ये भी सही है:
			 * 
			 * for (char x : inputArray) for (char y : frequencyMap.keySet()) 🔹 Interview
			 * Answer (short बोलने वाला 🎤)
			 * 
			 * “In for-each loop, char character and char c are temporary variables which
			 * hold each element during iteration. First loop iterates over character array,
			 * and second loop iterates over HashMap keys.”
			 */
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
 * करता है) Second loop → Result print करता है
 */

//======================================================================================
/*
 * 🎤 Voice Script (Clean & Correct)
 * 
 * “to count the frequency of each character in a string, right? So first, I’m
 * going to create a class, let’s say FrequencyOfCharactersInString, and inside
 * the main method, I’ll start writing the logic.
 * 
 * Now the first thing I’ll do is create an input string. So I’ll write String
 * input = "madam";
 * 
 * Now, since I need to store the frequency of each character, I’ll use a
 * HashMap. Here, the key will be of type Character and the value will be
 * Integer, which represents the count. So I’ll create a HashMap<Character,
 * Integer> and name it as frequencyMap.
 * 
 * Next, I need to process each character of the string. So I’ll convert the
 * string into a character array using input.toCharArray().
 * 
 * Now I’ll traverse this character array using a for-each loop. So for each
 * character in the array, I’ll update its count in the HashMap.
 * 
 * To do that, I’ll use getOrDefault() method. If the character is not present
 * in the map, it will return 0, otherwise it will return the existing count.
 * Then I’ll add 1 to it and store it back in the map.
 * 
 * So the logic becomes: frequencyMap.put(character,
 * frequencyMap.getOrDefault(character, 0) + 1);
 * 
 * Now once all characters are processed, I’ll print the result. So I’ll iterate
 * over the keys of the HashMap using keySet() and print each character along
 * with its frequency.
 * 
 * Finally, the output for input ‘madam’ will be: m → 2, a → 2, d → 1.
 * 
 * And that’s how we calculate the frequency of characters in a string using
 * HashMap.”
 * 
 * 
 * =============================================================================
 * = 🔹 Interview Answer (short बोलने वाला 🎤)
 * 
 * “In for-each loop, char character and char c are temporary variables which
 * hold each element during iteration. First loop iterates over character array,
 * and second loop iterates over HashMap keys.”
 */