package com.practice.loops;

public class SumUsingLoop {

	public static void main(String[] args) {
		int sum = 0;
		// variable to store total sum

		for (int i = 1; i <= 15; i++)

		{
			sum = sum + i;
		}
		System.out.println(sum);
	}

}

/*
 * 🧠 Why we write int sum = 0; ?
 * 
 * 👉 Simple language me:
 * 
 * 👉 Sum ko store karne ke liye ek dabba (container) chahiye
 * 
 * int sum = 0;
 * 
 * ✔ sum = variable (dabba) ✔ 0 = starting value
 * 
 * 🧠 Real Life Example
 * 
 * Socho:
 * 
 * 👉 Tum paise add kar rahe ho
 * 
 * Day 1: +10 Day 2: +20 Day 3: +30
 * 
 * 👉 Total kaha store hoga? 👉 Ek jagah chahiye na? → That is sum
 * 
 * 🔥 Code Flow Samjho int sum = 0; // starting value
 * 
 * for(int i = 1; i <= 5; i++) {
 * 
 * sum = sum + i; } 🧠 Step by Step (VERY IMPORTANT) i sum = sum + i new sum 1 0
 * + 1 1 2 1 + 2 3 3 3 + 3 6 4 6 + 4 10 5 10 + 5 15
 * 
 * 👉 Final sum = 15
 * 
 * ❌ Agar sum = 0 nahi likhenge toh? int sum; // ❌ not initialized
 * 
 * 👉 Error aayega:
 * 
 * variable might not have been initialized
 * 
 * 👉 Java bolta hai: "Mujhe starting value batao!"
 * 
 * 🎯 Golden Rule (Yaad rakhna)
 * 
 * 👉 Accumulation ke liye always initial value zaroori hai
 * 
 * Operation Initial Value Sum (+) 0 Multiplication (*) 1 🧠 Interview Answer
 * 
 * 👉 Agar pucha: “Why initialize sum with 0?”
 * 
 * Answer:
 * 
 * “Because 0 is the neutral value for addition, and it allows us to correctly
 * accumulate values inside the loop.”
 * 
 * 🚀 Next Level Question
 * 
 * 👉 Try this:
 * 
 * 🔥 Factorial of 5
 * 
 * 👉 Hint:
 * 
 * int fact = 1; fact = fact * i;
 */