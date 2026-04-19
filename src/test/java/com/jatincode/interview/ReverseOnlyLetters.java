package com.jatincode.interview;

import java.util.*;
public class ReverseOnlyLetters {

	public static void main(String[] args) {

		String input = "1AB2";
		// Input string jisme letters reverse karne hain, numbers/special same rahenge

		char[] inputArray = input.toCharArray();
		// String ko character array me convert kiya for easy manipulation

		int left = 0;
		// Left pointer start se (0 index)

		int right = inputArray.length - 1;
		// Right pointer end se (last index)

		while (left < right) {
			// Loop tab tak chalega jab tak left < right hai

			if (!Character.isLetter(inputArray[left])) {
				// Agar left side pe letter nahi hai (number/special hai)

				left++;
				// To usko ignore karo aur left pointer aage badhao

			} else if (!Character.isLetter(inputArray[right])) {
				// Agar right side pe letter nahi hai

				right--;
				// To usko ignore karo aur right pointer peeche lao

			} else {
				// Jab dono side pe letters mil gaye

				char temp = inputArray[left];
				// Temporary variable me left character store karo

				inputArray[left] = inputArray[right];
				// Right wala character left position pe daal do

				inputArray[right] = temp;
				// Temp (old left) ko right position pe daal do

				left++;
				// Swap ke baad left ko aage badhao

				right--;
				// Swap ke baad right ko peeche lao
			}
		}

		System.out.println(new String(inputArray));
		// Final character array ko string me convert karke print karo
	}
}

/*
 * 📝 Reverse Only Letters – Notes 🔹 Problem Statement
 * 
 * Given a string, reverse only the letters (alphabets) Numbers and special
 * characters should remain at their same position.
 * 
 * 👉 Example:
 * 
 * Input: 1AB2 Output: 1BA2
 * 
 * 💡 Explanation:
 * 
 * A ↔ B (letters reversed) 1 and 2 same position पर रहते हैं 🔹 Approach (2
 * Pointer Technique 🔥)
 * 
 * 👉 जब भी question में “reverse” आता है → 2 pointer technique use करो
 * 
 * 👉 Two Pointers: left → start से (index 0) right → end से (length - 1) 🔹
 * Step 1: Convert String to Character Array char[] inputArray =
 * input.toCharArray();
 * 
 * 👉 Example:
 * 
 * input = "1AB2" inputArray = [1, A, B, 2] 🔹 Step 2: Initialize Pointers int
 * left = 0; int right = inputArray.length - 1;
 * 
 * 👉 Example:
 * 
 * left = 0 (1) right = 3 (2) 🔹 Step 3: Loop Condition while (left < right)
 * 
 * 👉 Loop तब तक चलेगा जब तक:
 * 
 * left < right 🔹 Step 4: Conditions (Core Logic 🔥) ✅ Case 1: Left NOT a
 * letter if (!Character.isLetter(inputArray[left])) { left++; }
 * 
 * 👉 Example:
 * 
 * inputArray[0] = '1' → number ❌ 👉 ignore → left++ ✅ Case 2: Right NOT a
 * letter else if (!Character.isLetter(inputArray[right])) { right--; }
 * 
 * 👉 Example:
 * 
 * inputArray[3] = '2' → number ❌ 👉 ignore → right-- ✅ Case 3: Both are letters
 * → Swap else { char temp = inputArray[left]; inputArray[left] =
 * inputArray[right]; inputArray[right] = temp;
 * 
 * left++; right--; }
 * 
 * 👉 Example:
 * 
 * A ↔ B swap 🔹 Final Output [1, B, A, 2] → 1BA2
 */