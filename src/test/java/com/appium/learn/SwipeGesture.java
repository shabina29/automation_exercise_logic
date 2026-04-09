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

		// ========Details=============================
		/*
		 * 🧠 What is Kind?
		 * 
		 * 👉 Kind defines the type of input device
		 * 
		 * 
		 * ✅ Available Types
		 * 
		 * PointerInput.Kind.TOUCH // Mobile finger touch 
		 * PointerInput.Kind.MOUSE //Mouse click (desktop)
		 * PointerInput.Kind.PEN // Stylus / pen input
		 * 
		 * 
		 * 🔍 In Your Case
		 * 
		 * PointerInput.Kind.TOUCH
		 * 
		 * 👉 Means: “We are simulating a finger touch action on mobile screen”
		 * 
		 * 
		 * 🧠 Simple Understanding
		 * 
		 * 👉 Think like this:
		 * 
		 * TOUCH → finger 👆 MOUSE → laptop mouse 🖱️ PEN → stylus ✏️
		 * 
		 * 
		 * 🎯 What this line actually does
		 * 
		 * PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		 * 
		 * 👉 Meaning:
		 * 
		 * ✔ Create a virtual finger ✔ Name it "finger" ✔ Use it to perform swipe / tap
		 * actions
		 * 
		 * 
		 * 🎤 Interview Answer (BEST)
		 * 
		 * “PointerInput.Kind defines the type of input device. In mobile automation, we
		 * use TOUCH to simulate real finger interaction on the screen.”
		 * 
		 * 
		 * 🔥 Strong Answer (Impressive)
		 * 
		 * “PointerInput.Kind specifies whether the input is coming from a touch, mouse,
		 * or pen device. For mobile automation, we use TOUCH to simulate real user
		 * gestures like swipe and tap.”
		 * 
		 * 
		 * 🧠 One-Line Answer
		 * 
		 * “Kind defines the input device type, and TOUCH represents finger
		 * interaction.”
		 * 
		 * 
		 * ⚠️ Important Point
		 * 
		 * 👉 Without TOUCH: ❌ Gesture won’t behave like real mobile touch
		 * 
		 * 
		 * 🚀 Pro Tip (VERY IMPORTANT)
		 * 
		 * 👉 This is part of:
		 * 
		 * ✔ W3C Actions API ✔ Modern replacement of TouchAction (deprecated)
		 */

		// Create a sequence of actions using that finger
		// Sequence means step-by-step actions (press → move → release)
		Sequence swipe = new Sequence(finger, 1);

		// Sequence swipe = new Sequence(finger, 1);

		// Create a sequence of actions (gesture steps) for the virtual finger

		// "Sequence" → Represents a series of actions performed in order
		// Example: press → move → release (complete swipe)

		// "finger" → The input device we created earlier (virtual touch pointer)

		// "1" → Sequence ID (unique identifier for this action sequence)
		// Useful when handling multiple sequences (multi-touch gestures)

		// 👉 Meaning of this line:

		// ✔ Create a swipe action sequence
		// ✔ Attach it to the virtual finger (TOUCH input)
		// ✔ Give it an ID = 1

		// This sequence will later contain steps like:
		// - finger press (pointer down)
		// - finger move (swipe)
		// - finger release (pointer up)

		// 🎤 Interview Answer:

		// “Sequence represents a set of ordered actions performed by an input device.
		// Here, I create a swipe sequence using a touch pointer, which will later
		// include steps like press, move, and release.”

		// 🧠 One-Line Answer:

		// “Sequence defines a chain of actions for the virtual finger to perform a
		// gesture.”

		// =========================================================================================================
		// Move finger to starting point WITHOUT touching the screen
		// Duration.ZERO → instantly move pointer
		// Origin.viewport() → coordinates are based on screen
		// (500,1500) → starting position (X=middle, Y=bottom area)
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 500, 1500));
		// 👉 This line adds the FIRST step in the swipe sequence

		// swipe.addAction(...)
		// → We are adding an action (step) into the sequence we created earlier
		// → Sequence = list of steps (like instructions for the finger)

		// finger.createPointerMove(...)
		// → This defines a MOVE action for the virtual finger
		// → It tells the finger where to go

		// ------------------- PARAMETERS EXPLAINED -------------------

		// 1️⃣ Duration.ZERO
		// → Duration of movement = 0 milliseconds
		// → Means: move instantly (no delay)
		// 👉 Used to place finger immediately at starting point

		// 2️⃣ PointerInput.Origin.viewport()
		// → Origin defines reference point
		// → "viewport" means:
