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

public class ClickAction {

    static AppiumDriver driver;
    // Static driver so it can be used inside static methods

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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Wait for elements

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

        // Locate login button using accessibility id
        By loginBtn = AppiumBy.accessibilityId("test-LOGIN");

        driver.findElement(loginBtn).click();
        // Perform click action

        System.out.println("Login button clicked successfully");
        // Print confirmation
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