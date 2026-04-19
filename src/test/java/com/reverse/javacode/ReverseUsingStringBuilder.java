package com.reverse.javacode;
// Package declaration → organizes class in project

public class ReverseUsingStringBuilder {

	public static void main(String[] args) {
		// Main method → execution starts from here

		String input = " AUtomation";
		// Input string to be reversed
		// Note: There is a space at the beginning (important for output)

		String rev = new StringBuilder(input).reverse().toString();
		// Step-by-step breakdown:

		// new StringBuilder(input)
		// → Create StringBuilder object from input string
		// → StringBuilder is mutable (can be modified easily)

		// .reverse()
		// → Built-in method of StringBuilder
		// → Reverses the characters of the string internally

		// .toString()
		// → Converts StringBuilder object back to String
		// → Because reverse() returns StringBuilder, not String

		// Final result stored in variable "rev"

		System.out.println(rev);
		// Print reversed string
	}
}

/*
 * 🎯 Interview Explanation (Best Answer)
 * 
 * “I use StringBuilder’s reverse() method to reverse a string efficiently.
 * Since StringBuilder is mutable, it performs better than manual approaches.
 * After reversing, I convert it back to String using toString().”
 * =============================================================
 * 🔥 Why StringBuilder?

✔ Faster than String
✔ Built-in reverse() method
✔ No manual loop needed
 */