package com.appium.learn;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class SwipeGesture {

    public static void main(String[] args) throws Exception {

        // ================= CAPABILITIES =================
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");

        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\ApiDemos-debug.apk");

        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("appWaitActivity", "*");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);

        Thread.sleep(3000);

        // ================= SWIPE ACTION =================
     // Create a virtual finger (touch input)
     // PointerInput represents the touch action like a real finger on screen
     PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

     // Create a sequence of actions using that finger
     // Sequence means step-by-step actions (press → move → release)
     Sequence swipe = new Sequence(finger, 1);

     // Move finger to starting point WITHOUT touching the screen
     // Duration.ZERO → instantly move pointer
     // Origin.viewport() → coordinates are based on screen
     // (500,1500) → starting position (X=middle, Y=bottom area)
     swipe.addAction(finger.createPointerMove(Duration.ZERO,
             PointerInput.Origin.viewport(), 500, 1500));


     // Press finger on screen (like touching mobile screen)
     // LEFT button simulates finger press
     swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));


     // Move finger from start point to end point
     // Duration.ofMillis(800) → swipe happens over 800 milliseconds (smooth swipe)
     // (500,500) → end position (moving upward)
     swipe.addAction(finger.createPointerMove(Duration.ofMillis(800),
             PointerInput.Origin.viewport(), 500, 500));


     // Release finger (like lifting finger from screen)
     swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


     // Perform all actions together
     // singletonList → only one gesture sequence is executed
     driver.perform(Collections.singletonList(swipe));


     // Print confirmation
     System.out.println("Swipe performed");


     // Wait to observe result (not needed in real framework)
     Thread.sleep(3000);


     // Close driver session
     driver.quit();
    }
}

    // ================= INTERVIEW Q&A =================

    // Q1: How do you perform swipe in Appium?
    // A: Using W3C Actions with PointerInput and Sequence.

    // Q2: Why not use TouchAction?
    // A: TouchAction is deprecated in latest Appium versions.

    // Q3: What is PointerInput?
    // A: It represents touch input like finger for gestures.

    // Q4: What is Sequence?
    // A: It defines a sequence of actions like press, move, release.

    // Q5: What do coordinates represent?
    // A: Start and end points of swipe on screen.

/*🧠 SIMPLE UNDERSTANDING (VERY IMPORTANT)

👉 Think like real life:

Move finger to screen
Touch screen
Drag finger
Lift finger

👉 That’s exactly what this code is doing 💯

🎯 INTERVIEW EXPLANATION (USE THIS 🔥)

👉 Say this:

“I create a PointerInput to simulate a finger,
 then define a Sequence of actions like move, press, move, and release to perform swipe using W3C actions.”

🔥 KEY CONCEPTS (REMEMBER)
Term	Meaning
PointerInput	Finger
Sequence	Step-by-step actions
PointerMove	Move finger
PointerDown	Touch screen
PointerUp	Release finger
⚡ SHORT VERSION (IF TIME LESS IN INTERVIEW)

👉 Say:

“Swipe is performed by defining start and end coordinates using PointerInput and executing press, 
move, and release actions.”*/



//=================================================================================
/*🎯 ✅ HAVE YOU DONE SWIPE?

👉 YES ✅

You implemented:

✔ Press → Move → Release
✔ Using W3C Actions (PointerInput + Sequence)

👉 Your flow:

Move → Press → Move → Release

👉 So answer:

“Yes, I have implemented swipe using W3C actions where I simulate finger press, move, and release.”

🎯 ❌ HAVE YOU DONE ZOOM?

👉 NO ❌ (Not yet)

👉 Because:

Zoom requires:

✔ 2 fingers (multi-touch)
✔ Two PointerInputs
✔ Moving in opposite direction

🎯 DIFFERENCE (VERY IMPORTANT FOR INTERVIEW)
Gesture	Fingers	What happens
Swipe	1 finger	Move screen
Zoom	2 fingers	Expand / shrink
🎯 WHAT YOU SHOULD SAY IN INTERVIEW

👉 BEST ANSWER:

“I have implemented swipe using W3C actions. For zoom, it requires multi-touch using two PointerInput fingers, 
where both move simultaneously in opposite directions.”

🔥 BONUS (ADVANCED LINE)

👉 Add this:

“Zoom is less commonly automated, but it can be done using multi-touch sequences in W3C actions.”

⚡ SIMPLE MEMORY TRICK

👉 Swipe → 1 finger
👉 Zoom → 2 fingers*/
