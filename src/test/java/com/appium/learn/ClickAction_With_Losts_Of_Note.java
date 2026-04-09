package com.appium.learn;
// Package where class is stored

import java.net.URL;
// Used to pass Appium server URL

import java.time.Duration;
// Used for wait

import org.openqa.selenium.By;
// Used to locate elements

import org.openqa.selenium.remote.DesiredCapabilities;
// Used to define device and app configuration

import io.appium.java_client.AppiumBy;
// Used for Appium-specific locators

import io.appium.java_client.AppiumDriver;
// Parent driver

import io.appium.java_client.android.AndroidDriver;
// Android driver

public class ClickAction_With_Losts_Of_Note {
    //NOte :static AppiumDriver driver> We declare the driver at the class level as a static variable so that it 
	//can be accessed across all static methods without creating an object
	
	/*✅ What is a Variable?

👉 Simple definition:

“A variable is a container used to store data in a program.”

🔍 In Your Code
static AppiumDriver driver;

👉 Here:

driver → variable name
AppiumDriver → data type
static → belongs to class
🧠 How to Explain in Interview
🎯 Best Answer

“A variable is a named memory location used to store data. 
In this case, driver is a variable of type AppiumDriver, 
which stores the reference of the AndroidDriver instance used to interact with the mobile application.”

🔥 Break It Down
AppiumDriver driver;

👉 Means:

I am creating a reference variable
It will store the driver object
⚠️ Important Concept

👉 This is NOT storing data like number/string
👉 It stores object reference

Example:

driver = new AndroidDriver(...);

👉 Now:

driver → points to actual driver object

>>>>>>>>>>>>>>>>>>🧾 Types of Variables (Quick)>>>>>>>
Type	Example
1.Primitive	int a = 10;
2.Non-Primitive	AppiumDriver driver;

👉 Your case = Non-primitive (Object variable)

🎯 One-Line Smart Answer

“A variable is a container to store data, and here driver is an object reference variable that holds the Appium driver instance.”*/
    static AppiumDriver driver;
    // Static driver so it can be used inside static methods
 // static → means this variable belongs to the class, not to any object
 // so it can be accessed directly using class name or inside static methods without creating object

 // static method → a method that belongs to the class, not object
 // example: main() and loginClick() are static methods

 // why needed here:
 // main() is static → it can only access static variables directly
 // loginClick() is also static → it needs driver to be static to use it

 // if driver was NOT static:
 // we would need to create object like:
 // ClickAction obj = new ClickAction();
 // obj.driver...

 // so using static avoids object creation and allows sharing same driver across methods

    public static void main(String[] args) throws Exception {

        // ================= CAPABILITIES =================
        DesiredCapabilities cap = new DesiredCapabilities();
        // Object to store capabilities

        cap.setCapability("platformName", "Android");
        // Platform (Android)

        cap.setCapability("deviceName", "emulator-5554");
        // Device name

        cap.setCapability("automationName", "UiAutomator2");
        // Automation engine

        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        // APK path

        cap.setCapability("autoGrantPermissions", true);
        // Auto allow permissions

        cap.setCapability("noReset", false);
        // Fresh install every time

        cap.setCapability("appWaitActivity", "*");
        // Handles splash screen / any activity

        // ================= DRIVER =================
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
        // Connect to Appium server and launch app
 
        // Create a new AndroidDriver instance
        // new URL("http://127.0.0.1:4723") → this is the Appium server address
        // 127.0.0.1 means "localhost" (your own machine)
        // 4723 is the default port where Appium server runs

        // cap → DesiredCapabilities object containing device + app details
        // (like platformName, deviceName, app path, automationName, etc.)

        // AndroidDriver → establishes connection between:
        // My test script  ↔  Appium server  ↔  Android device/emulator

        // Once this line executes:
        // 1. Appium server receives capabilities
        // 2. It starts a session on the device
        // 3. Installs/launches the app
        // 4. Returns a session ID to driver

        // driver now acts like a remote controller for the mobile app
        // All actions (click, sendKeys, swipe, etc.) will go through this driver

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Wait for elements
       // driver.manage() → gives access to browser/app-level settings (like timeouts, window, etc.)

     // timeouts() → used to configure different types of waits (implicit, page load, script)

     // implicitlyWait(Duration.ofSeconds(10)) → sets implicit wait to 10 seconds

     // Meaning:
     // If any element is NOT found immediately,
     // driver will keep trying (polling) for up to 10 seconds before throwing exception

     // Example:
     // driver.findElement(...) → if element is not present instantly,
     // it will wait up to 10 seconds before failing

     // This wait is applied globally to all findElement calls in the script

     // Important:
     // - It improves stability when elements load slowly
     // - Avoid mixing with explicit wait (can cause unexpected delays)

        // ================= ACTION =================
        loginClick();
        // Call click method

        Thread.sleep(3000);
        // Wait to observe action

        driver.quit();
        // Close app session
    }

