🎯 1. Based on Data Type
✅ 1. Primitive Variables

👉 Direct value store karte hain

Examples:

int a = 10;
double price = 99.5;
char grade = 'A';
boolean isValid = true;

👉 Types:

int
double
char
boolean
float
long
short
byte

✔ Fast
✔ Less memory

✅ 2. Non-Primitive Variables (Reference Types)

👉 Object ka reference (address) store karte hain

Examples:

String name = "Shabina";
int[] arr = {1, 2, 3};
AppiumDriver driver;

✔ Can be null
✔ Used for complex data

🎯 2. Based on Scope (VERY IMPORTANT 🔥)
✅ 1. Local Variable
public void test() {
    int x = 10; // local variable
}

👉 Method ke andar declare hota hai
👉 Sirf method ke andar use hota hai

✅ 2. Instance Variable (Non-static)
class Test {
    int x = 10; // instance variable
}

👉 Object ke saath associated hota hai
👉 Har object ka alag value

✅ 3. Static Variable (Class Variable)
class Test {
    static int count = 0;
}

👉 Class ke saath associated
👉 Sab objects me same value share hoti hai

🧠 Summary Table
Type	Example	Scope
Primitive	int a = 10	Value store
Non-Primitive	String s	Reference store
Local	int x (inside method)	Method only
Instance	int x (in class)	Object specific
Static	static int x	Shared
🎤 Interview Answer (Perfect)

“In Java, variables are mainly classified into primitive and non-primitive types based on data type, and into local, instance, and static variables based on scope. Primitive variables store actual values, while non-primitive variables store references. Local variables are declared inside methods, instance variables belong to objects, and static variables are shared across all instances.”

🧠 One-Line Answer

👉 “Variables in Java are primitive/non-primitive and local/instance/static.”