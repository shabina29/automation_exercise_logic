package com.javacode.practice;

public class Swapping_BestApproach {
	
	public static void main(String[]args)
	{

        int a = 10;   // Here I have two variables 'a' and 'b' with values 10 and 20
        int b = 20;

        // To swap them, I am using a temporary variable so that I don’t lose the original value

        int temp = a; // First, I store the value of 'a' into a temporary variable called 'temp'

        a = b;        // Then, I assign the value of 'b' to 'a', so now 'a' becomes 20

        b = temp;     // After that, I assign the value stored in 'temp' (which is original 'a') to 'b', so 'b' becomes 10

        // Finally, I print the swapped values of 'a' and 'b'

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Note:
        // This approach uses an extra variable 'temp', so it is easy to understand and safe,
        // but it uses additional memory.

        // Optimized Note (for interview discussion):
        // If we swap without using a temporary variable, it becomes more memory efficient
        // because we are not creating any extra variable or object,
        // so it avoids additional memory allocation and works in constant space.
    }

}
