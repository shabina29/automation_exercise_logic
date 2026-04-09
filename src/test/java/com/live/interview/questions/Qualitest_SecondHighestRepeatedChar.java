package com.live.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Qualitest_SecondHighestRepeatedChar {
	
	public static void main(String[]args)
	{
		 // Entry point of Java program (execution starts here)

        String input = "ShAbIna AutomAtioN Testing ToOl";  
        // Step 1: Declare and initialize input string

        input = input.toLowerCase().replaceAll(" ", "");  
        // Step 2: Normalize the string
        // toLowerCase() → converts all characters to lowercase (for uniform comparison)
        // replaceAll(" ", "") → removes all spaces
        // Final string becomes: "shabinaautomationtestingtool"

        Map<Character, Integer> map = new HashMap<>();  
        // Step 3: Create a HashMap
        // Key → Character
        // Value → Frequency (count of each character)

        // Count frequency
        for (char ch : input.toCharArray()) {  
            // Step 4: Convert string to char array and iterate each character

            map.put(ch, map.getOrDefault(ch, 0) + 1);  
            // Step 5: Count frequency of each character
            // map.getOrDefault(ch, 0) → get current count of character
            // If character not present → return 0
            // +1 → increment count
            // map.put(ch, count) → update map with new count

            // Example:
            // 'a' → first time → 0 + 1 = 1
            // 'a' → second time → 1 + 1 = 2
        }

        // Sort by frequency
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());  
        // Step 6: Convert map into a list of entries
        // Each entry = (character, frequency)
        // This is needed because Map cannot be sorted directly

        list.sort((a, b) -> b.getValue() - a.getValue());  
        // Step 7: Sort list based on frequency (descending order)
        // b.getValue() - a.getValue() → higher frequency comes first
        // Example:
        // [('t',5), ('a',4), ('o',3), ...]

        // Second highest
        Map.Entry<Character, Integer> second = list.get(1);  
        // Step 8: Get second element from sorted list
        // index 0 → highest frequency
        // index 1 → second highest frequency

        System.out.println("Second highest repeated character: " + second.getKey());  
        // Step 9: Print the character

        System.out.println("Count: " + second.getValue());  
        // Step 10: Print its frequency
	}

}


/*🔥 Step 0: Full Goal of Program

👉 You are given:

"ShAbIna AutomAtioN Testing ToOl"

👉 You need to:

Ignore case & spaces
Count frequency of each character
Find second highest repeated character
🔹 Step 1: Normalize the String
input = input.toLowerCase().replaceAll(" ", "");
🔍 What happens internally:
1️⃣ toLowerCase()
ShAbIna → shabina
AutomAtioN → automation

👉 Now string becomes:

"shabina automation testing tool"
2️⃣ replaceAll(" ", "")

👉 Removes all spaces

Final string:

"shabinaautomationtestingtool"
🔹 Step 2: Create HashMap
Map<Character, Integer> map = new HashMap<>();

👉 Think of this like a frequency table

Character	Count
a	?
t	?
🔹 Step 3: Loop Through Characters
for (char ch : input.toCharArray())
🔍 Internally:
input.toCharArray()

becomes:

[s, h, a, b, i, n, a, a, u, t, o, m, a, t, i, o, n, t, e, s, t, i, n, g, t, o, o, l]

👉 Loop runs one character at a time

🔹 Step 4: Core Logic (MOST IMPORTANT)
map.put(ch, map.getOrDefault(ch, 0) + 1);

Let’s break it deeply 👇

🧠 What is getOrDefault()?

👉 It means:

“If key exists → return value
If not → return default value (0)”

🔄 Iteration Example
👉 1st character: 's'
map.getOrDefault('s', 0) → 0
0 + 1 = 1
map.put('s', 1)

Map:

{s=1}
👉 Next 'h'
{ s=1, h=1 }
👉 Next 'a'
{ s=1, h=1, a=1 }
👉 Next 'a' again
map.getOrDefault('a', 0) → 1
1 + 1 = 2

Map:

{ s=1, h=1, a=2 }
👉 Final Map (approx)
a = 4
t = 5
o = 4
i = 3
n = 3
s = 2
h = 1
...
🔹 Step 5: Convert Map → List
List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

👉 Why?

❌ Map cannot be sorted directly
✅ List can be sorted

🔍 What is entrySet()?

👉 Converts map into:

[a=4, t=5, o=4, i=3, n=3, s=2 ...]

Each item = Map.Entry

🔹 Step 6: Sorting Logic (VERY IMPORTANT)
list.sort((a, b) -> b.getValue() - a.getValue());
🧠 What is happening?

👉 This is a lambda comparator

(a, b) → compare two entries
🔍 Logic:
b.getValue() - a.getValue()

👉 Means:

If b > a → positive → b comes first
So descending order
🧾 After Sorting:
[t=5, a=4, o=4, i=3, n=3, s=2 ...]
🔹 Step 7: Get Second Highest
Map.Entry<Character, Integer> second = list.get(1);

👉 Index:

Index	Meaning
0	Highest
1	Second highest ✅

👉 Example:

t = 5 (highest)
a = 4 (second highest)
🔹 Step 8: Print Result
second.getKey()   → character
second.getValue() → frequency
✅ Output Example
Second highest repeated character: a
Count: 4
⚠️ VERY IMPORTANT EDGE CASE

👉 If multiple characters have same frequency:

a = 4
o = 4

👉 Your code picks:

list.get(1) → whichever comes second after sorting
🎯 FINAL INTERVIEW EXPLANATION (ADVANCED)

“I normalize the string by converting it to lowercase and removing spaces. 
Then I use a HashMap to count the frequency of each character using getOrDefault.
 After that, I convert the map into a list of entries and sort it in descending order using a lambda comparator. 
Finally, I retrieve the second element from the sorted list to get the second highest occurring character.”*/