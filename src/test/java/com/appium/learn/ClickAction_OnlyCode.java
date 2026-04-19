package com.appium.learn;

import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ClickAction_OnlyCode {

    static AppiumDriver driver;

    public static void main(String[] args) throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("app", "D:\\Software\\Automation\\SwagLabAPK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("noReset", false);
        cap.setCapability("appWaitActivity", "*");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginClick();

        Thread.sleep(3000);

        driver.quit();
    }

    public static void loginClick() {

        By loginBtn = AppiumBy.accessibilityId("test-LOGIN");

        driver.findElement(loginBtn).click();

        System.out.println("Login button clicked successfully");
    }
}