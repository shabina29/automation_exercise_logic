package com.appium.learn;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginTest {
    public static void main(String[] args) throws Exception {

        // ================= CAPABILITIES SETUP =================
        // DesiredCapabilities ka use karke hum device aur app configuration define karte hain
        DesiredCapabilities cap = new DesiredCapabilities();

        // Platform define karna (Android device)
        cap.setCapability("platformName", "Android");

        // Device name (emulator ya real device)
        cap.setCapability("deviceName", "emulator-5554");

        // Automation engine (Appium uses UiAutomator2 for Android)
        cap.setCapability("automationName", "UiAutomator2");

        // ================= APK PATH =================
        // Ye APK ka exact path hai jisse Appium app install karega
        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // ================= APP LAUNCH FIX =================
        // Direct correct activity launch karne ke liye (important for stability)
        cap.setCapability("appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        // ================= STABILITY SETTINGS =================
        // Permissions automatically allow ho jaye
        cap.setCapability("autoGrantPermissions", true);

        // Har run me fresh app install ho
        cap.setCapability("noReset", false);
        
     // 🔥 FIXES
        cap.setCapability("uiautomator2ServerLaunchTimeout", 60000);
        cap.setCapability("adbExecTimeout", 60000);
        cap.setCapability("androidInstallTimeout", 90000);
        
        //=======LOcators
        // ================= DRIVER INITIALIZATION =================
        // Appium server se connection establish karke app launch hota hai
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), cap
        );

        // Implicit wait (elements load hone ke liye wait)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Console log
        System.out.println("✅ App Launched Successfully");

        // App ko dekhne ke liye wait (demo purpose)
        Thread.sleep(5000);
        
        By username = AppiumBy.accessibilityId("test-Username");
        driver.findElement(username).sendKeys("standard_user");
        System.out.println("user enters username");

        By password=AppiumBy.accessibilityId("test-Password");
        driver.findElement(password).sendKeys("secret_sauce");
        System.out.println("user enters password");
        
        By loginBtn=AppiumBy.accessibilityId("test-LOGIN");
        driver.findElement(loginBtn).click();
        System.out.println("user click on the login button");
        System.out.println("user logged in successfully");
        
        if (driver != null) {
            driver.quit();
        }

}}

/*“In mobile automation, we use driver.quit() instead of close()
 *  because there are no browser windows, and quit() properly ends the Appium session.”*/
