package com.jatincode.interview;

import java.util.*;

public class FindSecondLargestNumberInArray {

	public static void main(String[] args) {

		int a[] = { 1, 3, 2, 7, 5 };

		int largestNumber = Integer.MIN_VALUE;
		int secondLargestNumber = Integer.MIN_VALUE;

		for (int number : a) {

			if (number > largestNumber) {
				secondLargestNumber = largestNumber;
				largestNumber = number;
			} else if (number > secondLargestNumber && number != largestNumber) {
				secondLargestNumber = number;
			}
		}

		System.out.println("Second Largest Number " + secondLargestNumber);
	}
}

/*
 * 📝 Second Largest Number in Array – Notes 🔹 Problem Statement
 * 
 * Find the second largest number in an array
 * 
 * 👉 Example:
 * 
 * Input: [1, 3, 2, 7, 5] Output: 5 🔹 Brute Force Approach (Not Optimized ❌) 👉
 * Logic: Array को sort करो Last element = largest Second last element = second
 * largest 👉 Example: Sorted: [1, 2, 3, 5, 7] Second Largest = 5 ❌ Problem:
 * Sorting expensive operation है Time Complexity = O(n log n) Large data के लिए
 * inefficient 🔹 Optimized Approach (One Pass ✅)
 * 
 * 👉 हम array को सिर्फ एक बार traverse करेंगे (One Pass)
 * 
 * 🔹 Step 1: Variables Create करो int largest = Integer.MIN_VALUE; int
 * secondLargest = Integer.MIN_VALUE; 💡 क्यों? Negative values भी handle हों
 * इसलिए 0 नहीं use किया 🔹 Step 2: Traverse Array for (int number : arr)
 * 
 * 👉 हर element को number variable में लेंगे
 * 
 * 🔹 Step 3: Logic Build करो ✅ Case 1: नया largest मिला if (number > largest) {
 * secondLargest = largest; largest = number; }
 * 
 * 👉 क्या हो रहा है:
 * 
 * पुराना largest → secondLargest नया number → largest ✅ Case 2: second largest
 * update else if (number > secondLargest && number != largest) { secondLargest
 * = number; }
 * 
 * 👉 क्या हो रहा है:
 * 
 * number, secondLargest से बड़ा है लेकिन largest नहीं है तो secondLargest
 * update 🔹 Example Dry Run
 * 
 * Array: [1, 3, 2, 7, 5]
 * 
 * Step Number Largest Second Largest 1 1 1 MIN 2 3 3 1 3 2 3 2 4 7 7 3 5 5 7 5
 */
