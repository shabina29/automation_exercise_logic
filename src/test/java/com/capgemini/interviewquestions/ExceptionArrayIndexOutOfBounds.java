package com.capgemini.interviewquestions;

public class ExceptionArrayIndexOutOfBounds {

	public static void main(String[] args) {

		int a = 0;
		int numbers[] = { 1, 3, 4, 5, 8 }; // declare the variable outside the try -catch block and utilize it inside
											// the block

		try {
			a = 10 / 2;
			System.out.println("Value of a: " + a);
			System.out.println("Accessing element: " + numbers[10]);
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Exception: " + e.getMessage());
		} finally {
			System.out.println("Execution completed");
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
 */