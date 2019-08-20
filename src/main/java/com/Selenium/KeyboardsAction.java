package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardsAction {

	
	WebDriver driver;

	@Test
	public void openingLinkInNewTab()
	{
		//setting driver path properties before creating driver class object else will throw an error
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//Load a new web page in the current browser window.the method will block until the load is complete
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
		Actions action = new Actions(driver);
		
		WebElement elementToOpenInNewTab = driver.findElement(By.xpath("//*[text()='Forgotten account?']"));
		
		action.keyDown(Keys.CONTROL).click(elementToOpenInNewTab).keyUp(Keys.CONTROL).build().perform();
	}	
	
	@Test
	public void enteringDataInCapsViaKeyBoard()
	{
		//setting driver path properties before creating driver class object else will throw an error
				System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
				driver= new ChromeDriver();
				driver.manage().window().maximize();
				
				//Load a new web page in the current browser window.the method will block until the load is complete
				driver.get("https://www.facebook.com/");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement email = driver.findElement(By.name("reg_email__"));
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		
		Actions action= new Actions(driver);
		
		action.keyDown(firstName,Keys.SHIFT).sendKeys("Atul").keyUp(firstName, Keys.SHIFT).build().perform();
		action.keyDown(lastName,Keys.SHIFT).sendKeys("Upadhyay").keyUp(lastName, Keys.SHIFT).build().perform();
		action.keyDown(email,Keys.SHIFT).sendKeys("Atulupadhyay82@gmail.com").keyUp(email, Keys.SHIFT).build().perform();
		action.keyDown(password,Keys.SHIFT).sendKeys("5663322").keyUp(password, Keys.SHIFT).build().perform();
	}
		
		
}
