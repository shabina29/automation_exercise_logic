package com.capgemini.interviewquestions;
// Package declaration – organizes classes into folders

public class ExceptionPractice1 {
// Class definition

	public static void main(String[] args) {
		// Main method – entry point of the program

		try {
			// Try block – code that may throw an exception

			int a = 10 / 0;
			// This will cause ArithmeticException (division by zero)

			System.out.println(a);
			// This line will NOT execute because exception occurs above

		} catch (ArithmeticException e) {
			// Catch block – handles ArithmeticException

			System.out.println(e.getMessage());
			// Prints exception message (e.g., "/ by zero")

			e.printStackTrace();
			// Prints full exception details (error + line number)

		}
	}
}
/*
 * 🔹 What Happens Internally 💡 10 / 0 → Exception thrown Control immediately
 * goes to catch block System.out.println(a) is skipped ❌ Catch block prints:
 * Message → / by zero Stack trace → detailed error 🎤 Interview Explanation
 * (Short)
 * 
 * “This program demonstrates exception handling using try-catch. When division
 * by zero occurs, an ArithmeticException is thrown and handled in the catch
 * block, preventing program crash.”
 */

//=======================================================================
/*
 * 🔹 What is e? catch(ArithmeticException e)
 * 
 * 👉 यहाँ:
 * 
 * ArithmeticException → exception type e → exception object (reference
 * variable) 🔹 Simple Language 💡
 * 
 * 👉 e = वो object जिसमें error की पूरी जानकारी stored होती है
 * 
 * 🔹 जब exception आता है तब क्या होता है? int a = 10 / 0;
 * 
 * 👉 JVM internally:
 * 
 * एक ArithmeticException object बनाता है उसमें error details store करता है और
 * उसे e में डाल देता है 🔹 e से क्या कर सकते हैं? 1. Error message निकाल सकते
 * हैं e.getMessage();
 * 
 * 👉 Output:
 * 
 * / by zero 2. Full error details (stack trace) e.printStackTrace();
 * 
 * 👉 Output:
 * 
 * Exception name Line number Method call details 🔹 क्या e का नाम change कर
 * सकते हैं?
 * 
 * 👉 Yes ✅
 * 
 * catch(ArithmeticException ex) catch(ArithmeticException error)
 * 
 * 👉 Name कुछ भी हो सकता है, but e commonly use होता है
 * 
 * 🔥 Interview Answer 🎤
 * 
 * “e is a reference variable that holds the exception object. It contains
 * details about the error like message, stack trace, and cause.”
 */