package com.practice.loops;

//Question print upto 5

public class ForLoopBasic {
	
	public static void main(String[] args)
	{
		//int i =5; //"Same variable ko same scope me 2 baar declare nahi kar sakte"
		
		for(int i=0;i<=5;i++) { // yahan phir sirf i mention krna hoga "int i" nhi
		
		System.out.println(" These are the numbers: "+ i);
		}
	}

}

/*❓ Tumhara doubt

👉 Tumne bola:

"maine int i = 5; likha aur phir for loop me bhi i use kiya — mistake kya hai?"

🔍 Case 1: Tumhara Current Code (Correct ✅)
for(int i = 0; i <= 5; i++) {
    System.out.println(i);
}

✔ Ye bilkul correct hai
✔ i sirf loop ke andar exist karta hai (local scope)

❌ Case 2: Agar tumne ye likha hota
int i = 5;

for(int i = 0; i <= 5; i++) { // ❌ ERROR
    System.out.println(i);
}

👉 ❌ ERROR aayega:

Duplicate local variable i
🧠 WHY ERROR?

👉 Java bolta hai:

Tumne pehle hi i declare kar diya
Phir dobara same scope me i declare kar rahe ho

👉 Ye allowed nahi hai

✅ Correct Way (Agar bahar declare karna hai)
int i = 0; // declare outside

for(i = 0; i <= 5; i++) { // no "int" here
    System.out.println(i);
}

✔ Yaha tum variable reuse kar rahe ho
✔ Dubara declare nahi kar rahe

🔥 Best Practice (Interview Level)

👉 Always prefer this:

for(int i = 0; i <= 5; i++) {
    System.out.println(i);
}

✔ Clean
✔ Scope limited
✔ Memory efficient
✔ Interview me preferred

🧠 Simple Rule (Yaad rakhna)

👉 "Same variable ko same scope me 2 baar declare nahi kar sakte"

🎯 Interview Line (Bolna)

👉 “I usually declare loop variables inside the loop to limit their scope and avoid conflicts.”*/