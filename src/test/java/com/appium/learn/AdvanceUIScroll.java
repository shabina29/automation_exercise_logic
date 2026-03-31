package com.appium.learn;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AdvanceUIScroll {
    public static void main(String[] args) throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");

        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("noReset", false);

        // 🔥 IMPORTANT FIXES (ADD THESE)
        cap.setCapability("fullReset", true);
        cap.setCapability("appWaitActivity", "*");

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), cap
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("✅ App Launched");

        // ================= LOGIN =================
        driver.findElement(AppiumBy.accessibilityId("test-Username"))
                .sendKeys("standard_user");

        driver.findElement(AppiumBy.accessibilityId("test-Password"))
                .sendKeys("secret_sauce");

        driver.findElement(AppiumBy.accessibilityId("test-LOGIN"))
                .click();

        System.out.println("✅ Login Done");

        Thread.sleep(3000);

        // ================= SCROLL =================
        driver.executeScript("mobile: scrollGesture", Map.of(
                "left", 100,
                "top", 100,
                "width", 800,
                "height", 1200,
                "direction", "down",
                "percent", 0.8
        ));

        // ================= LIST HANDLING =================
        List<WebElement> items = driver.findElements(
                AppiumBy.className("android.widget.TextView")
        );

        // 🔥 SAFE CHECK (IMPORTANT)
        if (items.size() > 3) {
            items.get(3).click();
            System.out.println("✅ Clicked 4th item");
        } else {
            System.out.println("⚠ Not enough items found");
        }

        driver.quit();
    }
}