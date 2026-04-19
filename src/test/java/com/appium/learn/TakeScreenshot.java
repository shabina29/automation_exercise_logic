package com.appium.learn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

public class TakeScreenshot {

	static AppiumDriver driver;

	public static void main(String[] args) throws Exception {

		// ================= CAPABILITIES =================
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\ApiDemos-debug.apk");

		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("appWaitActivity", "*");

		// ================= DRIVER =================
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// ================= TAKE SCREENSHOT =================

		// Capture screenshot from driver
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Step 1:
		// driver is typecasted to TakesScreenshot interface
		// getScreenshotAs(OutputType.FILE) → captures current screen
		// Screenshot is stored as a temporary file (src)
             //>>>>>>>>>>>>>>>>>>>>>>>
		/*
		 * 🎯 Line: ((TakesScreenshot) driver) 🧠 What does typecasted mean?
		 * 
		 * 👉 Typecasting means converting one type into another type
		 * 
		 * 🔍 In Your Case File src = ((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.FILE);
		 * 
		 * 👉 Here:
		 * 
		 * driver → AndroidDriver / AppiumDriver TakesScreenshot → Interface
		 * 
		 * 👉 Meaning:
		 * 
		 * “Driver ko TakesScreenshot type me convert kar rahe hain taaki screenshot
		 * method use kar sakein”
		 * 
		 * 🧠 Why we need typecasting?
		 * 
		 * 👉 Because:
		 * 
		 * driver.getScreenshotAs(...)
		 * 
		 * ❌ Not directly available (compile error)
		 * 
		 * 👉 But:
		 * 
		 * ((TakesScreenshot) driver).getScreenshotAs(...)
		 * 
		 * ✔ Works ✅
		 * 
		 * 🧠 Simple Example Object obj = "Hello";
		 * 
		 * String str = (String) obj;
		 * 
		 * 👉 Object → String conversion
		 * 
		 * 🎯 Real Understanding
		 * 
		 * 👉 Driver actually supports screenshot 👉 But compiler ko batana padta hai:
		 * 
		 * “Trust me, this driver can take screenshot”
		 * 
		 * 🎤 Interview Answer (BEST)
		 * 
		 * “Typecasting is converting a reference from one type to another. Here, I cast
		 * the driver to TakesScreenshot so I can access the getScreenshotAs method.”
		 * 
		 * 🧠 One-Line Answer
		 * 
		 * “Typecasting allows us to access methods of a specific interface or class.”
		 * 
		 * ⚠️ Important Point
		 * 
		 * 👉 If driver does NOT support it: ❌ Runtime error (ClassCastException)
		 */

//=================================================================================
		// Define destination file path
		File dest = new File("D:\\Software\\Automation\\screenshot.png");
		// Step 2:
		// Create a file object where screenshot will be saved
		// This is the final location on your system

		// Copy screenshot from source to destination
		FileUtils.copyFile(src, dest);
		// Step 3:
		// Copy file from temporary location (src) → permanent location (dest)
		// Uses Apache Commons IO library

		System.out.println("Screenshot captured successfully");
		// Step 4:
		// Print confirmation message

		Thread.sleep(3000);
		// Step 5:
		// Pause execution for 3 seconds (to observe result)
		// Not recommended in real framework → use waits instead

		driver.quit();
		// Step 6:
		// Close the Appium session and end the test
	}
}
// ================= INTERVIEW QUESTIONS & ANSWERS =================

// Q1: How do you take screenshot in Appium?
// A: I use TakesScreenshot interface and getScreenshotAs() method.

// Q2: Why do we cast driver to TakesScreenshot?
// A: Because getScreenshotAs() method is available in TakesScreenshot
// interface.

// Q3: What OutputType is used?
// A: OutputType.FILE is used to store screenshot as file.

// Q4: Where is screenshot stored?
// A: It is stored in local system path defined using File class.

// Q5: What library is used to copy file?
// A: Apache Commons IO (FileUtils) is used to copy file from source to
// destination.

// Q6: When do you capture screenshot in real project?
// A: Mostly on test failure for debugging and reporting purposes.

// Q7: Can we take screenshot of specific element?
// A: Yes, using element.getScreenshotAs() method.

// Q8: What is the return type of getScreenshotAs()?
// A: It returns a File object.

// Q9: Is screenshot supported for both Android and iOS?
// A: Yes, it works for both platforms in Appium.

// Q10: How do you handle screenshot naming?
// A: By adding timestamp or test case name to avoid overwrite.

/*
 * 🧠 HOW TO EXPLAIN IN INTERVIEW
 * 
 * 👉 Say this:
 * 
 * “I take screenshot using TakesScreenshot interface and getScreenshotAs
 * method. I store it using FileUtils, and usually capture screenshots on test
 * failure for debugging.”
 * 
 * 🔥 PRO TIP
 * 
 * 👉 If you say this → interviewer impressed:
 * 
 * “In framework, I integrate screenshot capture inside TestNG listeners for
 * failure reporting.”
 */

// ================= TESTNG LISTENER NOTES =================

// 🎯 WHERE DO WE KEEP TESTNG LISTENER?

// ✅ Standard Structure (REAL PROJECT)
/*
 * src/test/java ├── tests/ │ ├── LoginTest.java │ ├── base/ │ ├── BaseTest.java
 * │ ├── listeners/ ✅ ⭐ HERE │ ├── TestListener.java
 */

// 👉 Listener is kept in separate package: listeners

// 🎯 WHY SEPARATE PACKAGE?

// 👉 Because:
// ✔ Reusable for all test classes
// ✔ Clean framework design
// ✔ Easy to manage logging/reporting

// 🎯 HOW TO USE LISTENER?

// ✅ 1. Create Listener Class

/*
 * package listeners;
 * 
 * import org.testng.ITestListener; import org.testng.ITestResult;
 * 
 * public class TestListener implements ITestListener {
 * 
 * @Override public void onTestFailure(ITestResult result) {
 * System.out.println("Test Failed: " + result.getName()); } }
 */

// ✅ 2. Attach Listener

// 👉 Option 1: Using Annotation (MOST COMMON)

/*
 * @Listeners(listeners.TestListener.class) public class LoginTest { }
 */

// 👉 Option 2: Using testng.xml

/*
 * <listeners> <listener class-name="listeners.TestListener"/> </listeners>
 */

// 🎯 HOW SCREENSHOT CONNECTS HERE 🔥

// 👉 Inside listener:

/*
 * public void onTestFailure(ITestResult result) {
 * takeScreenshot(result.getName()); }
 */

// 👉 This is how auto screenshot on failure works

// 🧠 INTERVIEW ANSWER (VERY IMPORTANT)

// 👉 Say this:
// “I create TestNG listeners in a separate listeners package and use them
// to capture screenshots, logs, and reports during test execution,
// especially on failures.”

// 🔥 PRO TIP (ADVANCED ANSWER)

// 👉 Add this:
// “In my framework, I integrate listeners with reporting tools like
// Extent Reports to capture screenshots on failure.”

// ✅ SUMMARY

/*
 * Item Location --------------------------- Listener class listeners package
 * Use Annotation / testng.xml Purpose Logging, Screenshot, Reporting
 */

// =========================================================
