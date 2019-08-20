package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MouseOverAndClick {

	
	WebDriver driver;

	@Test
	public void enterDataInSelectBox()
	{
		//setting driver path properties before creating driver class object else will throw an error
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		//Load a new web page in the current browser window.the method will block until the load is complete
		driver.get("https://www.actitime.com/");
		
		//BY Class- Mechanism used to locate elements within a document. In order to create your own locating mechanisms,
		//it is possible to subclass this class and override the protected methods as required
		WebElement features = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
		
		//The user-facing API for emulating complex user gestures. Use this class rather than using the Keyboard or Mouse directly.
		Actions action= new Actions(driver);
		
		action.moveToElement(features).build().perform();
		
		//Sleep the thread so to ensure mouseover is successful.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.linkText("Work Scope Management")).click();
		
		
		
		
	}
}
