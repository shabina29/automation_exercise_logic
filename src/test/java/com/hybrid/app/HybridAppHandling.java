package com.hybrid.app;

import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HybridAppHandling {

    static AndroidDriver driver;

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

        // ================= NAVIGATION =================

        // Step 1: Click Views
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        // Move inside Views screen


        // ================= SCROLL =================

        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\"));"
        ));
        // ONLY scroll (no click here)
        // This ensures element becomes visible


        // ================= CLICK =================

        By webview = AppiumBy.accessibilityId("WebView");
        driver.findElement(webview).click();
        // Click separately → more reliable than scroll+click


        // ================= WAIT FOR WEBVIEW LOAD =================

        Thread.sleep(3000);
        // Important: WebView takes time to load
        
     // ================= GET CONTEXT =================

        Set<String> contexts = driver.getContextHandles();
        // driver.getContextHandles() → returns all available contexts in the app
        // Context means the environment in which driver is currently working

        // 👉 Types of contexts:
        // NATIVE_APP → native mobile app (buttons, text, views)
        // WEBVIEW_xxx → web content inside app (HTML, CSS, JS)

        // Set<String> → collection that stores unique values (no duplicates)
        // Here it stores all context names

        // 🔍 Internally:
        // Appium checks the app
        // If WebView is present → it creates a WEBVIEW context
        // Otherwise → only NATIVE_APP is returned


        for (String context : contexts) {
            // Loop through each context one by one

            System.out.println("Available Context: " + context);
            // Print each context
            // Helps in debugging to see what contexts are available
        }


        // Example output:
        // NATIVE_APP
        // WEBVIEW_io.appium.android.apis


        // 🧠 Important Understanding:

        // 👉 When app starts:
        // Only NATIVE_APP is available

        // 👉 After opening WebView screen:
        // Both contexts appear:
        // 1. NATIVE_APP
        // 2. WEBVIEW_xxx


        // 🎯 Why we do this?

        // ✔ To know available contexts before switching
        // ✔ To avoid errors while switching
        // ✔ To debug when WEBVIEW is not visible


        // 🎤 Interview Answer:

        // “I use getContextHandles() to fetch all available contexts in the hybrid app.
        // It helps me identify the WEBVIEW context so I can switch from native to web environment.”


        // 🧠 One-Line Answer:

        // “This gets all available contexts in the app for context switching.”
        // Example output:
        // NATIVE_APP
        // WEBVIEW_io.appium.android.apis


        // ================= SWITCH TO WEBVIEW =================

        for (String context : contexts) {
            if (context.contains("WEBVIEW")) {

                driver.context(context);
                // Switch from native → webview

                System.out.println("Switched to: " + context);
                break;
            }
        }


        // ================= WEB ACTION =================

        WebElement text = driver.findElement(By.tagName("body"));
        // Now Selenium locators work (HTML DOM)

        System.out.println("WebView Text: " + text.getText());


        // ================= SWITCH BACK =================

        driver.context("NATIVE_APP");
        // Switch back to native app

        System.out.println("Switched back to Native");


        Thread.sleep(3000);

        driver.quit();
    }
}