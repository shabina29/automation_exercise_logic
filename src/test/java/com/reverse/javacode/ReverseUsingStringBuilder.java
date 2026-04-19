package com.reverse.javacode;

public class ReverseUsingStringBuilder {
	public static void main(String[]args) {
	
	String input =" AUtomation";
	
	String rev=new StringBuilder(input).reverse().toString();
	
	System.out.println(rev);

}
}