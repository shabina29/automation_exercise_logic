package com.string.learn;

public class ProgramString1 {
	public static void main(String[] args)
	{
		
		String input="Shabina";
//		String reversed="";
		
	StringBuilder sb=new StringBuilder(input);
	String reversed=sb.reverse().toString();
	System.out.println("original:  "  +input);
	System.out.println("reverse:  "  +reversed);
	
	
	
	}

}
