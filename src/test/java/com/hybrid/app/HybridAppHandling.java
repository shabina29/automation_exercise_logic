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

    static AndroidDriver driver;   // ✅ FIXED

    public static void main(String[] args) throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");

        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\ApiDemos-debug.apk");

        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("appWaitActivity", "*");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Click Views
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        // Scroll to WebView
        driver.findElement(AppiumBy.androidUIAutomator(
        	    "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\"));"
        	)).click();
        // Get contexts
        Set<String> contexts = driver.getContextHandles();

        for (String context : contexts) {
            System.out.println("Available Context: " + context);
        }

        // Switch to WEBVIEW
        for (String context : contexts) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                System.out.println("Switched to: " + context);
                break;
            }
        }

        // Web action
        WebElement text = driver.findElement(By.tagName("body"));
        System.out.println("WebView Text: " + text.getText());

        // Switch back to Native
        driver.context("NATIVE_APP");
        System.out.println("Switched back to Native");

        Thread.sleep(3000);
        driver.quit();
    }
}