    // ================= CLICK METHOD =================
    public static void loginClick() {
        // public → this method can be accessed from anywhere (inside or outside class)
        // static → belongs to class, so it can be called without creating object
        // void → this method does not return any value

        // Locate login button using accessibility id
        By loginBtn = AppiumBy.accessibilityId("test-LOGIN");
        // By → Selenium locator interface
        // AppiumBy.accessibilityId() → Appium-specific locator strategy
        // "test-LOGIN" → accessibility id (content-desc in Android)
        // This is a fast and reliable locator for mobile elements

        driver.findElement(loginBtn).click();
        // driver.findElement() → finds the element using given locator
        // loginBtn → locator we created above
        // .click() → performs tap action on the element
        // Internally: command goes → Appium server → device → element is clicked

        System.out.println("Login button clicked successfully");
        // Print message in console to confirm action is executed
    }
}

/*🔍 What you are seeing

You are seeing:

loginClick();   // method call

and

public static void loginClick() {   // method definition
✅ Difference (VERY IMPORTANT)
1️⃣ Method Call
loginClick();

👉 This means: “run the method”

2️⃣ Method Definition
public static void loginClick() {

👉 This means: “what this method will do”

💡 Simple Example (Real Life)

Think like this:

👉 You saved a contact: “Mom” (method definition)
👉 You press call: calling Mom (method call)

🧠 In Your Code Flow

Step-by-step:

App launched
Driver initialized
This line executes:
loginClick();   // calling method
Control goes to:
public static void loginClick() {
Then this runs:
driver.findElement(...).click();
🎯 Interview Answer (Very Important)

👉 Say this:

“One is method declaration and another is method call. I call the method from main to execute reusable action logic.”

❌ If you remove method call
// loginClick();  ❌ removed

👉 Then click will NEVER happen

✅ Why we use this pattern?

✔ Code becomes reusable
✔ Clean structure
✔ Easy to explain in interview

🔥 Pro Tip

If interviewer asks:

👉 “Why not write directly in main?”

Answer:

“To make code reusable and maintainable, I separate actions into methods.”

*============================================================================================================
*====================================Static=================================================================
*❌ Your Understanding (Needs Fix)

You said:

“static itself is a class”
👉 ❌ Wrong

“we always use static with final”
👉 ❌ Wrong

✅ Correct Understanding (Simple + Interview Ready)
🔹 1. What is static?

👉 static is NOT a class
👉 It is a keyword

👉 Correct Line:

“Static means the member belongs to the class, not to an object.”

🔹 2. Why we used static driver in your code?
static AppiumDriver driver;

👉 Because:

✔ main() is static
✔ static method cannot directly access non-static variables

🔹 3. Can static be used in another class?

👉 YES ✅ (but carefully)

Example:

ClassA.driver

👉 You can access static variable using ClassName

🔹 4. Static vs Non-Static (SUPER IMPORTANT)
Type	Belongs To	Access
static	Class	Direct (no object)
non-static	Object	Need object
🔹 5. Do we always use static final?

👉 ❌ NO — this is wrong

👉 When we use static final?

Only for constants

static final int MAX_VALUE = 10;

✔ static → shared
✔ final → cannot change

🔥 Final Interview Answer (Say this confidently)

👉 “Static is a keyword used to define class-level variables or methods. It allows access without creating an object. In my code, I used static driver because main method is static.”

💡 Bonus (Impress interviewer)

👉 Add this:

“Static is generally avoided in framework design; instead we use driver instances through base classes.”

✅ Summary (Remember this)

❌ static ≠ class
❌ static ≠ always with final

✔ static = class level
✔ final = constant
*===========================================Important Notes===================================
*🔥 IMPORTANT POINTS (INTERVIEW GOLD)

✔ Used accessibilityId (fast & recommended)
✔ Used static driver (because main is static)
✔ Used appWaitActivity (to handle splash screen)
✔ Used implicit wait (to avoid timing issues)
*/