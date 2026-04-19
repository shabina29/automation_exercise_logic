package com.selenium.learn;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch_Browser {
	// This is the class definition. Java execution starts from the main method
	// inside this class.

	public static void main(String[] args) {
		// Main method → entry point of Java program.
		// JVM (Java Virtual Machine) starts execution from here.

		WebDriverManager.chromedriver().setup();
		// This line automatically downloads the correct version of ChromeDriver.
		// It also sets the system property internally so Selenium can use it.

		WebDriver driver = new ChromeDriver();
		// WebDriver is an interface → driver is reference variable.
		// ChromeDriver() is an object → actual implementation.
		// This line launches a new Chrome browser instance.
		// Internally, Selenium sends commands to ChromeDriver, which opens Chrome
		// browser.

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// This sets implicit wait of 10 seconds.
		// It tells Selenium to wait up to 10 seconds to find elements before throwing
		// exception.

		driver.manage().window().maximize();
		// This maximizes the browser window for better visibility during execution.

		driver.get("https://demoqa.com");
		// This command launches the given URL in the browser.
		// Internally:
		// 1. Selenium sends request to ChromeDriver
		// 2. ChromeDriver communicates with Chrome browser
		// 3. Browser loads the URL just like a user enters it manually

		System.out.println("The Homepage is launched successfully");
		// This prints the message in console.
		// Used for logging or verification during execution.

		driver.quit();
		// Closes all browser windows opened by Selenium.
		// Ends the WebDriver session completely.
	}
}

/*
 * 🔥 Interview-Level Explanation (Very Important)
 * 
 * If interviewer asks: “How browser is launched internally?”
 * 
 * 👉 You can say:
 * 
 * “When we create a ChromeDriver object, Selenium uses WebDriver protocol to
 * send commands to the ChromeDriver executable. ChromeDriver then acts as a
 * bridge between Selenium and the Chrome browser, and it launches the browser
 * instance and executes commands like opening a URL.”
 * 
 * 💯 Key Terms You MUST Remember WebDriver → Interface ChromeDriver →
 * Implementation class WebDriverManager → Driver setup automation driver.get()
 * → Opens URL Implicit Wait → Global wait for elements driver.quit() → Closes
 * browser session
 * ===========================================================================
 * 
 * 🚀 How Your Code Runs (Step by Step) 1️⃣ Java Program Starts public static
 * void main(String[] args)
 * 
 * 👉 JVM (Java Virtual Machine) starts execution from main() method.
 * 
 * 2️⃣ WebDriverManager Setup WebDriverManager.chromedriver().setup();
 * 
 * 👉 What happens internally:
 * 
 * Checks your Chrome browser version Downloads matching ChromeDriver Sets
 * system property automatically
 * 
 * 💡 Earlier we used:
 * 
 * System.setProperty("webdriver.chrome.driver", "path");
 * 
 * Now WebDriverManager handles this.
 * 
 * 3️⃣ WebDriver Object Creation WebDriver driver = new ChromeDriver();
 * 
 * 👉 This is the MOST IMPORTANT LINE
 * 
 * Internally: WebDriver → Interface (only defines methods) ChromeDriver →
 * Actual implementation
 * 
 * 💥 When this line runs:
 * 
 * ChromeDriver executable starts It opens a new Chrome browser A session is
 * created between Selenium and browser 🔗 How Selenium Talks to Chrome (CORE
 * CONCEPT) 🔥 Real Flow (Interview Gold Answer)
 * 
 * 👉 You can say this:
 * 
 * “Selenium does not directly control the browser. It uses ChromeDriver as a
 * bridge. Selenium sends commands in the form of HTTP requests using WebDriver
 * protocol. ChromeDriver receives these requests, converts them into
 * browser-specific actions, and then executes them in the Chrome browser.”
 * 
 * 📊 Flow Diagram (Very Important) Your Java Code ↓ Selenium WebDriver API ↓
 * WebDriver Protocol (HTTP Request) ↓ ChromeDriver (Bridge) ↓ Chrome Browser 🌐
 * Example: When You Run This Line driver.get("https://demoqa.com");
 * 
 * 👉 Internally:
 * 
 * Selenium sends HTTP request:
 * 
 * POST /session/{id}/url ChromeDriver receives it ChromeDriver tells Chrome: 👉
 * “Open this URL” Browser loads the page ⏳ Implicit Wait Execution
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 * 
 * 👉 Means:
 * 
 * For every element search Selenium will wait up to 10 sec before failing 🖥️
 * Browser Actions driver.manage().window().maximize();
 * 
 * 👉 Sends command → ChromeDriver → Browser maximizes window
 * 
 * ❌ Closing Browser driver.quit();
 * 
 * 👉 Internally:
 * 
 * Ends session Closes all browser windows Stops ChromeDriver 🎯 Final Interview
 * Answer (Perfect Script)
 * 
 * 👉 If interviewer asks: “How Selenium interacts with browser?”
 * 
 * Say this:
 * 
 * “Selenium interacts with the browser using WebDriver architecture. My test
 * code sends commands using Selenium WebDriver API. These commands are
 * converted into HTTP requests using WebDriver protocol. ChromeDriver acts as a
 * bridge and receives these requests, then it communicates with the Chrome
 * browser and performs the actions like opening URL, clicking elements, etc.”
 * 
 * 💡 One Line Memory Trick
 * 
 * 👉 Selenium → Sends command 👉 ChromeDriver → Translates command 👉 Browser →
 * Executes command
 */
