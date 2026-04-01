package com.appium.learn;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class Scroll {

    public static void main(String[] args) throws Exception {

        // ================= CAPABILITIES =================
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");

        // APK path
        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // Auto अनुमति allow
        cap.setCapability("autoGrantPermissions", true);

        // Fresh install हर बार
        cap.setCapability("noReset", false);

        // ================= DRIVER =================
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), cap
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("✅ App Launched");

        // ================= LOGIN =================
        driver.findElement(AppiumBy.accessibilityId("test-Username"))
                .sendKeys("standard_user");
        System.out.println("➡ Entered Username");

        driver.findElement(AppiumBy.accessibilityId("test-Password"))
                .sendKeys("secret_sauce");
        System.out.println("➡ Entered Password");

        driver.findElement(AppiumBy.accessibilityId("test-LOGIN"))
                .click();
        System.out.println("➡ Clicked Login");

        Thread.sleep(3000);

        // ================= SCROLL =================
        /*
         ScrollGesture is a coordinate-based action.
         It does NOT require Appium Inspector.

         It scrolls the screen (not a specific element).
         Used when elements are outside the visible area.
        */

     // Get screen width (total horizontal size of device screen)
        int width = driver.manage().window().getSize().width;

        // Get screen height (total vertical size of device screen)
        int height = driver.manage().window().getSize().height;

        // Perform scroll using Appium mobile gesture command
        driver.executeScript("mobile: scrollGesture", Map.of(

                // Starting X coordinate (10% from left side of screen)
                "left", width * 0.1,

                // Starting Y coordinate (10% from top of screen)
                "top", height * 0.1,

                // Width of the scrollable area (80% of screen width)
                "width", width * 0.8,

                // Height of the scrollable area (80% of screen height)
                "height", height * 0.8,

                // Direction of scroll (downwards)
                "direction", "down",

                // How much to scroll (80% of the defined area)
                "percent", 0.8
        ));
        
        System.out.println("✅ Scroll Performed on Home Page");

        Thread.sleep(3000);

        // ================= CLOSE SESSION =================
        driver.quit();
        System.out.println("✅ Session Ended");
    }
}


/*
==================== SCROLL GESTURE EXPLANATION ====================

👉 ScrollGesture ko inspect nahi karte (IMPORTANT)

-------------------- IMPORTANT TRUTH --------------------

👉 Ye code:
driver.executeScript("mobile: scrollGesture", ...)

👉 Kisi element pe based nahi hota
👉 Iska matlab:
👉 Isme inspect karne jaisa kuch nahi hota ❌

-------------------- WHY NO INSPECTOR --------------------

👉 Inspector ka use hota hai:
✔ Elements find karne ke liye
✔ Locator banane ke liye

👉 But scrollGesture:
✔ Pure screen movement hai
✔ Coordinates based hai
✔ Kisi element pe depend nahi karta

-------------------- SIMPLE UNDERSTANDING --------------------

👉 2 types hote hain:

1️⃣ Element-based (INSPECT needed)
   driver.findElement(...)
   ✔ Inspector use hota hai

2️⃣ Gesture-based (NO INSPECT)
   scrollGesture
   ❌ Inspector ki need nahi hoti

-------------------- VALUES KAHA SE AATI HAIN --------------------

👉 Ye values:
"left", 100
"top", 100
"width", 800
"height", 1200

👉 Screen size ke approx coordinates hote hain

-------------------- BETTER APPROACH (ADVANCED) --------------------

👉 Dynamic scroll (recommended):

int width = driver.manage().window().getSize().width;
int height = driver.manage().window().getSize().height;

driver.executeScript("mobile: scrollGesture", Map.of(
        "left", width * 0.1,
        "top", height * 0.1,
        "width", width * 0.8,
        "height", height * 0.8,
        "direction", "down",
        "percent", 0.8
));

✔ Har device pe kaam karega
✔ Interview-level implementation

-------------------- INTERVIEW ANSWER --------------------

“I use scrollGesture which is a coordinate-based action.
It does not require Appium Inspector, as it works using screen dimensions.”

-------------------- ONE LINE --------------------

“ScrollGesture works on screen coordinates, not on elements.”

-------------------- FINAL CLARITY --------------------

Inspector      → Elements ke liye
ScrollGesture  → Screen movement ke liye

===================================================================

*/
/*
==================== APPIUM SCROLL - INTERVIEW Q&A ====================

❓ 1. ScrollGesture kya hai?

👉 Answer:
"ScrollGesture is a mobile command in Appium used to scroll the screen 
based on coordinates like direction and percentage."

-----------------------------------------------------------------------

❓ 2. ScrollGesture aur UiScrollable me difference?

👉 Answer:
"ScrollGesture scrolls the screen blindly using coordinates, while 
UiScrollable scrolls until a specific element is found using text or selector."

-----------------------------------------------------------------------

❓ 3. Scroll ko inspect kaise karte ho?

👉 Answer:
"ScrollGesture cannot be inspected because it is a coordinate-based action, 
not an element-based action."

-----------------------------------------------------------------------

❓ 4. Scroll kab use karte ho?

👉 Answer:
"Scroll is used when elements are not visible on the screen, 
such as product lists or long pages."

-----------------------------------------------------------------------

❓ 5. Login page par scroll use karoge?

👉 Answer:
"No, because all elements are already visible. Scroll is used only 
when elements are outside the viewport."

-----------------------------------------------------------------------

❓ 6. Scroll dynamic kaise banate ho?

👉 Answer:
"We use screen size dynamically using driver.manage().window().getSize() 
so that scroll works across different devices."

-----------------------------------------------------------------------

❓ 7. ScrollGesture ke parameters kya hote hain?

👉 Answer:
direction (up/down)
percent
left, top
width, height

"These parameters define the scroll area and direction on the screen."

-----------------------------------------------------------------------

❓ 8. Scroll fail ho raha hai to kya check karoge?

👉 Answer:
"I check screen dimensions, direction, and ensure the scroll area 
is properly defined."

-----------------------------------------------------------------------

❓ 9. Accessibility ID kyu use kiya login me?

👉 Answer:
"Accessibility ID is faster and more stable compared to XPath 
and is recommended for mobile automation."

-----------------------------------------------------------------------

❓ 10. driver.close() vs driver.quit()?

👉 Answer:
"driver.quit() is used in mobile automation to end the session, 
while close() is for browser tabs and not supported in Appium."

-----------------------------------------------------------------------

==================== BONUS (ADVANCED) ====================

❓ 11. Kya scrollGesture har device par same kaam karega?

👉 Answer:
"No, that’s why we use dynamic screen size instead of hardcoded values."

-----------------------------------------------------------------------

❓ 12. Scroll aur swipe me difference?

👉 Answer:
"Scroll is used to move the page slowly, while swipe is a faster 
gesture typically used for navigation."

-----------------------------------------------------------------------

❓ 13. Kya scrollGesture loop me use kar sakte ho?

👉 Answer:
"Yes, we can loop scroll until the element becomes visible."

-----------------------------------------------------------------------

==================== FINAL INTERVIEW TIP ====================

"I automated login using accessibility id and performed scrolling 
using Appium’s scrollGesture. I used dynamic screen dimensions 
to make it work across devices."

=======================================================================
*/