package com.capgemini.interviewquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovyjarjarantlr4.v4.codegen.model.Action;
import groovyjarjarantlr4.v4.parse.ANTLRParser.actionScopeName_return;

//Question: How can you perform keyboard action "ctrl" , "alt" and "shift" using selenium webdriver

public class ActionClassWeb {
	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		// shabina.get("https://automationteststore.com/");
		wd.get("https://automationteststore.com/");
		wd.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10L)); // L is the Long data type

		By filterTextBoxLocator = By.id("filter_keyword"); // By is the class .Its and abstract class so we dont need to create
													// the object for that.All the method in the BY class is static .So
													// we dont need to create the object
		//WebElement filterTextBoxLocator1=wait.until(ExpectedConditions.invisibilityOfElementLocated(filterTextBoxLocator1));
		
	    wd.findElement(filterTextBoxLocator);
//	    WebElement filterTextBox = wait.until(ExpectedConditions.invisibilityOfElementLocated(filterTextBoxLocator));
//	    filterTextBox.sendKeys("Hello");
	    WebElement filterTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(filterTextBoxLocator));
	    filterTextBox.sendKeys("Reliance");
	    //composite action =more than one key ctrl" , "alt" and "shift
	    //simulation in composition action
	    //filterTextBox.sendKeys(Keys.CONTROL+"a");
	    
	    Actions actions=new Actions(wd);
	    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();//select all
	    Thread.sleep(5000);
	    actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform(); //Cut the text
	    Thread.sleep(5000);
	    actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	    //toggle 
	    actions.keyDown(Keys.SHIFT).sendKeys("dance").keyUp(Keys.SHIFT).perform();
	    //hover the mouse on certain element 
	    //for dynamic element use mostly the contains 
	    
	    //actions.moveToElement(wd.findElement(By.xpath("//ul[contains(@class,\"nav-pills categorymenu\")]//a[contains(text(), \"Apparel\")]"))).perform();
	    //Here the locators used is wild card 
	    //actions is system specific.not browser specific
	    //moveToElement is used to hover
	    By linkNavLocator= By.xpath("//ul[contains(@class,\"nav-pills categorymenu\")]//a[contains(text(),\"Apparel\")]");
	    actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(linkNavLocator))).perform();
	}

}
