package com.api.learn;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksInterviewQuestion {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://eddymens.com/blog/page-with-broken-pages-for-testing-53049e870421");

        // Step 1: Get all links
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Step 2: Loop through links
        for (WebElement link : links) {

            String url = link.getAttribute("href");

            // Skip null or empty links
            if (url == null || url.isEmpty()) {
                continue;
            }

            try {
                // Step 3: Create connection
                URL linkUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();

                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();

                // Step 4: Validate response
                if (responseCode >= 400) {
                    System.out.println(url + " --> Broken Link (" + responseCode + ")");
                } else {
                    System.out.println(url + " --> Valid Link (" + responseCode + ")");
                }

            } catch (Exception e) {
                System.out.println(url + " --> Error");
            }
        }

        driver.quit();
    }
}

/*🎯 Interview answer
Writing

In Maven, src/main/java is used for executable application code, while src/test/java is used for test classes. 
Since my class contains a main method and is executed as a standalone program, I moved it to the main directory.

🎯 2️⃣ Interview me kaise explain karna hai?

👉 Short + clean answer:

Writing

To identify broken links, I used Selenium to extract all anchor tags from the webpage.
 Then, I retrieved the href attribute of each link and used HttpURLConnection to send a request. 
 Based on the response code, I classified links as valid (200) or broken (4xx/5xx).

👉 Agar interviewer deep pooche:

Writing

I used the HEAD request method instead of GET to improve performance, 
as it only fetches headers and not the entire response body.

🎯 3️⃣ Code ka logic (VERY SIMPLE — step by step)

Ab main tumhe real simple Hindi me explain karti hoon 👇

🔹 Step 0: Browser open
WebDriver driver = new ChromeDriver();
driver.get("URL");

👉 Browser open + website load

🔹 Step 1: Saare links nikaalo
List<WebElement> links = driver.findElements(By.tagName("a"));

👉 <a> tag = hyperlink

👉 Example:

<a href="https://google.com">

👉 Matlab:
➡️ Page ke saare links list me aa gaye

🔹 Step 2: Loop lagao
for (WebElement link : links)

👉 Har link ko ek-ek karke check kar rahe hain

🔹 Step 3: URL nikalo
String url = link.getAttribute("href");

👉 Link ka actual URL mil gaya

🔹 Step 4: Null skip
if (url == null || url.isEmpty()) continue;

👉 Kuch links me URL nahi hota → skip

🔹 Step 5: Connection banao
URL linkUrl = new URL(url);
HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();

👉 Browser ke bahar se direct request bhej rahe hain

🔹 Step 6: Request bhejo
connection.setRequestMethod("HEAD");
connection.connect();

👉 HEAD = fast check (body download nahi karta)

🔹 Step 7: Response lo
int responseCode = connection.getResponseCode();

👉 Server kya bol raha hai:

Code	Meaning
200	OK
404	Not Found
500	Server error
🔹 Step 8: Result print
if (responseCode >= 400)

👉 >= 400 = broken link

🔹 Step 9: Exception handle
catch (Exception e)

👉 Agar request fail ho jaye → error print

🔹 Step 10: Browser close
driver.quit();
🧠 🔥 EASY STORY (Yaad rakhne ke liye)

👉 Socho:

Website kholo
Saare links uthao
Har link pe call karo
Check karo:
200 → OK
404/500 → broken
💯 FINAL INTERVIEW SUMMARY (BEST)
Writing

I open the webpage using Selenium and collect all anchor tags.
 Then, I extract each link's URL and validate it using HttpURLConnection by sending a HEAD request. 
 Based on the response code, I identify whether the link is valid or broken.

🚀 NEXT STEP (Highly Recommended)

👉 Ab tum ready ho next level ke liye:

Convert this into TestNG test
Add assertions
Add reporting*/