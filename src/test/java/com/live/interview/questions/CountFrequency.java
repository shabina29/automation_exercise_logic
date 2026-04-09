package com.live.interview.questions;

import java.util.HashMap;
import java.util.Map;

public class CountFrequency {
	public static void main(String[] args) {

        String input = "programming";
        // Input string → we want to count frequency of each character

        Map<Character, Integer> map = new HashMap<>();
        // Create a HashMap:
        // Key   → Character (like 'p', 'r')
        // Value → Count (how many times it appears)

        for (char ch : input.toCharArray()) {
            // Convert string into char array
            // Loop runs for each character one by one

            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // Step-by-step breakdown:

            // map.getOrDefault(ch, 0)
            // → If character exists → return its current count
            // → If not → return 0 (default value)

            // +1 → increment count

            // map.put(ch, newCount)
            // → Update map with new count

            // Example:
            // First 'r':
            // map.getOrDefault('r', 0) → 0
            // 0 + 1 = 1 → store ('r',1)

            // Second 'r':
            // map.getOrDefault('r', 0) → 1
            // 1 + 1 = 2 → update ('r',2)
        }

        // Print result
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            // entrySet() → converts map into set of key-value pairs
            // Each entry contains:
            // entry.getKey()   → character
            // entry.getValue() → count

            System.out.println(entry.getKey() + " → " + entry.getValue());
            // Print character and its frequency
        }
    }

}

/*
🧠 Internal Working (Step-by-Step)

Input:
programming

🔄 Iteration Flow
Step  Character  getOrDefault  New Count  Map
1     p          0             1          {p=1}
2     r          0             1          {p=1, r=1}
3     o          0             1          {p=1, r=1, o=1}
4     g          0             1          {p=1, r=1, o=1, g=1}
5     r          1             2          {p=1, r=2, o=1, g=1}
6     a          0             1          {p=1, r=2, o=1, g=1, a=1}
7     m          0             1          {p=1, r=2, o=1, g=1, a=1, m=1}
8     m          1             2          {p=1, r=2, o=1, g=1, a=1, m=2}
9     i          0             1          {p=1, r=2, o=1, g=1, a=1, m=2, i=1}
10    n          0             1          {p=1, r=2, o=1, g=1, a=1, m=2, i=1, n=1}
11    g          1             2          {p=1, r=2, o=1, g=2, a=1, m=2, i=1, n=1}


🔍 Important Concepts

1️⃣ getOrDefault()

👉 Very important for interview

map.getOrDefault(ch, 0)

Means:
✔ If key exists → return value
✔ If not → return default (0)


2️⃣ Why use Map?

👉 Because:
✔ We need key → value mapping
✔ Character → count


3️⃣ Why not Set?

👉 Set only stores unique values
👉 Cannot store count ❌


4️⃣ entrySet()

map.entrySet()

👉 Converts map into:
[p=1, r=2, o=1, ...]


🎯 Interview Explanation (Perfect Answer)

“I use a HashMap where the character is the key and its frequency is the value. 
I iterate through the string and update the count using getOrDefault, which simplifies 
handling of new and existing characters. Finally, I iterate over the entrySet to print 
each character and its count.”


🚀 Time Complexity

👉 O(n)
👉 Because we traverse string once


🔥 Pro Tip (Impress Interviewer)

“Using getOrDefault avoids extra if-else checks and keeps the code clean.”


⚠️ Common Mistake

❌ Writing:

if(map.containsKey(ch)) { ... }

👉 Works, but longer ❌  
👉 getOrDefault() is cleaner ✅
*/
