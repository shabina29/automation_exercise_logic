package com.appium.learn;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class AppLaunchTest {

    public static void main(String[] args) throws Exception {

        // ================= CAPABILITIES SETUP =================
        // DesiredCapabilities ka use karke hum device aur app configuration define karte hain
        DesiredCapabilities cap = new DesiredCapabilities();

        // Platform define karna (Android device)
        cap.setCapability("platformName", "Android");

        // Device name (emulator ya real device)
        cap.setCapability("deviceName", "emulator-5554");

        // Automation engine (Appium uses UiAutomator2 for Android)
        cap.setCapability("automationName", "UiAutomator2");

        // ================= APK PATH =================
        // Ye APK ka exact path hai jisse Appium app install karega
        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // ================= APP LAUNCH FIX =================
        // Direct correct activity launch karne ke liye (important for stability)
        cap.setCapability("appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        // ================= STABILITY SETTINGS =================
        // Permissions automatically allow ho jaye
        cap.setCapability("autoGrantPermissions", true);

        // Har run me fresh app install ho
        cap.setCapability("noReset", false);
        
     // 🔥 FIXES
        cap.setCapability("uiautomator2ServerLaunchTimeout", 60000);
        cap.setCapability("adbExecTimeout", 60000);
        cap.setCapability("androidInstallTimeout", 90000);

        /*👉 Case 1: noReset = false

✔ App open → Login screen
✔ हर बार credentials डालने पड़ेंगे

👉 Case 2: noReset = true

✔ App open → Already logged in
✔ Direct home screen*/
        
        // ================= DRIVER INITIALIZATION =================
        // Appium server se connection establish karke app launch hota hai
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), cap
        );

        // Implicit wait (elements load hone ke liye wait)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Console log
        System.out.println("✅ App Launched Successfully");

        // App ko dekhne ke liye wait (demo purpose)
        Thread.sleep(5000);

        // ================= CLOSE SESSION =================
        // Driver quit karne se session close ho jata hai aur app band ho jata hai
        driver.quit();
    }
}

/*
================= INTERVIEW EXPLANATION =================

In this script, I first set up DesiredCapabilities to define the platform,
device, and automation engine.

Then I provided the APK path so Appium can install the application on the emulator.

To ensure stable app launch, I also specified the appPackage and appActivity,
which helps bypass issues like splash screen delays.

After that, I initialized the AndroidDriver to connect with the Appium server
and launch the app. I applied an implicit wait for element synchronization.

Finally, I validated the app launch and closed the session using driver.quit().

=========================================================

“The emulator name like emulator-5554 is dynamically assigned based on available ports. 
It usually starts from 5554 for the first emulator and increments for additional instances. 
I verify the device using adb devices before execution.”

=========================================================
Eclipse (Client)
   ↓
Appium Server (localhost:4723)
   ↓
Device (Emulator)
=========================================================
💡 IMPORTANT POINT

👉 Ye line:

new URL("http://127.0.0.1:4723")

👉 isi Appium server ko point karti hai

📍 127.0.0.1 ka matlab?

👉 Ye hota hai:

Local machine (tumhara laptop)

👉 Isliye:

✔ Server tumhare system me hi run ho raha hai
✔ Internet pe nahi

🧠 INTERVIEW ANSWER (READY 🔥)

👉 Tum bol सकती हो:

“Appium server runs locally on my system and listens on http://127.0.0.1:4723
. My automation script communicates with this server, which then interacts with the mobile device.”


*/

/*
================= DRIVER INITIALIZATION EXPLANATION =================

In this line, I am creating an instance of AndroidDriver, which is used
to interact with the Android device or emulator.

The URL "http://127.0.0.1:4723" represents the Appium server running locally.
Through this server, the automation commands are sent to the device.

The 'cap' object contains DesiredCapabilities, which define the device
configuration and application details such as platform, device name,
automation engine, and app information.

Once this driver is initialized, it establishes a session between the
test script and the mobile device, allowing us to perform automation actions.

=========================================================

🧠 DETAIL ME SAMJHO (HINGLISH)

👉 जब तुम ये code लिखती हो:

driver.findElement(...).click();

👉 तुम्हें लगता है ये direct device pe ja raha hai ❌

👉 Actually kya hota hai:

🔥 REAL FLOW
✅ Step 1: तुम code लिखती हो

👉 Java code:

driver.findElement(...).click();
✅ Step 2: Appium Java Client काम करता है

👉 ये library (dependency jo tumne pom me add ki):

io.appium java-client

👉 ये internally:

✔ Tumhare method ko convert karta hai
✔ Into JSON request

📦 Example (internally)
{
  "command": "click",
  "elementId": "123"
}
✅ Step 3: JSON → Appium Server

👉 Ye JSON request bheji jaati hai:

http://127.0.0.1:4723
🎯 FINAL ANSWER (INTERVIEW READY 🔥)

👉 Tum confidently bolo:

“The Appium client library, which is the Java client in my case, 
converts my test commands into JSON format. 
These JSON requests are then sent to the Appium server for further processing.”

=======================================================================================
Question:whenever I am installing a new emulator on my device, every time the emulator is 5554. 
This emulator always remains the same in the one system or it changes from one system to another system.
🔥 ANSWER (SIMPLE)

👉 emulator-5554 fixed नहीं होता
👉 ये dynamic port number based name है

🧠 कैसे काम करता है?

👉 जब भी emulator start होता है:

First emulator →
emulator-5554
Second emulator →
emulator-5556
Third emulator →
emulator-5558

👉 मतलब:
✔ हर नया emulator → next even port लेता है

📌 IMPORTANT POINT

👉 ये system-specific नहीं है
👉 ये runtime पर decide होता है

🔁 SAME SYSTEM पर क्या होगा?

👉 अगर:

✔ सिर्फ 1 emulator run कर रही हो
👉 हमेशा:

emulator-5554

✔ अगर 2 emulator run किए
👉 second:

emulator-5556
🔁 DIFFERENT SYSTEM पर?

👉 same logic:

✔ First emulator → 5554
✔ Second → 5556

👉 BUT:
👉 अगर already device connected है (real device / previous emulator)

👉 तो numbering बदल सकती है 🔥

🧪 कैसे verify करें?

👉 हमेशा run करो:

adb devices

👉 Output:

emulator-5554   device

👉 यही use करना है code में ✔️

🚨 BEST PRACTICE (INTERVIEW GOLD 🔥)

👉 hardcode मत करो blindly

👉 बोलना:

“I verify the connected device using adb devices and dynamically use the device name in my capabilities.”

💡 PRO TIP

👉 Better approach:

cap.setCapability("deviceName", "Android Emulator");

👉 ये generic है ✔️
👉 dynamic handling better है

🧠 INTERVIEW READY ANSWER

👉 बोलना:

“The emulator name like emulator-5554 is dynamically assigned based on available ports. 
It usually starts from 5554 for the first emulator and increments for additional instances. 
I verify the device using adb devices before execution.”
*/