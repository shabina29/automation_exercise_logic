package com.capgemini.interviewquestions;

public class Exception_With_Finally {

	public static void main(String[] args) {
		int a;
		int number[] = { 1, 2, 4, 5, 6 };

		try {
			a = 10 / 2;
			System.out.println(a);
			System.out.println(number[10]);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e)// The exceptions should not be related to each
																		// other .it should be always different
		// catch (ArithmeticException | ArrayIndexOutOfBoundException e) //check Bounds
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			// close all open resources

			System.out.println("print anyway");
		}
	}

}
