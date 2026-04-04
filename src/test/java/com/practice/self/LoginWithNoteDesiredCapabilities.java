package com.practice.self;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginWithNoteDesiredCapabilities {
	public static void main(String[]args) throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		//1. Platform & Device (P)
		//👉 Device aur OS related sab yaha aata hai
		cap.setCapability("platformName","Android");
		cap.setCapability("deviceName", "emulator-5554");;
//💡 Interview line:"Platform & Device capabilities define kis device aur OS pe test run hoga."*/
		
		//2. Driver / Automation (D)
		//Appium ka engine kaun sa use hoga
		cap.setCapability("automationName","UIAutomator2");
		//💡 Interview line:"AutomationName defines which driver engine Appium will use to interact with the app."
		
		//🟡 3. App Configuration (A)
		//👉 App kaun sa hai + kaise launch hoga
		cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
		cap.setCapability("appPackage", "com.swaglabsmobileapp");
		cap.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");//APP = Install + Identify + Launch
		
		//Interview line:"App capabilities define which application to test and how to launch it."
		
		//🔴 4. Stability & Settings (S)
		//👉 Execution smooth karne ke liye
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("noReset", false);

		cap.setCapability("uiautomator2ServerLaunchTimeout", 60000);
		cap.setCapability("adbExecTimeout", 60000);
		cap.setCapability("androidInstallTimeout", 90000);
		//Test fail na ho → stability settings”
		
		//Interview line:"These capabilities improve test stability, control app state, and handle timeouts."
		
		//AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),cap);
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		By username=AppiumBy.accessibilityId("test-Username");
		 driver.findElement(username).sendKeys("standard_user");
	     System.out.println("user enters username");
		By password=AppiumBy.accessibilityId("test-Password");
		driver.findElement(password).sendKeys("secret_sauce");
		System.out.println("user enters password");
		
		/*Both approaches are valid, but I prefer storing locators in variables
		 *  because it improves code readability, reusability, and maintainability. 
		 *  If the locator changes, I only need to update it in one place instead of multiple locations in the code.*/
		By loginBtn=AppiumBy.accessibilityId("test-LOGIN");
	    driver.findElement(loginBtn).click();
	    System.out.println("user clicked on the login button ");
	    System.out.println("user logged in successfully");
	    
	    driver.quit();
		
		
	
	}

}

/**
 * In this code, I first create an object of DesiredCapabilities, where I define all the required configurations 
 * such as platformName, deviceName, automationName, app path, appPackage, and appActivity. These capabilities 
 * tell Appium how to set up the device and launch the application.
 *
 * Next, I initialize the AndroidDriver by passing the Appium server URL and the desired capabilities. This step 
 * establishes a connection between my test script and the Appium server.
 *
 * Once the driver session is created, I apply an implicit wait to handle element synchronization. After that, I 
 * interact with the application using locators like accessibilityId to perform actions such as entering username, 
 * password, and clicking the login button.
 *
 * Finally, I close the session using driver.quit(), which terminates the connection and stops the application.
 *
 * From an internal working perspective, when the test runs, the Java client converts the commands into JSON format 
 * and sends them to the Appium server. The Appium server then interprets these commands and forwards them to the 
 * appropriate automation engine, which is UiAutomator2 for Android in my case.
 *
 * UiAutomator2 interacts with the device, locates elements, and performs actions. The response is then sent back 
 * to the Appium server, which forwards it to the client, completing the request-response cycle.
 */
//===================================================================================================
/**
 * 🔹 Capabilities Based
 *
 * Q: What happens if appPackage is wrong?
 * A: If appPackage is incorrect, Appium will not be able to identify or launch the application.
 *    It may throw errors like "Activity not found" or fail to start the session.
 *
 * Q: Difference between noReset = true vs false?
 * A:
 *    noReset = true  → App state is preserved (no reinstall, login session retained).
 *    noReset = false → Fresh install every time (app data cleared, starts from login screen).
 *
 * Q: How do you get appPackage & appActivity?
 * A: We can use ADB commands:
 *    1. Launch the app manually
 *    2. Run: adb shell dumpsys window | findstr mCurrentFocus
 *    This gives the current appPackage and appActivity.
 *
 *
 * 🔹 Locator Based
 *
 * Q: Why avoid XPath?
 * A: XPath is slower and less stable because it depends on UI hierarchy.
 *    Any small UI change can break the locator.
 *
 * Q: Difference between id and accessibilityId?
 * A:
 *    id → Refers to resource-id defined in the app code.
 *    accessibilityId → Refers to content-desc (Android) used for accessibility.
 *    accessibilityId is usually faster and more stable.
 *
 * Q: Which locator is fastest?
 * A: accessibilityId is generally the fastest and most reliable locator,
 *    followed by id. XPath is the slowest.
 */
