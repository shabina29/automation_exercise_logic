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

/*
==================== APPIUM SCROLL + LIST HANDLING (INTERVIEW Q&A) ====================

❓ 1. Aapne scroll kaise implement kiya?

👉 Answer:
"I used Appium's mobile scrollGesture command which performs 
coordinate-based scrolling on the screen."

------------------------------------------------------------------------------

❓ 2. ScrollGesture ko inspect kaise karte ho?

👉 Answer:
"ScrollGesture cannot be inspected because it is not element-based. 
It works on screen coordinates."

------------------------------------------------------------------------------

❓ 3. Scroll kab use karte ho?

👉 Answer:
"Scroll is used when elements are not visible on the screen, 
such as long product lists."

------------------------------------------------------------------------------

❓ 4. Aapne hardcoded values kyu use ki?

👉 Answer:
"For demo purpose I used static values, but in real projects 
I prefer dynamic screen size for better device compatibility."

------------------------------------------------------------------------------

❓ 5. Aapne multiple elements kaise handle kiye?

👉 Answer:
"I used findElements to fetch a list of elements and then 
accessed a specific element using index."

------------------------------------------------------------------------------

❓ 6. findElement vs findElements difference?

👉 Answer:
"findElement returns a single element and throws exception if not found, 
while findElements returns a list and does not throw exception if empty."

------------------------------------------------------------------------------

❓ 7. Index-based selection kya hai?

👉 Answer:
"It is selecting elements based on their position in the list 
when unique locators are not available."

------------------------------------------------------------------------------

❓ 8. Index use karna safe hai?

👉 Answer:
"Index-based selection is less stable because UI changes can break it, 
so it should be used only when necessary."

------------------------------------------------------------------------------

❓ 9. IndexOutOfBoundsException kaise avoid kiya?

👉 Answer:
"I added a size check before accessing the element to ensure 
the list contains enough elements."

------------------------------------------------------------------------------

❓ 10. Aapne accessibilityId kyu use kiya?

👉 Answer:
"Accessibility ID is faster and more stable compared to XPath 
and is recommended for mobile automation."

------------------------------------------------------------------------------

❓ 11. App launch issue aaye to kya karte ho?

👉 Answer:
"I use capabilities like appWaitActivity and fullReset to ensure 
the app launches properly and in a clean state."

------------------------------------------------------------------------------

❓ 12. noReset vs fullReset kya hai?

👉 Answer:
"noReset keeps app data, while fullReset reinstalls the app 
and starts with a clean state."

------------------------------------------------------------------------------

❓ 13. Scroll ke baad element kaise select kiya?

👉 Answer:
"After scrolling, I fetched all elements and clicked the 
required one using index."

------------------------------------------------------------------------------

==================== FINAL INTERVIEW SUMMARY ====================

"I automated login using accessibility id, performed scrolling using 
scrollGesture, and handled multiple elements using list indexing with 
proper validation to ensure stability."

======================================================================================
*/