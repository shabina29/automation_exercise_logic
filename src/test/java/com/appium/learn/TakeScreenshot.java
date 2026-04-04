    package com.appium.learn;

	import io.appium.java_client.android.AndroidDriver;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.remote.DesiredCapabilities;

	import java.io.File;
	import java.net.URL;
	import java.time.Duration;

	import org.apache.commons.io.FileUtils;

	public class TakeScreenshot {

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
	        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // ================= TAKE SCREENSHOT =================
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        // Capture screenshot

	        File dest = new File("D:\\Software\\Automation\\screenshot.png");
	        // Destination path

	        FileUtils.copyFile(src, dest);
	        // Save screenshot

	        System.out.println("Screenshot captured successfully");

	        Thread.sleep(3000);
	        driver.quit();
	    }

	    // ================= INTERVIEW QUESTIONS & ANSWERS =================

	    // Q1: How do you take screenshot in Appium?
	    // A: I use TakesScreenshot interface and getScreenshotAs() method.

	    // Q2: Why do we cast driver to TakesScreenshot?
	    // A: Because getScreenshotAs() method is available in TakesScreenshot interface.

	    // Q3: What OutputType is used?
	    // A: OutputType.FILE is used to store screenshot as file.

	    // Q4: Where is screenshot stored?
	    // A: It is stored in local system path defined using File class.

	    // Q5: What library is used to copy file?
	    // A: Apache Commons IO (FileUtils) is used to copy file from source to destination.

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

	}


