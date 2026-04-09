package com.appium.learn;
// Package → organizes class inside project

import io.appium.java_client.AppiumBy;
// Appium locator strategy (best for mobile)

import io.appium.java_client.android.AndroidDriver;
// Android driver to control device

import org.openqa.selenium.By;
// Used to define locator

import org.openqa.selenium.remote.DesiredCapabilities;
// Used to define device + app configuration

import java.net.URL;
// Used to connect to Appium server

import java.time.Duration;
// Used for wait

public class TapGestureTouchAction {

	public static void main(String[] args) throws Exception {

		// ================= CAPABILITIES =================
		DesiredCapabilities cap = new DesiredCapabilities();
		// Object to store device + app configuration

		cap.setCapability("platformName", "Android");
		// Platform → Android

		cap.setCapability("deviceName", "emulator-5554");
		// Device name (emulator or real device)

		cap.setCapability("automationName", "UiAutomator2");
		// Automation engine for Android

		cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\ApiDemos-debug.apk");
		// Path of APK file to install

		cap.setCapability("autoGrantPermissions", true);
		// Automatically allow all permissions

		cap.setCapability("appWaitActivity", "*");
		// Wait for any activity (handles splash screen)

		// ================= DRIVER =================
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		// Connect to Appium server
		// Install and launch app

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Implicit wait → wait up to 10 sec for elements

		// ================= FIXED FLOW =================

		// Step 1: Click "Views"
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		// IMPORTANT:
		// "Content" is NOT available on home screen
		// It is inside "Views"
		// So first we must navigate to Views screen

		// Step 2: Locate "Content"
		By tapContent = AppiumBy.accessibilityId("Content");
		// Now "Content" element is visible

		// Step 3: Click "Content"
		driver.findElement(tapContent).click();
		// Perform normal click
		// This is BEST and most used approach in real projects

		// ⚠️ IMPORTANT FIX:
		// Do NOT use both click() and clickGesture()
		// Because after click → screen changes
		// Second call will fail (element not found)

		// Step 4: Print confirmation
		System.out.println("Tap action performed successfully");
		// This will now print because no exception occurs

		// Step 5: Wait for observation
		Thread.sleep(3000);
		// Not recommended in real framework (use explicit wait)

		// Step 6: Close driver
		driver.quit();
		// Ends session and closes app
	}
}

/*
 * 🎯 Interview Explanation (Perfect Answer)
 * 
 * “In this scenario, I first ensure correct navigation before interacting with
 * elements. Since the 'Content' element is inside the 'Views' screen, I first
 * click on 'Views', then locate and interact with the 'Content' element.
 * 
 * I use accessibilityId for locating elements as it is fast and reliable. Also,
 * I use a simple click() for interaction, which is the preferred approach in
 * real projects. Gesture-based actions are only used when normal click fails.”
 * 
 * 
 * 🔥 Key Points to Say
 * 
 * ✔ Always ensure correct screen before interaction ✔ Use accessibilityId (best
 * locator for mobile) ✔ Prefer click() over gesture ✔ Avoid duplicate actions
 * 
 * 
 * 🚀 Pro Tip (Impress Interviewer)
 * 
 * “In my framework, I handle navigation and element visibility properly to
 * avoid NoSuchElementException.”
 * 
 * 
 * 🧠 One-Line Answer
 * 
 * “I fixed the issue by navigating to the correct screen before performing
 * action.”
 */
// Ends the Appium session
// Closes app and releases device/emulator resources

////*“This code is written using Appium 2.x with Java Client 8+, 
/// where we use W3C-based gestures like ‘mobile: clickGesture’. 
/// In real projects, we usually use driver.findElement().click() for normal tap actions. 
/// Gesture-based tap is used only in cases where click fails, like overlays or complex UI interactions. 
/// TouchAction is deprecated, so modern frameworks use W3C gesture APIs.”*///

//================= INTERVIEW QUESTIONS & ANSWERS =================

//Q1: How do you perform tap action in Appium?
//A: I use driver.findElement().click() for simple tap. For advanced gesture,
// I use mobile: clickGesture using executeScript.

//Q2: Why is TouchAction not used in latest Appium?
//A: TouchAction is deprecated in Appium 2.0. It is replaced by W3C actions
// and mobile gestures like clickGesture for better standardization.

//Q3: What is the difference between click() and clickGesture?
//A: click() is a simple WebDriver method. clickGesture is a mobile-specific
// gesture used for more control and better compatibility in real devices.

//Q4: What locator strategy did you use here?
//A: I used accessibilityId using AppiumBy, which is fast and reliable for mobile apps.

//Q5: Why do we use AppiumBy instead of MobileBy?
//A: MobileBy is deprecated. AppiumBy is the updated class in latest Appium versions.

//Q6: What is accessibilityId?
//A: It is a unique identifier for mobile elements, commonly used for fast and stable element location.

//Q7: What happens if element is not found?
//A: It throws NoSuchElementException. We handle it using waits like implicit or explicit wait.

//Q8: Why did you use implicit wait?
//A: To handle synchronization issues and allow elements time to load before interaction.

//Q9: How do you start an Appium session?
//A: By defining DesiredCapabilities and initializing driver using AndroidDriver with Appium server URL.

//Q10: What is appWaitActivity?
//A: It tells Appium to wait for a specific activity or any activity (*) during app launch,
//  which helps handle splash screens.
//================================================================

//🔥 PRO TIP

/*
 * 👉 In interview, don’t just say code — say like this:
 * 
 * “In my current implementation, I perform tap using click(), and for advanced
 * gestures I use mobile: clickGesture since TouchAction is deprecated.”
 * 
 * ❗ ISSUES IN YOUR CODE
 * 
 * 👉 You had:
 * 
 * ❌ MobileBy (deprecated) ❌ TouchAction (deprecated) ❌ action not defined ❌
 * mixing old + new approach
 */
