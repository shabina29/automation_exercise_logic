package com.jatincode.interview;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {

		String input = "Java";

		// Step 1: Convert String to Character Array
		char[] inputArray = input.toCharArray();

		// Step 2: Use LinkedHashSet to preserve order
		Set<Character> charSet = new LinkedHashSet<Character>();// “Character is not a variable, it is a wrapper class
																// used as a generic type in collections, because Java
																// collections do not support primitive data types like
																// char.”

		// Step 3: Add characters to Set (duplicates automatically removed)
		for (char data : inputArray) {
			charSet.add(data);
		}

		// Step 4: Use StringBuilder to build result
		StringBuilder result = new StringBuilder();

		for (char c : charSet) {
			result.append(c);
		}

		// Step 5: Print result
		System.out.println(result.toString());
	}
}

/*
 * “Question is to remove duplicate characters from a string.
 * 
 * Suppose I have a string input which stores the value Java. Now the expected
 * output should be Jav, because we need to remove duplicate characters but also
 * preserve the order.
 * 
 * Now before directly jumping to solution like HashSet or TreeSet, we need to
 * carefully observe that order should be maintained.
 * 
 * So first, what I will do is convert the string into a character array using
 * the inbuilt method toCharArray(), so that I can process each character
 * individually.
 * 
 * Now since we want to remove duplicates, we need a data structure that stores
 * only unique elements, and that is Set.
 * 
 * But if I use HashSet or TreeSet, the order of characters will not be
 * preserved.
 * 
 * So to maintain insertion order, I will use LinkedHashSet.
 * 
 * Now I will iterate over the character array using a loop and add each
 * character into the LinkedHashSet. Since Set does not allow duplicates,
 * duplicate characters will automatically be ignored.
 * 
 * After that, I will create a StringBuilder object, because it is mutable and
 * memory efficient.
 * 
 * Now I will iterate over the LinkedHashSet and append each character into the
 * StringBuilder.
 * 
 * Finally, I will convert the result into string and print it.
 * 
 * So for input Java, the output will be Jav.
 * 
 * And that’s how we remove duplicate characters from a string while preserving
 * the order.”
 * 
 * 🔥 Interview Tip (Very Important)
 * 
 * 👉 Always बोलो:
 * 
 * “HashSet not used because order not preserved” “LinkedHashSet preserves
 * insertion order”
 * 
 * 
 * ===========================================================================
 * 🔹 Line समझो Set<Character> charSet = new LinkedHashSet<Character>(); 🔹 1.
 * <Character> क्यों use किया?
 * 
 * 👉 Java में Collections primitive types (char, int) store नहीं करते
 * 
 * 👉 इसलिए:
 * 
 * char ❌ allowed नहीं Character ✅ (wrapper class)
 * 
 * 💡 मतलब:
 * 
 * Character → object form of char
 * 
 * 👉 Interview line: “Collections only work with objects, so we use wrapper
 * class Character instead of primitive char.”
 * 
 * 🔹 2. Set<Character> क्यों?
 * 
 * 👉 क्योंकि हमें चाहिए:
 * 
 * ❌ duplicates नहीं ✅ unique characters
 * 
 * 👉 Set का property:
 * 
 * Automatically duplicate remove करता है
 * 
 * 💡 इसलिए:
 * 
 * List ❌ (duplicates allow) Set ✅ (duplicates नहीं) 🔹 3. LinkedHashSet ही
 * क्यों?
 * 
 * 👉 3 options होते हैं:
 * 
 * Type Duplicate Order HashSet ❌ ❌ (random) TreeSet ❌ ❌ (sorted) LinkedHashSet
 * ❌ ✅ (insertion order)
 * 
 * 👉 Question में requirement: ✔ duplicates remove ✔ order same रहना चाहिए
 * 
 * 👉 इसलिए:
 * 
 * LinkedHashSet ✅ 🔹 4. पूरा logic एक line में 💡
 * 
 * 👉 “We use LinkedHashSet<Character> because it stores unique characters and
 * preserves insertion order.”
 * 
 * 🔹 5. Left vs Right Side समझो Set<Character> charSet = new
 * LinkedHashSet<Character>();
 * 
 * 👉 Left side:
 * 
 * Set → interface (flexibility)
 * 
 * 👉 Right side:
 * 
 * LinkedHashSet → actual implementation
 * 
 * 💡 Interview gold line: “We use interface reference (Set) and implementation
 * (LinkedHashSet) for better flexibility.”
 * 
 * 🔥 Final Interview Answer 🎤
 * 
 * “We use Character because collections do not support primitive types. We use
 * Set to remove duplicates, and LinkedHashSet specifically to preserve
 * insertion order. Also, we use Set as a reference type and LinkedHashSet as
 * implementation for flexibility.”
 */

//=================================================================================
/*
 * 🧠 Top Tricky Interview Q&A (Set) ❓ Q1: HashSet और LinkedHashSet में
 * difference?
 * 
 * 👉 🎤 Answer: “HashSet does not maintain any order, whereas LinkedHashSet
 * maintains insertion order. Both do not allow duplicates, but LinkedHashSet
 * internally uses a linked list to preserve order.”
 * 
 * ❓ Q2: TreeSet कब use करते हैं?
 * 
 * 👉 🎤 Answer: “TreeSet is used when we need sorted data. It stores elements
 * in natural sorting order like ascending order.”
 * 
 * ❓ Q3: Remove duplicates + order preserve → कौन use करोगे?
 * 
 * 👉 🎤 Answer: “I will use LinkedHashSet because it removes duplicates and
 * maintains insertion order.”
 * 
 * ❓ Q4: HashSet fast क्यों होता है?
 * 
 * 👉 🎤 Answer: “HashSet uses hashing mechanism, so operations like add,
 * remove, search are O(1) on average.”
 * 
 * ❓ Q5: TreeSet slow क्यों है?
 * 
 * 👉 🎤 Answer: “TreeSet internally uses a balanced tree (Red-Black Tree), so
 * operations take O(log n) time.”
 * 
 * ❓ Q6: क्या Set duplicate allow करता है?
 * 
 * 👉 🎤 Answer: “No, Set does not allow duplicate elements.”
 * 
 * ❓ Q7: क्या Set indexing support करता है?
 * 
 * 👉 🎤 Answer: “No, Set does not support indexing because it is not ordered
 * like List.”
 * 
 * ❓ Q8: क्या null values allowed हैं?
 * 
 * 👉 🎤 Answer:
 * 
 * HashSet → 1 null allowed LinkedHashSet → 1 null allowed TreeSet → null ❌
 * (exception) ❓ Q9: क्या हम Set में primitive type डाल सकते हैं?
 * 
 * 👉 🎤 Answer: “No, collections do not support primitive types, so we use
 * wrapper classes like Integer, Character.”
 * 
 * ❓ Q10: LinkedHashSet internally कैसे काम करता है?
 * 
 * 👉 🎤 Answer: “It uses a combination of HashMap and a doubly linked list to
 * maintain insertion order.”
 * 
 * 🔥 Quick Revision Trick (1 Line)
 * 
 * 👉 HashSet → fast, no order 👉 LinkedHashSet → order maintain 👉 TreeSet →
 * sorted
 * 
 * 🎯 Your Interview Edge 💯
 * 
 * अगर तुम ये बोल पाओ:
 * 
 * logic clear use-case clear difference clear
 * 
 * 👉 तुम 90% candidates से ahead हो
 */