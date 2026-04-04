package com.appium.learn;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class TapGestureTouchAction {

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

        // ================= TAP ELEMENT =================
        By tapContent = AppiumBy.accessibilityId("Content");

        // ✅ SIMPLE CLICK (BEST)
        driver.findElement(tapContent).click();

        // ✅ MODERN TAP (GESTURE WAY 🔥)
        driver.executeScript("mobile: clickGesture", Map.of(
                "elementId", ((RemoteWebElement) driver.findElement(tapContent)).getId()
        ));

        System.out.println("Tap action performed");

        Thread.sleep(3000);
        driver.quit();
    }
}

//================= INTERVIEW QUESTIONS & ANSWERS =================

//Q1: How do you perform tap action in Appium?
//A: I use driver.findElement().click() for simple tap. For advanced gesture,
// I use mobile: clickGesture using executeScript.

//Q2: Why is TouchAction not used in latest Appium?
//A: TouchAction is deprecated in Appium 2.0. It is replaced by W3C actions
// and mobile gestures like clickGesture for better standardization.

//Q3: What is the difference between click() and clickGesture?
//A: click() is a simple WebDriver method. clickGesture is a mobile-specific
// gesture used for more control and better compatibility in real devices.

//Q4: What locator strategy did you use here?
//A: I used accessibilityId using AppiumBy, which is fast and reliable for mobile apps.

//Q5: Why do we use AppiumBy instead of MobileBy?
//A: MobileBy is deprecated. AppiumBy is the updated class in latest Appium versions.

//Q6: What is accessibilityId?
//A: It is a unique identifier for mobile elements, commonly used for fast and stable element location.

//Q7: What happens if element is not found?
//A: It throws NoSuchElementException. We handle it using waits like implicit or explicit wait.

//Q8: Why did you use implicit wait?
//A: To handle synchronization issues and allow elements time to load before interaction.

//Q9: How do you start an Appium session?
//A: By defining DesiredCapabilities and initializing driver using AndroidDriver with Appium server URL.

//Q10: What is appWaitActivity?
//A: It tells Appium to wait for a specific activity or any activity (*) during app launch,
//  which helps handle splash screens.
//================================================================

//🔥 PRO TIP

/*👉 In interview, don’t just say code — say like this:

“In my current implementation, I perform tap using click(), 
and for advanced gestures I use mobile: clickGesture since TouchAction is deprecated.”

*❗ ISSUES IN YOUR CODE

👉 You had:

❌ MobileBy (deprecated)
❌ TouchAction (deprecated)
❌ action not defined
❌ mixing old + new approach*/


