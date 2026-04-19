package com.practice.loops;

public class PrintFiveToOneWithSpace {
	
//Here i called the main class
	
	public static void main(String[] args)//I defined the main method inside the class
	{
		for(int i=5;i>=1;i--) //for loop where i starts at 5 and run upto 1 > wrong
			
			//Correct : // loop runs from 5 to 1 in reverse order
		{
		
		System.out.print( i + " "); //Print current value of i each iteration
		}
	}

}