//      (0,0) = top-left corner of mobile screen
		// 👉 Coordinates will be based on full screen

		// 3️⃣ 500 → X coordinate
		// → Horizontal position on screen
		// → 500 means move finger to middle area (depends on screen width)

		// 4️⃣ 1500 → Y coordinate
		// → Vertical position on screen
		// → 1500 means near bottom of screen

		// ------------------- WHAT THIS LINE DOES -------------------

		// 👉 Moves the virtual finger instantly to position (500, 1500)

		// ✔ This is NOT swipe yet
		// ✔ This is just placing the finger on screen before starting gesture

		// ------------------- FULL FLOW UNDERSTANDING -------------------

		// Step 1 (THIS LINE):
		// → Move finger to starting position

		// Step 2 (next usually):
		// → Press finger (pointer down)

		// Step 3:
		// → Move finger to end position (swipe)

		// Step 4:
		// → Release finger (pointer up)

		// 🎤 Interview Answer:

		// “This line moves the virtual finger to the starting coordinates instantly.
		// It uses viewport as reference and sets the initial position before performing
		// the swipe gesture.”

		// 🧠 One-Line Answer:

		// “This moves the virtual finger to the starting point of the swipe.”

//=================================================================================================================
		// Press finger on screen (like touching mobile screen)
		// LEFT button simulates finger press
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		// 👉 This line adds the SECOND step in the swipe sequence

		// swipe.addAction(...)
		// → Adds a new action (step) to the sequence
		// → Sequence = ordered steps for gesture execution

		// finger.createPointerDown(...)
		// → Represents "finger touch down" on screen
		// → Equivalent to pressing finger on mobile screen

		// ------------------- PARAMETER EXPLAINED -------------------

		// PointerInput.MouseButton.LEFT.asArg()

		// 👉 Even though it's mobile (touch), W3C Actions internally uses "mouse
		// button"
		// 👉 LEFT button represents primary touch action (finger press)

		// ✔ LEFT = primary interaction (like single finger touch)

		// ------------------- WHAT THIS LINE DOES -------------------

		// 👉 Simulates pressing finger on screen at current position

		// ✔ This is like:
		// User touches screen with finger 👆

		// ------------------- FULL FLOW CONTEXT -------------------

		// Step 1:
		// → Move finger to starting position (previous step)

		// Step 2 (THIS LINE):
		// → Press finger down (start touch)

		// Step 3:
		// → Move finger (swipe)

		// Step 4:
		// → Release finger (pointer up)

		// 🎤 Interview Answer:

		// “This line simulates the finger touching the screen. It represents the
		// pointer down action,
		// which is the starting point of a gesture like swipe or tap.”

		// 🧠 One-Line Answer:

		// “This performs the finger press (touch down) action.”

		// =================================================================================================================
		// Move finger from start point to end point
		// Duration.ofMillis(800) → swipe happens over 800 milliseconds (smooth swipe)
		// (500,500) → end position (moving upward)
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), 500, 500));
		// 👉 This line adds the MAIN swipe movement step in the sequence

		// swipe.addAction(...)
		// → Adds another step (action) into the swipe sequence
		// → This is the movement part of swipe (most important step)

		// finger.createPointerMove(...)
		// → Moves the virtual finger from current position to new position
		// → This creates the actual swipe gesture

		// ------------------- PARAMETERS EXPLAINED -------------------

		// 1️⃣ Duration.ofMillis(800)
		// → Duration = 800 milliseconds (0.8 seconds)
		// 👉 This defines how fast or slow the swipe happens

		// ✔ Smaller value → fast swipe ⚡
		// ✔ Larger value → slow swipe 🐢

		// 2️⃣ PointerInput.Origin.viewport()
		// → Reference point = full screen (top-left = 0,0)
		// 👉 Coordinates are based on screen size

		// 3️⃣ 500 → X coordinate
		// → Horizontal position stays same
		// 👉 Means swipe is straight vertical (no left/right movement)

		// 4️⃣ 500 → Y coordinate
		// → Final vertical position
		// 👉 Moving from (500,1500) → (500,500)

		// ------------------- WHAT THIS LINE DOES -------------------

		// 👉 Moves finger from bottom → top over 800ms

		// ✔ This creates an UPWARD SWIPE gesture

		// ------------------- FULL FLOW CONTEXT -------------------

		// Step 1:
		// → Move finger to start position (500,1500)

		// Step 2:
		// → Press finger (pointer down)

		// Step 3 (THIS LINE):
		// → Move finger to (500,500) → swipe happens

		// Step 4:
		// → Release finger (pointer up)

		// 🎤 Interview Answer:

		// “This line performs the actual swipe movement. It moves the finger from the
		// starting
		// position to the end position over a defined duration, creating a smooth swipe
		// gesture.”

		// 🧠 One-Line Answer:

		// “This moves the finger to perform the swipe gesture.”
		// =================================================================================================================
		// Release finger (like lifting finger from screen)
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// 👉 This line adds the FINAL step in the swipe sequence

		// swipe.addAction(...)
		// → Adds the last action into the sequence
		// → Completes the gesture

		// finger.createPointerUp(...)
		// → Represents "finger lift" action
		// → Equivalent to releasing finger from screen

		// ------------------- PARAMETER EXPLAINED -------------------

		// PointerInput.MouseButton.LEFT.asArg()

		// 👉 LEFT represents primary touch (same as finger)
		// 👉 Even in mobile, W3C uses mouse terminology internally

		// ✔ LEFT = single finger touch

		// ------------------- WHAT THIS LINE DOES -------------------

		// 👉 Simulates lifting the finger from the screen

		// ✔ This ends the swipe gesture

		// ------------------- FULL FLOW CONTEXT -------------------

		// Step 1:
		// → Move finger to start position

		// Step 2:
		// → Finger press (pointer down)

		// Step 3:
		// → Move finger (swipe)

		// Step 4 (THIS LINE):
		// → Finger release (pointer up)

		// 🎤 Interview Answer:

		// “This line represents lifting the finger from the screen, which completes the
		// swipe gesture.”

		// 🧠 One-Line Answer:

		// “This performs the finger release (touch up) action.”

		// =================================================================================================================
		// Perform all actions together
		// singletonList → only one gesture sequence is executed
		driver.perform(Collections.singletonList(swipe));

		// 👉 This line EXECUTES the swipe action sequence

		// driver.perform(...)
		// → perform() method is used to execute W3C actions
		// → It sends all defined actions (sequence) to Appium server
		// → Appium then performs them on the real device

		// Collections.singletonList(swipe)
		// → Converts the swipe sequence into a list
		// → perform() expects a LIST of sequences (not single object)

		// 👉 singletonList means:
		// ✔ Create a list with ONLY ONE element (swipe)

		// ------------------- WHAT THIS LINE DOES -------------------

		// 👉 Takes the full swipe sequence (all steps)
		// 👉 Sends it to device
		// 👉 Executes:
