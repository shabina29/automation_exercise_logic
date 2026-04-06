package com.appium.learn;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class LongPressGesture {

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

        Thread.sleep(3000);

        // ================= NAVIGATION =================
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

     // ================= TARGET ELEMENT =================

        By element = AppiumBy.xpath("//android.widget.TextView[@text='People Names']");
        // 👉 We are locating the element using XPath
        // 👉 This finds a TextView whose visible text is "People Names"
        // 👉 This element is the target where we want to perform long press
        // 👉 In real apps, we can also use accessibilityId or id (faster than XPath)


        // ================= LONG PRESS =================

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        // 👉 PointerInput represents a virtual finger (touch input)
        // 👉 Kind.TOUCH → tells Appium we are simulating a mobile touch (not mouse)
        // 👉 "finger" → just a name for this input (can be anything)
        // 👉 This is required because W3C actions simulate real device gestures


        Sequence longPress = new Sequence(finger, 1);
        // 👉 Sequence defines a set of actions performed step-by-step
        // 👉 "finger" → this sequence will use the finger we created
        // 👉 1 → sequence id (used internally, can be any number)
        // 👉 Think of this as: “what actions finger will perform in order”


        // Move finger to element location
        longPress.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), 500, 600));
        // 👉 This moves the finger to a specific coordinate on screen
        // 👉 Duration.ZERO → move instantly (no delay)
        // 👉 Origin.viewport() → coordinates are based on entire screen
        // 👉 (500,600) → X and Y position (center-ish area)
        // 👉 IMPORTANT: This does NOT touch the screen yet, only positions finger


        // Press finger on screen
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // 👉 This simulates pressing the finger on screen (touch down)
        // 👉 LEFT button is used to represent finger press
        // 👉 Now the finger is touching the screen at (500,600)


        // HOLD (THIS IS LONG PRESS 🔥)
        longPress.addAction(finger.createPointerMove(Duration.ofSeconds(2),
                PointerInput.Origin.viewport(), 500, 600));
        // 👉 This is the MOST IMPORTANT step
        // 👉 We are NOT moving finger (same coordinates)
        // 👉 But we are giving time: Duration.ofSeconds(2)
        // 👉 That means finger stays pressed for 2 seconds → LONG PRESS
        // 👉 Without this delay → it becomes just a tap


        // Release finger
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // 👉 This simulates lifting finger from screen
        // 👉 After hold, we release → completes the gesture


        // Perform action
        driver.perform(Collections.singletonList(longPress));
        // 👉 Executes the full sequence (move → press → hold → release)
        // 👉 singletonList → we are passing one gesture sequence
        // 👉 This is where actual action happens on device


        System.out.println("Long press performed");
        // 👉 Prints confirmation in console for debugging


        Thread.sleep(3000);
        // 👉 Wait for 3 seconds to observe result (demo purpose)
        // 👉 Not recommended in real framework (use waits instead)


        driver.quit();
    }}
        // 👉 Closes the app and ends Appium session

    // ================= INTERVIEW Q&A =================

    // Q1: How do you perform long press in Appium?
    // A: Using W3C actions by holding finger on element using PointerInput and Sequence.

    // Q2: What is the difference between tap and long press?
    // A: Tap is quick click, long press involves holding for a duration.

    // Q3: How is hold implemented?
    // A: By adding delay using Duration.ofSeconds() while finger stays at same position.

    // Q4: Why not use TouchAction?
    // A: It is deprecated in latest Appium.

    // Q5: Real use case of long press?
    // A: Context menu, drag-drop, selecting options.


//===============================================================================
/*🧠 SUPER SIMPLE UNDERSTANDING

👉 Real life:

Finger moves to element
Finger touches screen
Finger holds for 2 sec
Finger lifts

👉 That = LONG PRESS 💯

🎯 INTERVIEW PERFECT ANSWER

👉 Say this:

“Long press is performed by pressing and holding on an element using W3C actions. 
The hold duration is controlled using Duration while the finger stays at same position.”

🔥 KEY LINE (INTERVIEW FOCUS)

👉 This one:

Duration.ofSeconds(2)

👉 That = difference between tap vs long press

⚡ MEMORY TRICK

👉 Tap = press + release
👉 Long press = press + hold + release*/
