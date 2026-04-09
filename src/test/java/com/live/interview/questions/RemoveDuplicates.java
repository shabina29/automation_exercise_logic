package com.live.interview.questions;

import java.util.LinkedHashSet;

public class RemoveDuplicates {
	 public static void main(String[] args) {

	        int[] arr = {1, 2, 2, 3, 4, 4, 5};
	        // Step 1: Create an array with duplicate values

	        LinkedHashSet<Integer> set = new LinkedHashSet<>();
	        // Step 2: Create LinkedHashSet
	        // Why LinkedHashSet?
	        // ✔ It does NOT allow duplicates
	        // ✔ It keeps order same as input

	        for (int num : arr) {
	            // Step 3: Loop through array
	            // num will take values one by one:
	            // 1 → 2 → 2 → 3 → 4 → 4 → 5

	            set.add(num);
	            // Step 4: Add each number to set

	            // IMPORTANT:
	            // If number is NEW → it gets added
	            // If number is DUPLICATE → it is ignored automatically
	        }

	        // Step 5: Print result
	        System.out.println(set);
	        // Output will be: [1, 2, 3, 4, 5]
	    }

}

/*
🔍 What is LinkedHashSet (VERY IMPORTANT)

👉 Think like this:

🟢 Array:
[1, 2, 2, 3]

🟢 LinkedHashSet:
[1, 2, 3]

👉 It automatically removes duplicates


🔄 Step-by-Step Execution (IMPORTANT)

Step   num   Set Before       Set After
1      1     []               [1]
2      2     [1]              [1,2]
3      2     [1,2]            [1,2] (ignored)
4      3     [1,2]            [1,2,3]
5      4     [1,2,3]          [1,2,3,4]
6      4     [1,2,3,4]        (ignored)
7      5     [1,2,3,4]        [1,2,3,4,5]


🧠 VERY IMPORTANT LINE

set.add(num);

👉 This line does all the magic:

✔ If element is new → add  
✔ If already exists → ignore  


🎯 Why not Array?

👉 Array allows duplicates ❌  
👉 Set removes duplicates ✅  


🎤 Interview Explanation (Simple Version)

“I use a LinkedHashSet because it automatically removes duplicate elements 
and maintains the insertion order. I iterate through the array and add elements 
to the set, which filters duplicates.”


🚀 Simple Analogy (Remember this 🔥)

👉 Think Set like a gatekeeper

✔ New person → allowed ✅  
❌ Same person again → not allowed  


⚠️ Important Note

👉 Output is:
[1, 2, 3, 4, 5]

👉 This is a Set, not array


💡 If interviewer asks “convert back to array?”

int[] result = set.stream().mapToInt(Integer::intValue).toArray();


🧠 One-Line Summary

👉 “Set removes duplicates automatically.”
*/

//==================================================================================
/*
🎯 Line:
for (int num : arr)


🧠 Simple Answer

👉 num kahi se aaya nahi hai  
👉 Ye loop ke andar automatically create hota hai  


🔍 Breakdown

int[] arr = {1, 2, 2, 3, 4, 4, 5};

👉 arr = array of numbers  

for (int num : arr)

👉 Meaning:

“Array arr ke har element ko ek-ek karke num me daalo”  


🔄 Internally kya ho raha hai?

Equivalent normal loop:

for (int i = 0; i < arr.length; i++) {
    int num = arr[i];
}

👉 Same kaam kar raha hai ✅  


🧠 Step-by-Step

Iteration    num value  
1            1  
2            2  
3            2  
4            3  
5            4  
6            4  
7            5  


🎯 Important Point

👉 num = temporary variable  

✔ Har iteration me new value aati hai  
✔ Automatically assign hoti hai  


🔥 Easy Example

for (int num : arr) {
    System.out.println(num);
}

👉 Output:

1  
2  
2  
3  
4  
4  
5  


🎤 Interview Answer

“This is an enhanced for loop where ‘num’ is a temporary variable that stores each element 
of the array one by one during iteration.”  


🧠 One-Line

👉 “num is just a variable that holds each value of array during loop execution.”  


⚠️ Common Confusion

❌ num array ka part nahi hai  
✅ num sirf loop variable hai  
*/