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

public class ScreenShot_Read_This_Interview {




	    static AppiumDriver driver;
	    // Driver declared at class level → can be used across methods

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

	        // Step 1: Capture screenshot
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        // 👉 Typecasting:
	        // Convert driver → TakesScreenshot
	        // So we can use getScreenshotAs() method
	        // Screenshot stored in temporary file (src)

	        // Step 2: Define destination path
	        File dest = new File("D:\\Software\\Automation\\screenshot.png");
	        // Final location where screenshot will be saved

	        // Step 3: Copy file
	        FileUtils.copyFile(src, dest);
	        // Copy screenshot from temp location → actual path

	        // Step 4: Confirmation log
	        System.out.println("Screenshot captured successfully");

	        // Step 5: Wait (for observation)
	        Thread.sleep(3000);

	        // Step 6: Close driver
	        driver.quit();
	    }
	}


