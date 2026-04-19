package com.capgemini.interviewquestions;

public class Exception6 {
	//can a Try be without catch: yes
	//every try will have only and only one finally block 
	//Question : how many finally can we have in a class ?
	
	public static void main(String[]args)
	{
		int a;
		try {
			a=10/2;
		}
		finally
		{
			System.out.println("I am going to print the result with finally block without using the catch");
		}
		
		
	}

}
