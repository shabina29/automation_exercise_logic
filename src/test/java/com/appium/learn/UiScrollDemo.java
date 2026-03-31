package com.appium.learn;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class UiScrollDemo {

    public static void main(String[] args) throws Exception {

        // ================= CAPABILITIES =================

        // DesiredCapabilities object banaya jisme device + app config define hota hai
        DesiredCapabilities cap = new DesiredCapabilities();

        // Platform define kiya (Android device)
        cap.setCapability("platformName", "Android");

        // Emulator/device ka naam
        cap.setCapability("deviceName", "emulator-5554");

        // Automation engine (Android ke liye UiAutomator2 use hota hai)
        cap.setCapability("automationName", "UiAutomator2");

        // APK ka path jisse Appium app install karega
        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // Permissions automatically allow ho jayengi
        cap.setCapability("autoGrantPermissions", true);

        // Har run me fresh install hoga
        cap.setCapability("noReset", false);

        // ================= DRIVER =================

        // Appium server se connect karke app launch hota hai
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), cap
        );

        // Implicit wait (element load hone ke liye)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("✅ App Launched");

        // ================= LOGIN =================

        // Username field locate karke value enter ki
        driver.findElement(AppiumBy.accessibilityId("test-Username"))
                .sendKeys("standard_user");

        // Password field me value enter ki
        driver.findElement(AppiumBy.accessibilityId("test-Password"))
                .sendKeys("secret_sauce");

        // Login button click kiya
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN"))
                .click();

        System.out.println("✅ Login Done");

        // Thoda wait taaki next screen load ho jaye
        Thread.sleep(3000);

        // ================= UI SCROLL =================

        /*
         UiScrollable ek Android UIAutomator command hai jo
         screen ko tab tak scroll karta hai jab tak target element mil na jaye

         Ye blind scroll nahi hai (jaise scrollGesture),
         balki directly specific element ko dhundta hai
        */

        driver.findElement(AppiumBy.androidUIAutomator(

                // Full UiScrollable command string
                "new UiScrollable(new UiSelector())" +

                // Scroll karta rahega jab tak element visible na ho
                ".scrollIntoView(" +

                // Target element text jise dhundhna hai
                "text(\"Sauce Labs Backpack\"));"
        ));
        
        /*“Index-based scrolling can be used when elements don’t have unique identifiers, 
         * but it is less stable compared to text or resource-id based locators.”*/

        System.out.println("✅ Scrolled to specific product");

        Thread.sleep(3000);

        // ================= CLOSE SESSION =================

        // Driver quit karne se Appium session end ho jata hai
        driver.quit();

        System.out.println("✅ Session Ended");
    }
}

/*
==================== INTERVIEW Q&A (UI SCROLL) ====================

❓ What is UiScrollable?

👉 "UiScrollable is an Android UIAutomator feature used to scroll 
until a specific element is found."

------------------------------------------------------------------

❓ Difference between scrollGesture and UiScrollable?

👉 "ScrollGesture scrolls blindly using coordinates, while 
UiScrollable scrolls until a specific element is located."

------------------------------------------------------------------

❓ When do you use UiScrollable?

👉 "When I need to scroll to a specific element by text or selector."

------------------------------------------------------------------

❓ Can UiScrollable be used in iOS?

👉 "No, it is Android-specific as it uses UIAutomator."

------------------------------------------------------------------

❓ Why use UiScrollable instead of loop scroll?

👉 "It directly finds the element, reducing code complexity and improving efficiency."

------------------------------------------------------------------

❓ One-line answer:

👉 "UiScrollable is used to scroll to a specific element."

===================================================================
*/