//      1. Move finger to start
//      2. Finger press
//      3. Swipe movement
//      4. Finger release

		// ------------------- FULL FLOW SUMMARY -------------------

		// Step 1 → create virtual finger
		// Step 2 → create sequence
		// Step 3 → add actions (move, down, move, up)
		// Step 4 (THIS LINE) → execute all actions

		// 🎤 Interview Answer:

		// “This line executes the complete action sequence by sending it to the driver.
		// The swipe gesture is performed on the device using the defined steps.”

		// 🧠 One-Line Answer:

		// “This executes the swipe gesture on the device.”
		// =================================================================================================================
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

/*
 * 🧠 SIMPLE UNDERSTANDING (VERY IMPORTANT)
 * 
 * 👉 Think like real life:
 * 
 * Move finger to screen Touch screen Drag finger Lift finger
 * 
 * 👉 That’s exactly what this code is doing 💯
 * 
 * 🎯 INTERVIEW EXPLANATION (USE THIS 🔥)
 * 
 * 👉 Say this:
 * 
 * “I create a PointerInput to simulate a finger, then define a Sequence of
 * actions like move, press, move, and release to perform swipe using W3C
 * actions.”
 * 
 * 🔥 KEY CONCEPTS (REMEMBER) Term Meaning PointerInput Finger Sequence
 * Step-by-step actions PointerMove Move finger PointerDown Touch screen
 * PointerUp Release finger ⚡ SHORT VERSION (IF TIME LESS IN INTERVIEW)
 * 
 * 👉 Say:
 * 
 * “Swipe is performed by defining start and end coordinates using PointerInput
 * and executing press, move, and release actions.”
 */

//=================================================================================
/*
 * 🎯 ✅ HAVE YOU DONE SWIPE?
 * 
 * 👉 YES ✅
 * 
 * You implemented:
 * 
 * ✔ Press → Move → Release ✔ Using W3C Actions (PointerInput + Sequence)
 * 
 * 👉 Your flow:
 * 
 * Move → Press → Move → Release
 * 
 * 👉 So answer:
 * 
 * “Yes, I have implemented swipe using W3C actions where I simulate finger
 * press, move, and release.”
 * 
 * 🎯 ❌ HAVE YOU DONE ZOOM?
 * 
 * 👉 NO ❌ (Not yet)
 * 
 * 👉 Because:
 * 
 * Zoom requires:
 * 
 * ✔ 2 fingers (multi-touch) ✔ Two PointerInputs ✔ Moving in opposite direction
 * 
 * 🎯 DIFFERENCE (VERY IMPORTANT FOR INTERVIEW) Gesture Fingers What happens
 * Swipe 1 finger Move screen Zoom 2 fingers Expand / shrink 🎯 WHAT YOU SHOULD
 * SAY IN INTERVIEW
 * 
 * 👉 BEST ANSWER:
 * 
 * “I have implemented swipe using W3C actions. For zoom, it requires
 * multi-touch using two PointerInput fingers, where both move simultaneously in
 * opposite directions.”
 * 
 * 🔥 BONUS (ADVANCED LINE)
 * 
 * 👉 Add this:
 * 
 * “Zoom is less commonly automated, but it can be done using multi-touch
 * sequences in W3C actions.”
 * 
 * ⚡ SIMPLE MEMORY TRICK
 * 
 * 👉 Swipe → 1 finger 👉 Zoom → 2 fingers
 */
