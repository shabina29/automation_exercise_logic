package com.reverse.javacode;

public class ReverseAStringUsingTwoPointerApproach {
	
	public static void main(String[]args)
	{
		String input="Hello";
		
	//Since the string is immutable .So to modify it we need it to first convert it to character array
		
		char[]x=input.toCharArray();
		
		int left=0;
		int right =x.length-1;
		
		while(left<right)
		
		{
			char temp=x[left];
			x[left]=x[right];
			x[right]=temp;
			left++;
			right--;
		}
		
		System.out.println(new String(x));
	}

}
