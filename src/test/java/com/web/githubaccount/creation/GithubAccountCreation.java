package com.web.githubaccount.creation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubAccountCreation {
	public static void main(String[]args)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start-maximize");
		WebDriver wd=new ChromeDriver(options);
		wd.get("https://github.com/signup");
		
		WebDriverWait wait=new WebDriverWait(wd, Duration.ofSeconds(10));
		
		By emailTextBoxLocator=By.id("email");
		WebElement EmailTextBox=wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBoxLocator));
		EmailTextBox.sendKeys("shahinshabina4321@gmail.com");
		
		By passwordTextBoxLocator=By.id("password");
		WebElement PasswordTextBox=wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
	    PasswordTextBox.sendKeys("Test@123");
	    
	    By usernameTextBoxLocator=By.id("login");
	    WebElement UserNameTextBox=wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBoxLocator));
	    UserNameTextBox.sendKeys("abcd");
	    
	    By countryDropDownButtonLocator = By.xpath("//button[contains(@id,\"select-panel\") and @aria-labelledby=\"country-dropdown-label\"]");
	    WebElement countryDropDownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropDownButtonLocator));
	    countryDropDownButton.click();

	    By countrySearchTextBoxLocator = By.xpath("//input[contains(@id,\"select-panel\") and @type=\"search\"]");
	    WebElement countrySearchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchTextBoxLocator));
	    countrySearchTextBox.sendKeys("Albania");

	    By countryButtonLocator = By.xpath("//span[contains(text(),\"Albania\")]/..");
	    WebElement countryButton = wait.until(ExpectedConditions.visibilityOfElementLocated(countryButtonLocator));
	    countryButton.click();

	    By userConsentCheckBoxLocator = By.id("user_signup[marketing_consent]");
	    WebElement userConsentCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(userConsentCheckBoxLocator));
	    userConsentCheckBox.click();
	    
		
	}

}
