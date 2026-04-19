package com.live.interview.questions;

public class Largest_Smallest_Number_Array {
	 public static void main(String[] args) {

	        int[] arr = {5, 2, 9, 1, 7};
	        // Array → collection of elements stored in contiguous memory
	        // Index-based access: arr[0]=5, arr[1]=2...

	        int largest = arr[0];
	        // Initially assume first element is the largest
	        // Why?
	        // Because we need a starting reference for comparison

	        int secondLargest = arr[0];
	        // Initially assume second largest is also first element
	        // It will be updated later during traversal


	        // ================= STEP 1: FIND LARGEST =================
	        for (int i = 1; i < arr.length; i++) {
	            // Loop starts from index 1
	            // Because index 0 already used for initialization

	            // 🔍 Compare current element with largest
	            if (arr[i] > largest) {
	                // If current element is bigger than current largest

	                largest = arr[i];
	                // Update largest
	                // Now largest always holds the maximum value seen so far
	            }
	        }


	        // 👉 After Step 1:
	        // largest = 9


	        // ================= STEP 2: FIND SECOND LARGEST =================
	        for (int i = 0; i < arr.length; i++) {

	            // 🔍 Condition breakdown:
	            if (arr[i] > secondLargest && arr[i] != largest) {

	                // Part 1: arr[i] > secondLargest
	                // → Find a bigger value than current secondLargest

	                // Part 2: arr[i] != largest
	                // → Skip the largest value
	                // → Prevent picking 9 again

	                secondLargest = arr[i];
	                // Update secondLargest
	                // Now it stores the next highest value after largest
	            }
	        }


	        // 👉 After Step 2:
	        // secondLargest = 7


	        System.out.println("Second Largest = " + secondLargest);
	        // Final output
	    }

}

/*
🧠 Deep Internal Flow (Step-by-Step)

🔹 Input:
[5, 2, 9, 1, 7]


🔹 Step 1: Find Largest

i    Element    largest
0    5          5
1    2          5
2    9          9  ✅
3    1          9
4    7          9

👉 Final:
largest = 9


🔹 Step 2: Find Second Largest

i    Element    secondLargest    Condition
0    5          5               skip (equal)
1    2          5               skip
2    9          skip            (largest ❌)
3    1          skip
4    7          7  ✅            update

👉 Final:
secondLargest = 7


🔥 Why We Need 2 Conditions?

arr[i] > secondLargest && arr[i] != largest

✔ Condition 1:
👉 arr[i] > secondLargest  
→ find bigger candidate  

✔ Condition 2:
👉 arr[i] != largest  
→ avoid picking largest again  


⚠️ Important Edge Case (VERY IMPORTANT)

👉 If array is:
[5, 5, 5]

👉 Output becomes wrong ❌

👉 Better approach:
int largest = Integer.MIN_VALUE;
int secondLargest = Integer.MIN_VALUE;


🚀 Better Approach (Single Loop – Interview Booster)

int largest = Integer.MIN_VALUE;
int secondLargest = Integer.MIN_VALUE;

for (int num : arr) {
    if (num > largest) {
        secondLargest = largest;
        largest = num;
    } else if (num > secondLargest && num != largest) {
        secondLargest = num;
    }
}

👉 Only one loop ✅  
👉 More efficient  


🎯 Deep Interview Explanation (BEST)

“First, I initialize largest and secondLargest variables. Then I iterate through the array 
to find the largest element. After identifying the largest, I run a second loop to find 
the next highest value while excluding the largest. I ensure correctness by using conditions 
to avoid selecting the same value again. This approach avoids sorting and works in O(n) time.”


🔥 Pro-Level Add

“This can be optimized further using a single-pass approach, reducing iterations.”


🧠 One-Line Answer

“I find the largest first and then find the next maximum excluding it.”
*/