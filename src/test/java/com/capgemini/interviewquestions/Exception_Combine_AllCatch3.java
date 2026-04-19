package com.capgemini.interviewquestions;

public class Exception_Combine_AllCatch3 {

	public static void main(String[] args) {

		int a;
		int numbers[] = { 1, 3, 4, 5, 8 };

		try {
			a = 10 / 2;

			System.out.println("Accessing element: " + numbers[10]);
			System.out.println("Value of a: " + a);

		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) // using | OR sign we can add multiple
																			// exception here
		{
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
/*
 * 🎯 Interview Answer (Very Important 🔥)
 * 
 * If interviewer asks:
 * 
 * 👉 What is ArrayIndexOutOfBoundsException?
 * 
 * You can say:
 * 
 * 👉 “ArrayIndexOutOfBoundsException occurs when we try to access an index that
 * is outside the valid range of the array. For example, if array size is 5,
 * valid indexes are 0 to 4, and accessing index 10 will throw this exception.”
 * 
 * 💡 Pro Tip (SDET Level)
 * 
 * In real automation:
 * 
 * This exception can happen when: Reading test data from arrays Handling API
 * response arrays Iterating UI elements list
 * 
 * 👉 Always use:
 * 
 * for (int i = 0; i < array.length; i++)
 */
