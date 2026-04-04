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
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), 500, 1500)); // start point

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(800),
                PointerInput.Origin.viewport(), 500, 500)); // end point

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));

        System.out.println("Swipe performed");

        Thread.sleep(3000);
        driver.quit();
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

}